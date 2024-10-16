package com.credithaat.crm.entity.ds;

public class ALDistribution {
	
	private Integer id;
	private Integer userId;
	private Integer ApplyId;
	private String status;
	private String username;
	
	public ALDistribution() {
		
	}
	
	public ALDistribution(Integer id, Integer userId, Integer applyId,String username, String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.status = status;
		this.username = username;
		ApplyId = applyId;
	}
	
	public ALDistribution(Integer id, Integer userId) {
		this.id = id;
		this.userId = userId;
	}
	
	public ALDistribution(Integer id, String username) {
		this.id = id;
//		this.userId = userId;
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getApplyId() {
		return ApplyId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setApplyId(Integer applyId) {
		ApplyId = applyId;
	}

}
