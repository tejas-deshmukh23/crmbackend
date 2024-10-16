package com.credithaat.crm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.credithaat.crm.entity.anno.User;
import com.credithaat.crm.entity.ds.AllocationRequest;
import com.credithaat.crm.entity.hicredit.Apply;

//We've created a LeadAllocationSystem class to manage the entire allocation process.
public class LeadAllocationSystem {
	
	private List<User> users;
    private List<Apply> remainingLeads;
    private Map<User, List<Apply>> allocatedLeads;
    private static final int INITIAL_ALLOCATION = 100;
    private static final int SUBSEQUENT_ALLOCATION = 10;
    
//    The constructor takes an AllocationRequest and performs the initial allocation of up to 100 leads per user.
    public LeadAllocationSystem(AllocationRequest allocationRequest) {
        this.users = allocationRequest.getSysUsers();
        this.remainingLeads = new ArrayList<>(allocationRequest.getApplyLeads());
        this.allocatedLeads = new HashMap<>();
        initialAllocation();
    }
    
//    The initialAllocation() method distributes the first 100 leads (or fewer if there aren't enough) to each user.
    private void initialAllocation() {
        for (User user : users) {
            List<Apply> userLeads = new ArrayList<>();
            int leadsToAllocate = Math.min(INITIAL_ALLOCATION, remainingLeads.size());
            for (int i = 0; i < leadsToAllocate; i++) {
                userLeads.add(remainingLeads.remove(0));
            }
            allocatedLeads.put(user, userLeads);
        }
    }
    
//    The allocateAdditionalLeads(User user) method is called when a user has completed their current batch. It allocates up to 10 additional leads to the specified user.
    public void allocateAdditionalLeads(User user) {
        List<Apply> userLeads = allocatedLeads.get(user);
        int leadsToAllocate = Math.min(SUBSEQUENT_ALLOCATION, remainingLeads.size());
        for (int i = 0; i < leadsToAllocate; i++) {
            userLeads.add(remainingLeads.remove(0));
        }
    }
    
//    We provide methods to get the current allocation status (getAllocatedLeads()) and the number of remaining leads (getRemainingLeadsCount()).
    public Map<User, List<Apply>> getAllocatedLeads() {
        return allocatedLeads;
    }

    public int getRemainingLeadsCount() {
        return remainingLeads.size();
    }
    
    

}
