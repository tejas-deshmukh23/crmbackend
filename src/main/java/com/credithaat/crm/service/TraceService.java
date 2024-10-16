package com.credithaat.crm.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credithaat.crm.entity.hicredit.Apply;
import com.credithaat.crm.entity.hicredit.QApply;
import com.credithaat.crm.entity.hicredit.QProduct;
import com.credithaat.crm.entity.hicredit.QTrace;
import com.credithaat.crm.entity.hicredit.Trace;
import com.credithaat.crm.repository.ApplyRepository;
import com.credithaat.crm.repository.TraceRepository;
import com.credithaat.crm.util.ObjResponse;
import com.credithaat.crm.util.StringUtil;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
public class TraceService {
	
	@Autowired
	TraceRepository traceRepository;
	@Autowired
	ApplyRepository applyRepository;
	
	@Autowired
	private JPAQueryFactory queryFactory;

	public ObjResponse updateLead(String applyId, String tracer, String calledNumber, String content, String traceTime,
			String abandoningReason, String callDisposition, String subCallDisposition, String nextActionDate,
			String disbursementAmount,Integer status) {
		
		ObjResponse resp = new ObjResponse();
		Long applyId1;
		applyId1 =Long.parseLong(applyId);
		Optional<Apply> optionalApply = applyRepository.findById(applyId1);
		if(optionalApply.isPresent()) {
			Apply apply = optionalApply.get();
			
			if(StringUtil.notEmpty(disbursementAmount)) {
				apply.setDisbursed(disbursementAmount);
			}
			
			if( status!= null && status == 3 || status == 5) { //Here we have added 3 for 4 and 5 for 7   
				apply.setPriority(null);
			}
			
			int counter = apply.getTrace_count()+1;
			apply.setTrace_count(counter);
			applyRepository.save(apply);
			
			Trace trace = new Trace();
			trace.setApplyId(Integer.parseInt(applyId));
			
			if(status!=null)
			{
				String[] arr = "Data Submitted,App Downloaded,Loan Applied,Approved,Rejected,Disbursed,Form Filled,Abandoned,offline,call back".split(",");
				trace.setContent(tracer + " set status to "+arr[status]);
			}else {
				trace.setContent(content);
			}
			
			if(StringUtil.notEmpty(abandoningReason))
			{
				trace.setReason(Integer.parseInt(abandoningReason));
				String[] reasons = "Cx not interested,Cx does not receive salary in account,Cx is not salaried,Cx does not meet criteria of lenders".split(",");
	            apply.setContent("Abandoning Reason:"+reasons[trace.getReason()]);
	            if(trace.getReason()==5){ //here also we have replaced 7 with 5 because our abondoned is on 5th index
	                apply.setPriority(null);
	                apply.setNextActionDate(null);
	            }
	            applyRepository.save(apply);
			}
			
			
			if(StringUtil.notEmpty(callDisposition)) {
				String[] arr = "Connected,Not Connected, Action, Abandoned".split(",");
				trace.setContent1(tracer + " set status to "+arr[Integer.parseInt(callDisposition)]);
			}
			
			if(StringUtil.notEmpty(subCallDisposition)) {
				trace.setReason1(Integer.parseInt(subCallDisposition));
				String[] reasons = "Interested,Not Interested,Future Prospect,Ringing,Disconnected,Waiting,Incoming Call Not Alowed,Switch off,Link shared of other lender,Will upload Doc,Complete Doc,Mandate Pending,Disbusment Pending,Salary Cash,Existing Customer,Criteria Not Meet"
						.split(",");
				apply.setMessage1("Sub Call Disposition Reason:" + reasons[trace.getReason1()]);
				if (trace.getReason1() == 7) {
					apply.setPriority(null);
					apply.setNextActionDate(null);
					
					applyRepository.save(apply);
				}
			}
			
			trace.setTraceTime(new Date());
			trace.setProductName(apply.getProduct().getProductName());
			trace.setUserPhone(apply.getUserinfo().getMobilenumber());
			trace.setCaller(tracer);
			try {
				if(StringUtil.notEmpty(nextActionDate)) {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");        
					Date naDate = format.parse(nextActionDate);
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(naDate);
					calendar.add(calendar.DAY_OF_YEAR, 0); 
					naDate = calendar.getTime();
					trace.setNextActionDate(naDate);
					apply.setNextActionDate(naDate);                           	 
					applyRepository.save(apply);
				}
			}catch(Exception e) {
				
			}
			
			traceRepository.save(trace);
			
		}
		
		
		
		
		return resp;
		
	}
	
	
//	public List<Trace> getTraceByDate(Date startDate, Date endDate, String product)
//	{
//		
//		return queryFactory
//                .selectFrom(QTrace.trace)
//                .where(QTrace.trace.traceTime.between(startDate, endDate))
//                .fetch();
//		
////		return null;
//	}
	
	public List<Trace> getTraceByDate(Date startDate, Date endDate, List<String> product1)
	{
		
		BooleanExpression predicate = QTrace.trace.isNotNull(); 
		
//		QApply apply = QApply.apply;
//	    QProduct product = QProduct.product;
	    QTrace trace = QTrace.trace;
	    
	    if (product1 != null && !product1.isEmpty()) {
	        predicate = predicate.and(trace.productName.in(product1));
	    }
	    
//	    if(startDate!= null && endDate == null)
//	    {
//	    	predicate = predicate.and(trace.traceTime.eq(startDate));
//	    }
//	    
//	    if(endDate!= null && startDate == null)
//	    {
//	    	predicate = predicate.and(trace.traceTime.eq(endDate));
//	    }
	    
	 // Handle startDate and endDate comparisons
	    if (startDate != null && endDate == null) {
	        // Only compare against startDate
	        predicate = predicate.and(trace.traceTime.goe(startDate)); // greater than or equal to startDate
	        predicate = predicate.and(trace.traceTime.lt(Date.from(startDate.toInstant().plus(1, ChronoUnit.DAYS)))); // less than the next day
	    }

	    if (endDate != null && startDate == null) {
	    	 predicate = predicate.and(trace.traceTime.goe(endDate)); // greater than or equal to startDate
		        predicate = predicate.and(trace.traceTime.lt(Date.from(endDate.toInstant().plus(1, ChronoUnit.DAYS)))); // less than the next day
	    }
	    
	    if(startDate!= null && endDate!= null)
	    {
	    	predicate = predicate.and(trace.traceTime.between(startDate, endDate));
	    }
	    
	    return queryFactory
	    		.selectFrom(trace)
	    		.where(predicate)
	    		.fetch();
	    
		
//		return queryFactory
//                .selectFrom(QTrace.trace)
//                .where(QTrace.trace.traceTime.between(startDate, endDate))
//                .fetch();
//		
//		return null;
	}

}
