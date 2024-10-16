package com.credithaat.crm.entity.ds;

import java.util.List;

import com.credithaat.crm.entity.anno.User;
import com.credithaat.crm.entity.hicredit.Apply;

public class AllocationRequest {
	
	private List<User> sysUsers;
	private List<Apply> applyLeads;
	
	public AllocationRequest() {
		// TODO Auto-generated constructor stub
	}

	public AllocationRequest(List<User> sysUsers, List<Apply> applyLeads) {
		super();
		this.sysUsers = sysUsers;
		this.applyLeads = applyLeads;
	}

	public List<User> getSysUsers() {
		return sysUsers;
	}

	public void setSysUsers(List<User> sysUsers) {
		this.sysUsers = sysUsers;
	}

	public List<Apply> getApplyLeads() {
		return applyLeads;
	}

	public void setApplyLeads(List<Apply> applyLeads) {
		this.applyLeads = applyLeads;
	}

}
