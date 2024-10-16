package com.credithaat.crm.service;
 
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.credithaat.crm.entity.hicredit.Apply;
import com.credithaat.crm.entity.hicredit.QApply;
import com.credithaat.crm.entity.hicredit.QMaster_City_State;
import com.credithaat.crm.entity.hicredit.QProduct;
import com.credithaat.crm.entity.hicredit.QUserInfo;
import com.credithaat.crm.util.StringUtil;
//import com.credithaat.crm.entity.hicredit.QApply;
//import com.credithaat.crm.entity.hicredit.QProduct;
//import com.credithaat.crm.entity.hicredit.QUserInfo;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;


@Service
public class LeadService {
	
	@Autowired
	private JPAQueryFactory queryFactory;
//	
//	public LeadService(EntityManager entityManager) {
//        this.queryFactory = new JPAQueryFactory(entityManager);
//    }

    @Transactional(readOnly = true)
    public List<Apply> findAll() {
        return queryFactory.selectFrom(QApply.apply).join(QApply.apply.userinfo, QUserInfo.userInfo)
                .join(QApply.apply.product, QProduct.product).limit(10).fetch();
    }

    @Transactional(readOnly = true)
    public List<Apply> findByAgent(String agent) {
        return queryFactory
                .selectFrom(QApply.apply)
                .where(QApply.apply.agent.eq(agent))
                .fetch();
    }

    @Transactional(readOnly = true)
    public List<Apply> findByStatus(Integer status) {
        return queryFactory
                .selectFrom(QApply.apply)
                .where(QApply.apply.status.eq(status))
                .fetch();
    }

    @Transactional(readOnly = true)
    public List<Apply> findByDateRange(Date startDate, Date endDate) {
        return queryFactory
                .selectFrom(QApply.apply)
                .where(QApply.apply.applyTime.between(startDate, endDate))
                .fetch();
    }

    @Transactional(readOnly = true)
    public List<Apply> search(Integer status, Date applyTime, String phone, String product1, String customerName) {
        BooleanExpression predicate = QApply.apply.isNotNull();
        
        QUserInfo userInfo = QUserInfo.userInfo; // Create an instance of QUserInfo
        
        QProduct product = QProduct.product; // Create an instance of QProduct
        
//        if (agent != null && agent != "undefined") {
//            predicate = predicate.and(QApply.apply.agent.eq(agent));  
//        }

        if (status != null ) {   
            predicate = predicate.and(QApply.apply.status.eq(status)); 
        }
        	
        if (applyTime != null ) {    
            predicate = predicate.and(QApply.apply.applyTime.eq(applyTime));        
        }
        
        if(phone != null && phone != "undefined" && !phone.equals("null")) {
        	predicate = predicate.and(QApply.apply.applyPhone.eq(phone));        
        }
        
        if(product1 != null && !product1.equals("undefined") && !product1.equals("null")) {
        	predicate = predicate.and(product.productName.eq(product1));
        }
        
        if(customerName != null && customerName != "undefined" && !customerName.equals("null") && !customerName.isEmpty()) {
        	predicate = predicate.and(userInfo.firstname.eq(customerName));
        }
       
        return queryFactory
                .selectFrom(QApply.apply)
                .join(QApply.apply.userinfo, userInfo)
                .join(QApply.apply.product, product)
                .where(predicate)
                .fetch();
    }
    
//    @Transactional(readOnly = true)
//    public List<Apply> tlPanelLeadsSearch(String product1,Integer status, Integer leadType, Date applyTime, String state, String city, Integer tier) {
//    	
//    	BooleanExpression predicate = QApply.apply.isNotNull();
//    	QUserInfo userInfo = QUserInfo.userInfo;
//    	QProduct product = QProduct.product;
//    	QMaster_City_State masterCityState = QMaster_City_State.master_City_State;
//    	
//    	if(product1 != null && !product1.equals("undefined") && !product1.equals("null")) {
//        	predicate = predicate.and(product.productName.eq(product1));
//        }
//    	
//    	if(status != null) {
//        	predicate = predicate.and(QApply.apply.status.eq(status));
//        }
//    	
//    	if(leadType!=null) {
//    		predicate = predicate.and(QApply.apply.tier.eq(leadType));
//    	}
//    	
//    	if(applyTime != null )
//    	{
//    		predicate = predicate.and(QApply.apply.applyTime.eq(applyTime));
//    	}
//    	
//    	if(StringUtil.notEmpty(state))
//    	{
//    		predicate = predicate.and(masterCityState.state.eq(state));
//    	}
//    	
//    	if(StringUtil.notEmpty(city))
//    	{
//    		predicate = predicate.and(masterCityState.city.eq(city));
//    	}
//    	
//    	if(tier != null)
//    	{
//    		predicate = predicate.and(QApply.apply.tier.eq(tier));
//    	}
//    	
//    	// Add the subquery for pincode filtering
//        if (StringUtil.notEmpty(city) && StringUtil.notEmpty(state)) {
//            predicate = predicate.and(userInfo.pincode.eq(
//                JPAExpressions
//                    .select(masterCityState.pincode)
//                    .from(masterCityState)
//                    .where(masterCityState.city.eq(city)
//                        .and(masterCityState.state.eq(state)))
//            ));
//        }
//    	
//    	return queryFactory
//                .selectFrom(QApply.apply)
//                .join(QApply.apply.userinfo, userInfo)
//                .join(QApply.apply.product, product)
//                .where(predicate)
//                .fetch();
//    	
//    	
//    	
//    	
////    	return null;
//    }
    
//    @Transactional(readOnly = true)
//    public List<Apply> tlPanelLeadsSearch(String product1, Integer status, Integer leadType, Date applyTime, String state, String city, Integer tier) {
//
//        BooleanExpression predicate = QApply.apply.isNotNull();
//        QUserInfo userInfo = QUserInfo.userInfo;
//        QProduct product = QProduct.product;
//        QMaster_City_State masterCityState = QMaster_City_State.master_City_State;
//
//        // Build predicate based on input parameters
//        if (product1 != null && !product1.equals("undefined") && !product1.equals("null")) {
//            predicate = predicate.and(product.productName.eq(product1));
//        }
//
//        if (status != null) {
//            predicate = predicate.and(QApply.apply.status.eq(status));
//        }
//
//        if (leadType != null) {
//            predicate = predicate.and(QApply.apply.tier.eq(leadType));
//        }
//
//        if (applyTime != null) {
//            predicate = predicate.and(QApply.apply.applyTime.eq(applyTime));
//        }
//
//        if (StringUtil.notEmpty(state)) {
//            predicate = predicate.and(masterCityState.state.eq(state));
//        }
//
//        if (StringUtil.notEmpty(city)) {
//            predicate = predicate.and(masterCityState.city.eq(city));
//        }
//
//        if (tier != null) {
//            predicate = predicate.and(QApply.apply.tier.eq(tier));
//        }
//
//        // Subquery for pincode filtering
////        if (StringUtil.notEmpty(city) && StringUtil.notEmpty(state)) {
////            predicate = predicate.and(userInfo.pincode.eq(
////                JPAExpressions.selectOne()
////                    .select(masterCityState.pincode)
////                    .from(masterCityState)
////                    .where(masterCityState.city.eq(city)
////                        .and(masterCityState.state.eq(state)))
////            ));
////        }
////        if (StringUtil.notEmpty(city) && StringUtil.notEmpty(state)) {
////            // Assuming you want to ensure a single pincode, use `JPAExpressions.selectOne()`
////            // or handle multiple results appropriately
////            List<String> pincodes = JPAExpressions
////                .select(masterCityState.pincode)
////                .from(masterCityState)
////                .where(masterCityState.city.eq(city)
////                    .and(masterCityState.state.eq(state)))
////                .fetch();
////
////            if (!pincodes.isEmpty()) {
////                predicate = predicate.and(userInfo.pincode.in(pincodes));
////            }
////        }
//        
//        if (StringUtil.notEmpty(city) && StringUtil.notEmpty(state)) {
//            // Add the subquery directly into the predicate
//            predicate = predicate.and(userInfo.pincode.in(
//                JPAExpressions
//                    .select(masterCityState.pincode)
//                    .from(masterCityState)
//                    .where(masterCityState.city.eq(city)
//                        .and(masterCityState.state.eq(state)))
//            ));
//        }
//
//        return queryFactory
//                .selectFrom(QApply.apply)
//                .join(QApply.apply.userinfo, userInfo)
//                .join(QApply.apply.product, product)
//                .where(predicate)
//                .fetch();
//    }
    
