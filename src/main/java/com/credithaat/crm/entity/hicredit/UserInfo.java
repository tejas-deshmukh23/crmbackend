package com.credithaat.crm.entity.hicredit;

import com.credithaat.crm.util.StringUtil;
import java.util.Date;
import jakarta.persistence.Column;
//import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Table;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;

import com.credithaat.crm.entity.anno.BaseEntity;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "t_userinfo" , indexes = {@Index(name="second_index",columnList = "mobilenumber")})
//@ApiModel

@Schema
public class UserInfo extends BaseEntity
{
    @Column(name = "web_source", length = 50)
    private String webSource;
    
    @Column(name = "sms_source", length = 50)
    private String smsSource;
    
    @Column(name = "source", length = 50)
    private String source;
    
    @Column(name = "campaign", length = 2000)
    private String campaign;
    
    @Column(name = "medium", length = 50)
    private String medium;
    
    @Column(name = "channel", length = 50)
    private String channel;
    
    @Column(name = "channel0", length = 50)
    private String channel0;
    
    @Column(name = "agent", length = 50)
    private String agent;
    
    @Column(name = "sub_agent", length = 50)
    private String sub_agent;
    
    @Column(name = "agent_user_id", columnDefinition = "INT NULL")
    private Integer agentUserId;
    
    @Column(name = "sub_agent_user_id", columnDefinition = "INT NULL")
    private Integer subagentUserId;
    
    @Column(name = "user_id", length = 250)
    private String userId;
    
    @Column(name = "device_id", length = 50)
    private String deviceId;
    
    @Column(name = "active", columnDefinition = "INT NULL default 1")
    private Integer active;
    
    @Column(name = "mobilenumber", length = 50)
    private String mobilenumber;
    
    @Column(name = "firstname", length = 50)
    private String firstname;
    
    @Column(name = "lastname", length = 50)
    private String lastname;
    
    @Column(name = "dob", length = 50)
    private String dob;
    
    @Column(name = "gender", length = 50)
    private String gender;
    
    @Column(name = "email", length = 50)
    private String email;
    
    @Column(name = "profession", length = 50)
    private String profession;
    
    @Column(name = "qualification", length = 50)
    private String qualification;
    
    @Column(name = "address1", length = 200)
    private String address1;
    
    @Column(name = "address2", length = 200)
    private String address2;
    
    @Column(name = "landmark", length = 50)
    private String landmark;
    
    @Column(name = "state", length = 50)
    private String state;
    
    @Column(name = "city", length = 50)
    private String city;
    
    @Column(name = "salary", columnDefinition = "decimal(20,2) NULL")
    private Float salary;
    
    @Column(name = "payment_type", columnDefinition = "INT NULL default 2")
    private Integer paymentType;
    
    @Column(name = "pincode", length = 50)
    private String pincode;
    
    @Column(name = "maritalstatus", length = 50)
    private String maritalstatus;
    
    @Column(name = "addresstype", length = 50)
    private String addresstype;
    
    @Column(name = "fathername", length = 50)
    private String fathername;
    
    @Column(name = "mothername", length = 50)
    private String mothername;
    
    @Column(name = "comments", length = 200)
    private String comments;
    
    @Column(name = "notice_time", columnDefinition = "datetime NULL")
    private Date noticeTime;
    
    @Column(name = "reg_time", columnDefinition = "datetime NULL")
    private Date regTime;
    
    @Column(name = "customer_id", length = 50)
    private String customerID;
    
    @Column(name = "status", length = 50)
    private String Status;
    
    @Column(name = "hubbleId", length = 200)
    private String hubbleId;
    
    @Column(name = "PAN", length = 200)
    private String pan;
    
    @Column(name = "step", columnDefinition = "INT default 0")
    private Integer step;
    
    @Column(name = "residence_type", length = 200)
    private String residence_type;
    
    @Column(name = "NOM", length = 50)
    private String nom;
    
    @Column(name = "company_name", length = 200)
    private String company_name;
    
    @Column(name = "degination", length = 200)
    private String degination;
    
    @Column(name = "bankname", length = 200)
    private String bankname;
    
