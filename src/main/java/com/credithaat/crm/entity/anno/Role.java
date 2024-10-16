package com.credithaat.crm.entity.anno;
//
//public class Role {
//
//}

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

//import com.hweb.annotations.HwebEntity;
//import com.hweb.annotations.HwebField;


@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@Table(name = "t_sys_role")
//@HwebEntity(title="ç³»ç»Ÿè§’è‰²")
public class Role extends BaseEntity {
	@Column(name = "code", length = 20)
//	@HwebField(title="è§’è‰²ä»£ç �")
	private String code;
	
	@Column(name = "title", length = 50)
//	@HwebField(title="è§’è‰²å��ç§°")
	private String title;
	
	@Column(name = "power", length = 1000)
//	@HwebField(title="æ�ƒé™�")
	private String power;
	
	@Column(name = "power_desc", length = 1500)
//	@HwebField(title="æ�ƒé™�å…·ä½“å†…å®¹")
	private String powerDesc;
	
	@Column(name = "description", length = 200)
//	@HwebField(title="æ��è¿°")
	private String description;

	@Override
	public String toString(){
		return this.title;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getPowerDesc() {
		return powerDesc;
	}

	public void setPowerDesc(String powerDesc) {
		this.powerDesc = powerDesc;
	}
}

