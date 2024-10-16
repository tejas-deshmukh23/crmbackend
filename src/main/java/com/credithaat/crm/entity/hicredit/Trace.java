package com.credithaat.crm.entity.hicredit;

//public class Trace {
//
//}


import com.credithaat.crm.entity.anno.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@Table(name = "t_trace")
//@ApiModel
@Schema
public class Trace extends BaseEntity {
    @Column(name = "product_name", length = 50)
    private String productName;

    @Column(name = "user_phone", length = 50)
    private String userPhone;

    @Column(name = "apply_id", columnDefinition="INT NULL")
    private Integer applyId;
    
    @Column(name = "customer_trace_id", columnDefinition="INT NULL")
    private Integer customerTraceId;    

    @Column(name = "caller", length = 50)
    private String caller;

    @Column(name = "content", length = 500)
    private String content;

    @Column(name = "reason", columnDefinition="INT NULL")
    private Integer reason;

    @Column(name = "trace_time", columnDefinition="datetime NULL")
    private Date traceTime;

    @Column(name = "next_action_date", columnDefinition="date NULL")
    private Date nextActionDate;
    
    @Column(name = "content1", length = 500)
    private String content1;  
    
    @Column(name = "reason1", columnDefinition="INT NULL")
    private Integer reason1;    

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }
    
    public Integer getCustomerTraceId() {
        return customerTraceId;
    }

    public void setCustomerTraceId(Integer customerTraceId) {
        this.customerTraceId = customerTraceId;
    }    

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTraceTime() {
        return traceTime;
    }

    public void setTraceTime(Date traceTime) {
        this.traceTime = traceTime;
    }

    public Integer getReason() {
        return reason;
    }

    public void setReason(Integer reason) {
        this.reason = reason;
    }

    public Date getNextActionDate() {
        return nextActionDate;
    }

    public void setNextActionDate(Date nextActionDate) {
        this.nextActionDate = nextActionDate;
    }
    
    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }
    
    public Integer getReason1() {
        return reason1;
    }

    public void setReason1(Integer reason1) {
        this.reason1 = reason1;
    }    
}