    @Column(name = "bankid", length = 200)
    private String bankid;
    
    @Column(name = "yoe", length = 200)
    private String yoe;
    
    @Column(name = "netbanking", length = 200)
    private String netbanking;
    
    @Column(name = "emi", length = 200)
    private String emi;
    
    @Column(name = "loan_purpose_id", length = 200)
    private String loan_purpose_id;
    
    @Column(name = "officeLine1", length = 500)
    private String officeaddline1;
    
    @Column(name = "officeLine2", length = 200)
    private String officeaddline2;
    
    @Column(name = "collegename", length = 200)
    private String collegename;
    
    @Column(name = "workemail", length = 50)
    private String workemail;
    
    @Column(name = "officepincode", length = 50)
    private String officepincode;
    
    @Column(name = "creditprofile", length = 50)
    private String creditprofile;
    
    @Column(name = "hciemployetype", length = 50)
    private String hciemployetype;
    
    @Column(name = "Tier", columnDefinition="INT NULL")
    private Integer tier;
    
    @Column(name = "doj", length = 50)
    private String doj;
    
    @Column(name = "loanamount", length = 50)
    private String loanamount;
    
    @Column(name = "reference_1_name", length = 50)
    private String reference_1_name;
    
    @Column(name = "reference_1_relation", length = 50)
    private String reference_1_relation;
    
    @Column(name = "reference_1_phone", length = 50)
    private String reference_1_phone;
    
    @Column(name = "reference_1_addressline_1", length = 50)
    private String reference_1_addressline_1; 
    
    @Column(name = "reference_1_addressline_2", length = 50)
    private String reference_1_addressline_2;
    
    @Column(name = "reference_1_pincode", length = 50)
    private String reference_1_pincode;
    
    @Column(name = "reference_1_residence_ownership", length = 50)
    private String reference_1_residence_ownership;
    
    @Column(name = "reference_2_name", length = 50)
    private String reference_2_name;
    
    @Column(name = "reference_2_phone", length = 50)
    private String reference_2_phone;
    
    @Column(name = "reference_2_relation", length = 50)
    private String reference_2_relation;
    
    @Column(name = "account_holder_name", length = 50)
    private String account_holder_name;
    
    @Column(name = "bank_type", length = 50)
    private String bank_type;
    
    @Column(name = "account_number", length = 50)
    private String account_number;
    
    @Column(name = "branch_name", length = 50)
    private String branch_name;
    
    @Column(name = "ifsc", length = 50)
    private String ifsc;
   
    @Column(name = "partnerLoanId", length = 50)
    private String partnerLoanId;
    
    @Column(name = "last_attribution_time")
    private Date last_attribution_time;
    
    @Column(name = "dpd_thirty", length = 50)
    private String dpd_thirty;
    
    @Column(name = "dpd_ninty", length = 50)
    private String dpd_ninty;
    
    @Column(name = "dpd_oneeighty", length = 50)
    private String dpd_oneeighty;
    
    @Column(name = "cc_present_flag", length = 50)
    private String cc_present_flag;
    
    public UserInfo() {
        this.paymentType = 2;
        this.last_attribution_time = new Date();
    }
    
    public String toString() {
        String str = this.firstname;
        if (StringUtil.notEmpty(this.lastname)) {
            str = String.valueOf(str) + " " + this.lastname;
        }
        str = String.valueOf(str) + " / " + this.mobilenumber;
        if (StringUtil.notEmpty(this.channel)) {
            str = "[" + this.channel + "] " + str;
        }
        return str;
    }
    
    public String getMobilenumber() {
        return this.mobilenumber;
    }
    
