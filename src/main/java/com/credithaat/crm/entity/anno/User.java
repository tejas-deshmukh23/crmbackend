package com.credithaat.crm.entity.anno;

//public class User {
//
//}

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//import com.hweb.annotations.HwebEntity;
//import com.hweb.annotations.HwebField;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@Table(name = "t_sys_user")
//@HwebEntity(title="Ã§â€�Â¨Ã¦Ë†Â·",pager=true,editUrl="manage!userEdit",filter="merchant is not null")
public class User extends BaseEntity {
	
	@Column(name = "username", length = 20)
//	@HwebField(title="Ã¥Â¸ï¿½Ã¥ï¿½Â·",query=true)
	private String username;
	
	@Column(name = "realname", length = 20)
//	@HwebField(title="Ã¥Â§â€œÃ¥ï¿½ï¿½",query=true)
	private String realname;
	
	@Column(name = "password", length = 20)
//	@HwebField(title="Ã¥Â¯â€ Ã§Â ï¿½",show=false)
	private String password;
	
	@Column(name = "first_login", columnDefinition="INT default 0")
//	@HwebField(title="Ã©Â¦â€“Ã¦Â¬Â¡Ã§â„¢Â»Ã¥Â½â€¢",items="Ã¦ËœÂ¯,Ã¥ï¿½Â¦",control="radio")
	private Integer firstLogin;
	
	@Column(name = "login_key", length = 50)
//	@HwebField(title="Ã¥Â¯â€ Ã©â€™Â¥",show=false)
	private String key;

	@Column(name = "white_ip", length = 100)
//	@HwebField(title="IPÃ§â„¢Â½Ã¥ï¿½ï¿½Ã¥ï¿½â€¢",show=false)
	private String whiteIP;
	
	@ManyToOne(targetEntity = Role.class,cascade={CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="role_id",insertable = true, updatable = true,nullable=true)
//	@HwebField(title="Ã¨Â§â€™Ã¨â€°Â²",ref=true,refName="anno.Role")
	private Role role;
	
	@Column(name = "appuser_id", columnDefinition="BIGINT NULL")
//	@HwebField(title="APPÃ§â€�Â¨Ã¦Ë†Â·ID",show=false)
	private Integer appUserId;
	
	@Column(name = "agent_number", length = 20)
//	@HwebField(title="Agent number",show=false)
	private String agent_number;
	
	@Override
	public String toString(){
		return username;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Integer getFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(Integer firstLogin) {
		this.firstLogin = firstLogin;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWhiteIP() {
		return whiteIP;
	}

	public void setWhiteIP(String whiteIP) {
		this.whiteIP = whiteIP;
	}

	public Integer getAppUserId() {
		return appUserId;
	}

	public void setAppUserId(Integer appUserId) {
		this.appUserId = appUserId;
	}

	public String getAgent_number() {
		return agent_number;
	}

	public void setAgent_number(String agent_number) {
		this.agent_number = agent_number;
	}
}

