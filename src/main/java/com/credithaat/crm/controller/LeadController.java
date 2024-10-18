package com.credithaat.crm.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import com.auth0.jwt.internal.com.fasterxml.jackson.core.JsonProcessingException;
//import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.credithaat.crm.entity.hicredit.Apply;
import com.credithaat.crm.entity.hicredit.GlobalEntity;
import com.credithaat.crm.entity.hicredit.Product;
import com.credithaat.crm.entity.hicredit.Trace;
//import com.credithaat.crm.entity.hicredit.QApply;
import com.credithaat.crm.entity.hicredit.UserInfo;
import com.credithaat.crm.service.LeadService;
import com.credithaat.crm.service.TraceService;
import com.credithaat.crm.util.ObjResponse;
import com.credithaat.crm.util.SearchResponse;
import com.querydsl.core.types.dsl.BooleanExpression;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
	        
@CrossOrigin("*")
@RestController
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private TraceService traceService;
	
	@GetMapping("/tejas")
	public String tejas() {
		return "Tejas";
	}
	
	@GetMapping("/findAll")
	public List<SearchResponse> findAll() { 
		
		List<Apply> applyRecords = leadService.findAll();
		
		List<SearchResponse> searchResponseList = new ArrayList();
		
		UserInfo userInfo = new UserInfo();
		Product product = new Product();
		
		for(Apply apply : applyRecords)
		{
			
			SearchResponse searchResponse = new SearchResponse();
			
			searchResponse.setApply(apply);
			searchResponse.setProduct(apply.getProduct());
			searchResponse.setUserInfo(apply.getUserinfo());
			
			searchResponseList.add(searchResponse);
			
		}
		
		return searchResponseList;
    }
	
	@GetMapping("/findByStatus")
	public List<Apply> findByStatus(Integer status) {
      
		System.out.println("Inside the syso"+leadService.findByStatus(1));
		
		return leadService.findByStatus(0);
		             
    }
	
	@GetMapping("/findByAgent")
	public List<Apply> findByAgent()
	{
		return leadService.findByAgent("LoanDestination");
	}
	
//	 @PostMapping("/search")
//	    public List<Apply> search(@RequestParam(name = "agent") String agent,@RequestParam(name="status") Integer status,@RequestParam(name = "applyDate") Date applyTime,@RequestParam(name="phone") String phone, HttpServletRequest request, HttpServletResponse response) {
//	        return leadService.search("BTI", null, null, phone);
//	 }
	
	@PostMapping("/search")
	@ResponseBody
//	public List<Map<Apply, UserInfo>> search(
	public List<SearchResponse> search(
//	    @RequestParam(name = "agent", required = false) String agent, 
	    @RequestParam(name = "status", required = false) Integer status, 
	    @RequestParam(name = "phone", required = false) String phone,  
	    @RequestParam(name = "product", required = false) String product1,
	    @RequestParam(name = "customerName", required = false) String customerName,
	    HttpServletRequest request,
	    HttpServletResponse response
	) {
		
//		ObjResponse<List<Map<Apply,UserInfo>>> resp = new ObjResponse<>();
		
		  List<Apply> applyList = leadService.search(status, null, phone, product1, customerName);
	        
	        List<Map<Apply, UserInfo>> mapList = new ArrayList();
		
		 try {
//		        List<Apply> applyList = leadService.search(null, null, null, phone);
//		        
//		        List<Map<Apply, UserInfo>> mapList = new ArrayList();
//		        List<appInfo> list = new ArrayList();
		        
//		        SearchResponse searchResponse = new SearchResponse();
//		        searchResponse.setApplyList(applyList);
		        
		        Map<Apply,UserInfo> mapData = new HashMap();
		        
		        UserInfo userInfo = new UserInfo();
		        
		        Product product = new Product();        
		        
		        
		        
		        List<SearchResponse> searchResponseList = new ArrayList();
		        
//		        searchResponse.setUserInfo()
		        for(Apply applyRecord : applyList) {
		        	
		        	SearchResponse searchResponse = new SearchResponse();
		        	searchResponse.setApply(applyRecord);
		        	
		        	userInfo = applyRecord.getUserinfo();
		        	searchResponse.setUserInfo(userInfo);
		        	
		        	product = applyRecord.getProduct();
		        	searchResponse.setProduct(product);
		        	
		        	searchResponseList.add(searchResponse);
		        	
		        
		        	mapData.put(applyRecord,userInfo);
		        	mapList.add(mapData);
		        }
		        
//		        resp.setCode(0); // Assuming 0 indicates success
//		        resp.setMsg("Successful");
//		        resp.setList(mapList);
		        
//		        return mapList;
		        return searchResponseList;
		    } catch (Exception e) {
//		        resp.setCode(1); // Non-zero code for errors
//		        resp.setMsg("Error occurred: " + e.getMessage());
//		        resp.setObj(Collections.emptyList()); // Optionally return an empty list on error
		    }
		    
		  return null; 
		
	}