    @Transactional(readOnly = true)
    public List<Apply> tlPanelLeadsSearch(String product1, Integer status, Integer leadType, LocalDateTime applyTime, String state, String city, Integer tier) {
        QApply apply = QApply.apply;
        QUserInfo userInfo = QUserInfo.userInfo;
        QProduct product = QProduct.product;
        QMaster_City_State masterCityState = QMaster_City_State.master_City_State;

        BooleanExpression predicate = apply.isNotNull();

        // Build predicate based on input parameters
        if (product1 != null && !product1.equals("undefined") && !product1.equals("null") && StringUtil.notEmpty(product1)) {
            predicate = predicate.and(product.productName.eq(product1));
        }

        if (status != null) {
            predicate = predicate.and(apply.status.eq(status));
        }

        if (leadType != null) {
            predicate = predicate.and(apply.tier.eq(leadType));
        }

        if (applyTime != null) {
        	
//        	Date newApplyTime = Date.from(applyTime.atZone(ZoneId.systemDefault()).toInstant());
        	Date newApplyTime = Date.from(applyTime.atZone(ZoneId.systemDefault()).toInstant());
//        	LocalDate applyDate = applyTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//            predicate = predicate.and(apply.applyTime.eq(newApplyTime));
            predicate = predicate.and(apply.applyTime.goe(newApplyTime)); // greater than or equal to startDate
	        predicate = predicate.and(apply.applyTime.lt(Date.from(newApplyTime.toInstant().plus(1, ChronoUnit.DAYS)))); // less than the next day
   
//        	predicate = predicate.and(apply.applyTime.eq(Date.from(applyDate.atStartOfDay(ZoneId.systemDefault()).toInstant())));
        }

        if (tier != null) {
            predicate = predicate.and(apply.tier.eq(tier));
        }

        // City and State filtering
        if (StringUtil.notEmpty(city) || StringUtil.notEmpty(state)) {
            predicate = predicate.and(userInfo.pincode.in(
                JPAExpressions
                    .select(masterCityState.pincode)
                    .from(masterCityState)
                    .where(
                        (StringUtil.notEmpty(city) ? masterCityState.city.eq(city) : null)
                        .and(StringUtil.notEmpty(state) ? masterCityState.state.eq(state) : null)
                    )
            ));
        }

        return queryFactory
            .selectFrom(apply)
            .join(apply.userinfo, userInfo)
            .join(apply.product, product)
            .where(predicate)
            .fetch();
    }


}
