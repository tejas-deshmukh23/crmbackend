package com.credithaat.crm.entity.hicredit;

import java.util.ArrayList;
import java.util.List;

import com.credithaat.crm.util.SearchResponse;

public class GlobalEntity {
	
	static List<SearchResponse> searchResponseList = new ArrayList<>();
	
	public GlobalEntity()
	{
		
	}

	public static List<SearchResponse> getSearchResponseList() {
		return searchResponseList;
	}

	public static void setSearchResponseList(List<SearchResponse> searchResponseList) {
		GlobalEntity.searchResponseList = searchResponseList;
	}
	
	
	

}
