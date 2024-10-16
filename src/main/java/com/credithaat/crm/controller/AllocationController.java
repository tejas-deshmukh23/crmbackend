package com.credithaat.crm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.credithaat.crm.entity.anno.User;
import com.credithaat.crm.entity.ds.ALDistribution;
import com.credithaat.crm.entity.ds.AllocationRequest;
import com.credithaat.crm.entity.hicredit.Apply;
import com.credithaat.crm.service.AllocationService;

@Controller
@CrossOrigin("*")
public class AllocationController {
	
	@Autowired
	AllocationService allocationService;
	
//	@PostMapping("/allocateLeads")
//	public Map<User, List<Apply>> allocateLeads(@RequestParam(name="userList", required=false)List<ALDistribution> userList,
//												@RequestParam(name="applyList", required=false)List<Apply> applyList){
//		
//		return allocationService.allocateLeads(userList, applyList);
//		
//	}
	
//	@PostMapping("/allocateLeads")
//	public Map<User, List<Apply>> allocateLeads(@RequestBody List<ALDistribution> userList, @RequestBody List<Apply> applyList) {	
////	    return allocationService.allocateLeads(userList);
//		return null;
//	}
	
//	@PostMapping("/allocateLeads")
//	public Map<User, List<Apply>> allocateLeads(@RequestBody AllocationRequest allocationRequest) {	
//		return allocationService.allocateLeads(allocationRequest);
//	}
	
	@PostMapping("/allocateLeads")
	public String allocateLeads(@RequestBody AllocationRequest allocationRequest) {	
		return allocationService.allocateLeads(allocationRequest);
	}

	
	

}
