package com.credithaat.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.credithaat.crm.entity.anno.User;

public interface SysUserRepository extends JpaRepository<User, String>{
	
	

}
