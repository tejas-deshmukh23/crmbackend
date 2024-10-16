package com.credithaat.crm.util;

import java.util.List;

import com.credithaat.crm.entity.hicredit.Apply;
import com.credithaat.crm.entity.hicredit.Product;
import com.credithaat.crm.entity.hicredit.UserInfo;

public class SearchResponse {

	private Apply apply;
	private UserInfo userInfo;
	private Product product;

	public Apply getApply() {
		return apply;
	}

	public void setApply(Apply apply) {                
		this.apply = apply;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
