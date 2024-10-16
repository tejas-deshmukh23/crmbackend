package com.credithaat.crm.entity.hicredit;

import com.credithaat.crm.entity.anno.BaseEntity;

//public class Apply {
//
//}

//package com.hweb.entity.hicredit;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@Table(name = "t_apply" , indexes = {@Index(name="first_index",columnList = "apply_phone")})

//@ApiModel
@Schema
public class Apply extends BaseEntity {
    @ManyToOne(targetEntity = UserInfo.class,cascade={CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name="userinfo_id")
    
    @JsonIgnore
    private UserInfo userinfo;

    @Column(name = "apply_phone", length = 20)
    private String applyPhone;

    @ManyToOne(targetEntity = Product.class,cascade={CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name="product_id")
    
    @JsonIgnore
    private Product product;

    @Column(name = "partner_id", length = 100)
    private String partnerId;

    @Column(name = "status", columnDefinition="INT default 0")
    private Integer status;

    @Column(name = "response_content", length = 2000)
    private String responseContent;

    @Column(name = "message", length = 1000)
    private String message;
    
    @Column(name = "message1", length = 1000)
    private String message1;  
    
    @Column(name = "content", length = 1000)
    private String content;     

    @Column(name = "apply_time", columnDefinition="datetime NULL")
    private Date applyTime;

    @Column(name = "priority", columnDefinition="INT NULL")
    private Integer priority;

    @Column(name = "next_action_date", columnDefinition="date NULL")
    private Date nextActionDate;

    @Column(name = "agent", length = 50)
    private String agent;
    
    @Column(name = "sub_agent", length = 50)
    private String sub_agent;

    @Column(name = "agent_user_id", columnDefinition="INT NULL")
    private Integer agentUserId;
    
    @Column(name = "sub_agent_user_id", columnDefinition="INT NULL")
    private Integer sub_agentUserId;

    @Column(name = "operation_id", columnDefinition="INT NULL")
    private Integer operationId;
    
    @Column(name = "requestMetaData", length = 200)
    private String requestMetaData;
    
    @Column(name = "call_dispostion", length = 200)
    private String call_dispostion; 
    
    @Column(name = "Tier", columnDefinition="INT NULL")
    private Integer tier;
    
    @Column(name = "salary",columnDefinition="decimal(20,2) NULL")
    private Float salary;
    
    @Column(name = "trace_count", columnDefinition="INT default 0")
    private Integer trace_count;

    @Column(name = "category", columnDefinition="INT default 0")
    private Integer category; 
    
    @Column(name = "max_loan_amount", length = 200)
    private String maxloan; 
    
    @Column(name = "amount_selected", length = 200)
    private String amountselected;  
    
    @Column(name = "disbursed_amount", length = 200)
    private String disbursed;
    
    @Column(name = "url", length = 2000)
    private String url;
    
    @Column(name = "offline", columnDefinition="INT default 0")
    private Integer offline;
    
    @Column(name = "recurring", columnDefinition="INT default 0")
    private Integer recurring;

    public String getStatusStr(){
        return "Data Submitted,App Downloaded,Loan Applied,Approved,Rejected,Disbursed,Form Filled,Abandoned,offline,call back".split(",")[status];
    }
    
    public String getTierStr(){
    	if (tier == null) {
            return "Unknown"; // or any appropriate default value
        }
        return "Platinum,Gold,Silver,Bronze,Others".split(",")[tier];
    }

    public UserInfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserInfo userinfo) {
        this.userinfo = userinfo;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getResponseContent() {
        return responseContent;
    }

    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getMessage1() {
        return message1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }    

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getNextActionDate() {
        return nextActionDate;
    }

    public void setNextActionDate(Date nextActionDate) {
        this.nextActionDate = nextActionDate;
    }

    public String getApplyPhone() {
        return applyPhone;
    }

    public void setApplyPhone(String applyPhone) {
        this.applyPhone = applyPhone;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public Integer getAgentUserId() {
        return agentUserId;
    }

    public void setAgentUserId(Integer agentUserId) {
        this.agentUserId = agentUserId;
    }

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }
    
    public String getRequestMetaData() {
        return requestMetaData;
    }

    public void setRequestMetaData(String requestMetaData) {
        this.requestMetaData = requestMetaData;
    } 
    
    public String getCall_dispostion(){
    	return call_dispostion;
    }
    
    public void setCall_dispostion(String call_dispostion){
    	this.call_dispostion = call_dispostion;
    } 
    
    public Integer getTrace_count(){
    	return trace_count;
    }
    
    public void setTrace_count(Integer trace_count){
    	this.trace_count = trace_count;
    }
    
    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }
    
    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }
    
    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
    
    public String getMaxloan(){
    	return maxloan;
    }
    
    public void setMaxloan(String maxloan){
    	this.maxloan = maxloan;
    }
    
    public String getAmountselected(){
    	return amountselected;
    }
    
    public void setAmountselected(String amountselected){
    	this.amountselected = amountselected;
    }
    
    public String getDisbursed(){
    	return disbursed;
    }
    
    public void setDisbursed(String disbursed){
    	this.disbursed = disbursed;
    }
    
    public String getUrl(){
    	return url;
    }
    
    public void setUrl(String url){
    	this.url = url;
    }
    
    public String getSub_agent() {
        return sub_agent;
    }

    public void setSub_agent(String sub_agent) {
        this.sub_agent = sub_agent;
    }
    
    public Integer getSub_agentUserId() {
        return sub_agentUserId;
    }

    public void setSub_agentUserId(Integer sub_agentUserId) {
        this.sub_agentUserId = sub_agentUserId;
    }
    
    public Integer getOffline() {
        return offline;
    }

    public void setOffline(Integer offline) {
        this.offline = offline;
    }
    
    public Integer getRecurring() {
        return recurring;
    }

    public void setRecurring(Integer recurring) {
        this.recurring = recurring;
    }
}