//	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
	@PostMapping("/updateLead") 
	@ResponseBody 
	public ObjResponse updateLead(
							  @RequestParam(name="applyId", required=false) String applyId,
							  @RequestParam(name="tracer", required=false) String tracer,
							  @RequestParam(name="calledNumer", required=false) String calledNumber,
							  @RequestParam(name = "content", required=false) String content,
//							  @RequestParam(name="traceTime", required=false) ZonedDateTime traceTime,
							  @RequestParam(name="traceTime", required=false) String traceTime,
							  @RequestParam(name="abandoningReason"  , required=false) String abandoningReason,
							  @RequestParam(name="callDisposition", required=false) String callDisposition,
							  @RequestParam(name="subCallDisposition", required=false) String subCallDisposition,
							  @RequestParam(name="nextActionDate", required=false) String nextActionDate,
							  @RequestParam(name="disbursementAmount", required=false) String disbursementAmount,
							  @RequestParam(name="status", required=false) Integer status) {

		
		return traceService.updateLead(applyId, tracer, calledNumber, content, traceTime , abandoningReason, callDisposition, subCallDisposition, nextActionDate, disbursementAmount, status);
		
	}
	
//	@PostMapping("/updateLead") 
//	@ResponseBody 
//	public ObjResponse updateLead(
//							 ) {
//		
//		ObjResponse resp = new ObjResponse();
//		
//		
//		
//		return resp;
//		
//	}
	
	@PostMapping("/searchTLPanelLeads") 
	@ResponseBody 
	public List<SearchResponse> updateLead(
							  @RequestParam(name="product", required=false) String product1,
							  @RequestParam(name="stages", required=false) Integer status,
							  @RequestParam(name="leadType", required=false) Integer leadType,
//							  @RequestParam(name = "applyTime", required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date applyTime,
//							  @RequestParam(name = "applyTime", required=false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date applyTime,
							  @RequestParam(name = "applyTime", required=false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime applyTime,
							  @RequestParam(name="state", required=false) String state,
							  @RequestParam(name="city", required=false) String city,
							  @RequestParam(name="tier"  , required=false) Integer tier) {
				
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	    String formattedDate = sdf.format(applyTime);
//		System.out.print("Date is :: "+formattedDate);
		
//		SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
//        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        
//        Date date = null;
//        Date date2= null;
//        Date applyTime1;
//        try {
//            date = inputFormat.parse(applyTime1);
//            String date3 = outputFormat.format(date);
////            return outputFormat.format(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
		
		List<Apply> applyRecords = leadService.tlPanelLeadsSearch( product1, status,  leadType,  applyTime,  state,  city,  tier);
		
		try {
			
			List<SearchResponse> searchResponseList = new ArrayList();
			
			UserInfo userInfo = new UserInfo();
			Product product = new Product();
			
			for(Apply apply : applyRecords)
			{
				
				SearchResponse searchResponse = new SearchResponse();
				
				searchResponse.setApply(apply);
				searchResponse.setProduct(apply.getProduct());
				searchResponse.setUserInfo(apply.getUserinfo());
				
				searchResponseList.add(searchResponse);
				
			}
			
//			GlobalEntity globalEntity = new GlobalEntity();
//			globalEntity.setSearchResponseList(searchResponseList);
			
			GlobalEntity.setSearchResponseList(searchResponseList);
			
			return searchResponseList;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
		
//		return leadService.tlPanelLeadsSearch( product1, status,  leadType,  applyTime,  state,  city,  tier);
		
	}
	
	@PostMapping("/traceByDate")
	@ResponseBody
	public List<Trace> getTraceByDate(@RequestParam(name="startDate", required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate, @RequestParam(name="endDate", required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate, @RequestParam(name="product", required=false) List<String> product1)
	{
		return traceService.getTraceByDate(startDate, endDate, product1);
	}
	

}