    public void setMobilenumber(final String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }
    
    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }
    
    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }
    
    public String getDob() {
        return this.dob;
    }
    
    public void setDob(final String dob) {
        this.dob = dob;
    }
    
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(final String gender) {
        this.gender = gender;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(final String email) {
        this.email = email;

    }
    
    public String getProfession() {
        return this.profession;
    }
    
    public void setProfession(final String profession) {
        this.profession = profession;
    }
    
    public String getQualification() {
        return this.qualification;
    }
    
    public void setQualification(final String qualification) {
        this.qualification = qualification;
    }
    
    public String getAddress1() {
        return this.address1;
    }
    
    public void setAddress1(final String address1) {
        this.address1 = address1;
    }
    
    public String getAddress2() {
        return this.address2;
    }
    
    public void setAddress2(final String address2) {
        this.address2 = address2;
    }
    
    public String getLandmark() {
        return this.landmark;
    }
    
    public void setLandmark(final String landmark) {
        this.landmark = landmark;
    }
    
    public String getState() {
        return this.state;
    }
    
    public void setState(final String state) {
        this.state = state;
    }
    
    public String getCity() {
        return this.city;
    }
    
    public void setCity(final String city) {
        this.city = city;
    }
    
    public String getPincode() {
        return this.pincode;
    }
    
    public void setPincode(final String pincode) {
        this.pincode = pincode;
    }
    
    public String getMaritalstatus() {
        return this.maritalstatus;
    }
    
    public void setMaritalstatus(final String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }
    
    public String getAddresstype() {
        return this.addresstype;
    }
    
    public void setAddresstype(final String addresstype) {
        this.addresstype = addresstype;
    }
    
    public String getFathername() {
        return this.fathername;
    }
    
    public void setFathername(final String fathername) {
        this.fathername = fathername;
    }
    
    public String getMothername() {
        return this.mothername;
    }
    
    public void setMothername(final String mothername) {
        this.mothername = mothername;
    }
    
    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(final String userId) {
        this.userId = userId;
    }
    
    public String getChannel() {
        return this.channel;
    }
    
    public void setChannel(final String channel) {
        this.channel = channel;
    }
    
    public Float getSalary() {
        return this.salary;
    }
    
    public void setSalary(final Float salary) {
        this.salary = salary;
    }
    
    public String getComments() {
        return this.comments;
    }
    
    public void setComments(final String comments) {
        this.comments = comments;
    }
    
    public Date getNoticeTime() {
        return this.noticeTime;
    }
    
    public void setNoticeTime(final Date noticeTime) {
        this.noticeTime = noticeTime;
    }
    
    public String getDeviceId() {
        return this.deviceId;
    }
    
    public void setDeviceId(final String deviceId) {
        this.deviceId = deviceId;
    }
    
    public Integer getActive() {
        return this.active;
    }
    
    public void setActive(final Integer active) {
        this.active = active;
    }
    
    public Integer getPaymentType() {
        return this.paymentType;
    }
    
    public void setPaymentType(final Integer paymentType) {
        this.paymentType = paymentType;
    }
    
    public String getSource() {
        return this.source;
    }
    
    public void setSource(final String source) {
        this.source = source;
    }
    
    public String getCampaign() {
        return this.campaign;
    }
    
    public void setCampaign(final String campaign) {
        this.campaign = campaign;
    }
    
    public String getMedium() {
        return this.medium;
    }
    
    public void setMedium(final String medium) {
        this.medium = medium;
    }
    
    public String getAgent() {
        return this.agent;
    }
    
    public void setAgent(final String agent) {
        this.agent = agent;
    }
    
    public Integer getAgentUserId() {
        return this.agentUserId;
    }
    
    public void setAgentUserId(final Integer agentUserId) {
        this.agentUserId = agentUserId;
    }
    
    public String getWebSource() {
        return this.webSource;
    }
    
    public void setWebSource(final String webSource) {
        this.webSource = webSource;
    }
    
    public Date getRegTime() {
        return this.regTime;
    }
    
    public void setRegTime(final Date regTime) {
        this.regTime = regTime;
    }
    
    public String getSmsSource() {
        return this.smsSource;
    }
    
    public void setSmsSource(final String smsSource) {
        this.smsSource = smsSource;
    }
    
    public String getChannel0() {
        return this.channel0;
    }
    
    public void setChannel0(final String channel0) {
        this.channel0 = channel0;
    }
    
    public String getCustomerID() {
        return this.customerID;
    }
    
    public void setCustomerID(final String customerID) {
        this.customerID = customerID;
    }
    
    public String getStatus() {
        return this.Status;
    }
    
    public void setStatus(final String Status) {
        this.Status = Status;
    }
    
    public String getHubbleId() {
        return this.hubbleId;
    }
    
    public void setHubbleId(final String hubbleId) {
        this.hubbleId = hubbleId;
    }
    
    public String getPan() {
        return this.pan;
    }
    
    public void setPan(final String pan) {
        this.pan = pan;
    }
    
    public Integer getStep() {
        return this.step;
    }
    
    public void setStep(final Integer step) {
        this.step = step;
    }
    
    public String getResidence_type() {
        return this.residence_type;
    }
    
    public void setResidence_type(final String residence_type) {
        this.residence_type = residence_type;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(final String nom) {
        this.nom = nom;
    }
    
    public String getCompany_name() {
        return this.company_name;
    }
    
    public void setCompany_name(final String company_name) {
        this.company_name = company_name;
    }
    
    public String getDegination() {
        return this.degination;
    }
    
    public void setDegination(final String degination) {
        this.degination = degination;
    }
    
    public String getBankname() {
        return this.bankname;
    }
    
    public void setBankname(final String bankname) {
        this.bankname = bankname;
    }
    
    public String getBankid() {
        return this.bankid;
    }
    
    public void setBankid(final String bankid) {
        this.bankid = bankid;
    }
    
    public String getYoe() {
        return this.yoe;
    }
    
    public void setYoe(final String yoe) {
        this.yoe = yoe;
    }
    
    public String getNetbanking() {
        return this.netbanking;
    }
    
    public void setNetbanking(final String netbanking) {
        this.netbanking = netbanking;
    }
    
    public String getEmi() {
        return this.emi;
    }
    
    public void setEmi(final String emi) {
        this.emi = emi;
    }
    
    public String getLoan_purpose_id() {
        return this.loan_purpose_id;
    }
    
    public void setLoan_purpose_id(final String loan_purpose_id) {
        this.loan_purpose_id = loan_purpose_id;
    }
    
    public String getOfficeaddline1() {
        return this.officeaddline1;
    }
    
    public void setOfficeaddline1(final String officeaddline1) {
        this.officeaddline1 = officeaddline1;
    }
    
    public String getOfficeaddline2() {
        return this.officeaddline2;
    }
    
    public void setOfficeaddline2(final String officeaddline2) {
        this.officeaddline2 = officeaddline2;
    }
    
    public String getCollegename() {
        return this.collegename;
    }
    
    public void setCollegename(final String collegename) {
        this.collegename = collegename;
    }
    
    public String getWorkemail() {
        return this.workemail;
    }
    
    public void setWorkemail(final String workemail) {
        this.workemail = workemail;
    }
    
    public String getOfficepincode() {
        return this.officepincode;
    }
    
    public void setOfficepincode(final String officepincode) {
        this.officepincode = officepincode;
    }
    
    public String getCreditprofile() {
        return this.creditprofile;
    }
    
    public void setCreditprofile(final String creditprofile) {
        this.creditprofile = creditprofile;
    } 
    
    public String getHciemployetype() {
        return this.hciemployetype;
    }
    
    public void setHciemployetype(final String hciemployetype) {
        this.hciemployetype = hciemployetype;
    }
    
    public String getDoj() {
        return this.doj;
    }
    
    public void setDoj(final String doj) {
        this.doj = doj;
    }
    
    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }
    
    public String getLoanamount() {
        return this.loanamount;
    }
    
    public void setLoanamount(final String loanamount) {
        this.loanamount = loanamount;
    } 
    
    public String getReference_1_name() {
        return this.reference_1_name;
    }
    
    public void setReference_1_name(final String reference_1_name) {
        this.reference_1_name = reference_1_name;
    }
    
    public String getReference_1_relation() {
        return this.reference_1_relation;
    }
    
    public void setReference_1_relation(final String reference_1_relation) {
        this.reference_1_relation = reference_1_relation;
    }
    
    public String getReference_1_phone() {
        return this.reference_1_phone;
    }
    
    public void setReference_1_phone(final String reference_1_phone) {
        this.reference_1_phone = reference_1_phone;
    }
    
    public String getReference_1_addressline_1() {
        return this.reference_1_addressline_1;
    }
    
    public void setReference_1_addressline_1(final String reference_1_addressline_1) {
        this.reference_1_addressline_1 = reference_1_addressline_1;
    }
    
    
    public String getReference_1_addressline_2() {
        return this.reference_1_addressline_2;
    }
    
    public void setReference_1_addressline_2(final String reference_1_addressline_2) {
        this.reference_1_addressline_2 = reference_1_addressline_2;
    }
    
    public String getReference_1_pincode() {
        return this.reference_1_pincode;
    }
    
    public void setReference_1_pincode(final String reference_1_pincode) {
        this.reference_1_pincode = reference_1_pincode;
    }
    
    public String getReference_1_residence_ownership() {
        return this.reference_1_residence_ownership;
    }
    
    public void setReference_1_residence_ownership(final String reference_1_residence_ownership) {
        this.reference_1_residence_ownership = reference_1_residence_ownership;
    }
    
    public String getReference_2_name() {
        return this.reference_2_name;
    }
    
    public void setReference_2_name(final String reference_2_name) {
        this.reference_2_name = reference_2_name;
    }
    
    public String getReference_2_phone() {
        return this.reference_2_phone;
    }
    
    public void setReference_2_phone(final String reference_2_phone) {
        this.reference_2_phone = reference_2_phone;
    }
    
    public String getReference_2_relation() {
        return this.reference_2_relation;
    }
    
    public void setReference_2_relation(final String reference_2_relation) {
        this.reference_2_relation = reference_2_relation;
    }
    
    public String getAccount_holder_name() {
        return this.account_holder_name;
    }
    
    public void setAccount_holder_name(final String account_holder_name) {
        this.account_holder_name = account_holder_name;
    }
    
    public String getBank_type() {
        return this.bank_type;
    }
    
    public void setBank_type(final String bank_type) {
        this.bank_type = bank_type;
    }
    
    public String getAccount_number() {
        return this.account_number;
    }
    
    public void setAccount_number(final String account_number) {
        this.account_number = account_number;
    }
    
    public String getBranch_name() {
        return this.branch_name;
    }
    
    public void setBranch_name(final String branch_name) {
        this.branch_name = branch_name;
    }
    
    public String getIfsc() {
        return this.ifsc;
    }
    
    public void setIfsc(final String ifsc) {
        this.ifsc = ifsc;
    }
    
    public String getPartnerLoanId() {
        return this.partnerLoanId;
    }
    
    public void setPartnerLoanId(final String partnerLoanId) {
        this.partnerLoanId = partnerLoanId;
    }
    
    public String getSub_agent() {
        return this.sub_agent;
    }
    
    public void setSub_agent(final String sub_agent) {
        this.sub_agent = sub_agent;
    }
    
    public Integer getSubagentUserId() {
        return this.subagentUserId;
    }
    
    public void setSubagentUserId(final Integer subagentUserId) {
        this.subagentUserId = subagentUserId;
    }
    
    public Date getLast_attribution_time() {
        return this.last_attribution_time;
    }
    
    public void setLast_attribution_time(final Date last_attribution_time) {
        this.last_attribution_time = last_attribution_time;
    }

	public String getDpd_thirty() {
		return dpd_thirty;
	}

	public void setDpd_thirty(String dpd_thirty) {
		this.dpd_thirty = dpd_thirty;
	}

	public String getDpd_ninty() {
		return dpd_ninty;
	}

	public void setDpd_ninty(String dpd_ninty) {
		this.dpd_ninty = dpd_ninty;
	}

	public String getDpd_oneeighty() {
		return dpd_oneeighty;
	}

	public void setDpd_oneeighty(String dpd_oneeighty) {
		this.dpd_oneeighty = dpd_oneeighty;
	}

	public String getCc_present_flag() {
		return cc_present_flag;
	}

	public void setCc_present_flag(String cc_present_flag) {
		this.cc_present_flag = cc_present_flag;
	}
}
