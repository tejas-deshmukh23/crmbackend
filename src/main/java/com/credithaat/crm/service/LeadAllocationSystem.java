package com.credithaat.crm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.credithaat.crm.entity.anno.User;
import com.credithaat.crm.entity.ds.AllocationRequest;
import com.credithaat.crm.entity.hicredit.Apply;
import com.credithaat.crm.entity.hicredit.GlobalEntity;
import com.credithaat.crm.util.SearchResponse;

//We've created a LeadAllocationSystem class to manage the entire allocation process.
public class LeadAllocationSystem {
	
	private List<User> users;
//    private List<Apply> remainingLeads;
//    private Map<User, List<Apply>> allocatedLeads;
	
	private List<SearchResponse> remainingLeads;
	private Map<User, List<SearchResponse>> allocatedLeads;
	
    private static final int INITIAL_ALLOCATION = 100;
    private static final int SUBSEQUENT_ALLOCATION = 10;
    
//    The constructor takes an AllocationRequest and performs the initial allocation of up to 100 leads per user.
    public LeadAllocationSystem(AllocationRequest allocationRequest) {
        this.users = allocationRequest.getSysUsers();
//        this.remainingLeads = new ArrayList<>(allocationRequest.getApplyLeads());
        //Here temporarily we will use the SearchResponse class for testing 
        this.remainingLeads = new ArrayList<>(GlobalEntity.getSearchResponseList());
        this.allocatedLeads = new HashMap<>();
        initialAllocation();
    }
    
//    The initialAllocation() method distributes the first 100 leads (or fewer if there aren't enough) to each user.
//    private void initialAllocation() {
//        for (User user : users) {
//            List<Apply> userLeads = new ArrayList<>();
//            int leadsToAllocate = Math.min(INITIAL_ALLOCATION, remainingLeads.size());
//            for (int i = 0; i < leadsToAllocate; i++) { 
//                userLeads.add(remainingLeads.remove(0));
//            }
//            allocatedLeads.put(user, userLeads);
//        }
//        
//        System.out.println("After the leads have been allocated : - ");
//        
//        for (Map.Entry<User, List<Apply>> entry : allocatedLeads.entrySet()) {
//            User user = entry.getKey();
//            List<Apply> applies = entry.getValue();
//            
//            System.out.println("User: " + user);
//            System.out.println("Applications: " + applies);
//        }
//        
//    }
    
    private void initialAllocation() {
    	
    	List<SearchResponse> listToAllocate = GlobalEntity.getSearchResponseList();
    	
        int totalLeads = remainingLeads.size();
        int userCount = users.size();
        
        if (userCount == 0) {
            System.out.println("No users available for lead allocation.");
            return;
        }
        
        int leadsPerUser = Math.min(INITIAL_ALLOCATION, (int) Math.ceil((double) totalLeads / userCount));

        for (User user : users) {
            allocatedLeads.put(user, new ArrayList<>());
        }

        Iterator<SearchResponse> leadIterator = remainingLeads.iterator();
        while (leadIterator.hasNext()) {
            for (User user : users) {
                if (!leadIterator.hasNext()) break;
                
                List<SearchResponse> userLeads = allocatedLeads.get(user);
                if (userLeads.size() < leadsPerUser) {
                    userLeads.add(leadIterator.next());
                    leadIterator.remove();
                }
            }
        }

        printAllocationStatus();
    }
    
    private void printAllocationStatus() {
        System.out.println("After the leads have been allocated:");
        for (Map.Entry<User, List<SearchResponse>> entry : allocatedLeads.entrySet()) {
            User user = entry.getKey();
            List<SearchResponse> applies = entry.getValue();
            System.out.println("User: " + user);
            System.out.println("Number of Applications: " + applies.size());
        }
        System.out.println("Remaining leads: " + remainingLeads.size());
    }
    
    
//    The allocateAdditionalLeads(User user) method is called when a user has completed their current batch. It allocates up to 10 additional leads to the specified user.
    public void allocateAdditionalLeads(User user) {
        List<SearchResponse> userLeads = allocatedLeads.get(user);
        int leadsToAllocate = Math.min(SUBSEQUENT_ALLOCATION, remainingLeads.size());
        for (int i = 0; i < leadsToAllocate; i++) {
            userLeads.add(remainingLeads.remove(0));
        }
    }
    
//    We provide methods to get the current allocation status (getAllocatedLeads()) and the number of remaining leads (getRemainingLeadsCount()).
    public Map<User, List<SearchResponse>> getAllocatedLeads() {
        return allocatedLeads;
    }

    public int getRemainingLeadsCount() {
        return remainingLeads.size();
    }
    
    public List<SearchResponse> getUserLeads(Long userId) {
        for (Map.Entry<User, List<SearchResponse>> entry : allocatedLeads.entrySet()) {
            if (entry.getKey().getId().equals(userId)) {
                return entry.getValue();
            }
        }
        return null; // Or return an empty list: return new ArrayList<>();
    }
    
    

}
