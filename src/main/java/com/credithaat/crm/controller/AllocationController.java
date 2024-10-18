package com.credithaat.crm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.credithaat.crm.entity.anno.User;
import com.credithaat.crm.entity.ds.ALDistribution;
import com.credithaat.crm.entity.ds.AllocationRequest;
import com.credithaat.crm.entity.hicredit.Apply;
import com.credithaat.crm.entity.hicredit.Product;
import com.credithaat.crm.entity.hicredit.UserInfo;
import com.credithaat.crm.service.AllocationService;
import com.credithaat.crm.util.SearchResponse;

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
	
	@PostMapping("/getAllocatedLeadsJSON")
	@ResponseBody
	public List<SearchResponse> getAllocatedLeads(@RequestParam(name="userId", required=false)String userId)
	{
		try {
			
		List<Apply> applyRecords =  allocationService.getAllocatedLeads(userId);
		
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
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
		
//		return allocationService.getAllocatedLeads(userId);
	}

	
	

}
