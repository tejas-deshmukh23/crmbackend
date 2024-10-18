package com.credithaat.crm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.credithaat.crm.entity.anno.User;
import com.credithaat.crm.entity.ds.ALDistribution;
import com.credithaat.crm.entity.ds.AllocationRequest;
import com.credithaat.crm.entity.hicredit.Apply;

@RestController
public class AllocationService {

//	public Map<User, List<Apply>> allocateLeads(List<ALDistribution> userList, List<Apply> applyList) {
//		
//		
//		
//		return null;
//	}
	
//	public Map<User, List<Apply>> allocateLeads(AllocationRequest allocationRequest) {
//	    List<User> users = allocationRequest.getSysUsers();
//	    List<Apply> applyLeads = allocationRequest.getApplyLeads();
//
//	    Map<User, List<Apply>> allocatedRecord = new HashMap<>();
//
//	    // Initialize a list for each user in the map
//	    for (User user : users) {
//	        allocatedRecord.put(user, new ArrayList<>());
//	    }
//
//	    int userCount = users.size();
//	    int leadCount = applyLeads.size();
//
//	    // Allocate apply leads in batches of 100
//	    for (int i = 0; i < leadCount; i++) {
//	        // Determine which user to assign the current lead to
////	        User currentUser = users[(i / 100) % userCount]; // Round-robin allocation
//	    	User currentUser = users.get(i % userCount); // Correct round-robin allocation
//	        allocatedRecord.get(currentUser).add(applyLeads.get(i));
//	    }
//
//	    return allocatedRecord; // Return the allocated records
//	}
	
//	public Map<User, List<Apply>> allocateLeads(AllocationRequest allocationRequest) {
//	    List<User> users = allocationRequest.getSysUsers();
//	    List<Apply> applyLeads = allocationRequest.getApplyLeads();
//
//	    Map<User, List<Apply>> allocatedRecord = new HashMap<>();
//
//	    int userCount = users.size();
//	    int leadCount = applyLeads.size();
//	    int leadsPerUser;
//
//	    if (leadCount >= userCount * 100) {
//	        // If we have enough leads to give each user 100
//	        leadsPerUser = 100;
//	    } else {
//	        // If we don't have enough leads, distribute evenly
//	        leadsPerUser = leadCount / userCount;
//	    }
//
//	    int remainingLeads = leadCount - (leadsPerUser * userCount);
//	    int currentLeadIndex = 0;
//
//	    for (User user : users) {
//	        List<Apply> userLeads = new ArrayList<>();
//	        for (int i = 0; i < leadsPerUser && currentLeadIndex < leadCount; i++) {
//	            userLeads.add(applyLeads.get(currentLeadIndex));
//	            currentLeadIndex++;
//	        }
//	        allocatedRecord.put(user, userLeads);
//	    }
//
//	    // Distribute any remaining leads
//	    int userIndex = 0;
//	    while (currentLeadIndex < leadCount) {
//	        allocatedRecord.get(users.get(userIndex)).add(applyLeads.get(currentLeadIndex));
//	        currentLeadIndex++;
//	        userIndex = (userIndex + 1) % userCount;
//	    }
//
//	    return allocatedRecord;
//	}
	
	
	LeadAllocationSystem leadAllocationSystem ;
	
//	public Map<String, List<Apply>> allocateLeads(AllocationRequest allocationRequest) {
	public String allocateLeads(AllocationRequest allocationRequest) {
		
		leadAllocationSystem = new LeadAllocationSystem(allocationRequest);
//		
//		Map<String, List<Apply>> result = new HashMap<>();
//		for (Map.Entry<User, List<Apply>> entry : allocation.entrySet()) {
//		    result.put(entry.getKey().getId().toString(), entry.getValue());
//		}
//		return result;
		
		
		return "OK";
		
//		LeadAllocationSystem leadAllocationSystem = new LeadAllocationSystem(allocationRequest);
//		return leadAllocationSystem.getAllocatedLeads();
	}
	
	public List<Apply> getAllocatedLeads(String userId)
	{
		
		Long uId = Long.parseLong(userId);
		List<Apply> list = leadAllocationSystem.getUserLeads(uId);
		
		return list;

	}
	
	

}
