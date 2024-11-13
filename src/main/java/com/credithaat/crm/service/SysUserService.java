package com.credithaat.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credithaat.crm.entity.anno.User;
import com.credithaat.crm.repository.SysUserRepository;

@Service
public class SysUserService {
	
	
	@Autowired
	SysUserRepository sysUserRepository;
	
	public List<User> getAllUsers()
	{
		return sysUserRepository.findAll();
	}
	
	public Optional<User> getUserById(Long userId)
	{
		return sysUserRepository.findById(userId.toString());
	}

}
