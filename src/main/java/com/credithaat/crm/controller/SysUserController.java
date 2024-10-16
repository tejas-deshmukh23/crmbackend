package com.credithaat.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credithaat.crm.entity.anno.User;
import com.credithaat.crm.service.SysUserService;

@RestController
@CrossOrigin("*")
public class SysUserController {
	
	@Autowired
	SysUserService sysUserService;

	@GetMapping("/getAllUsers")
	public List<User> getAllUsers()
	{
		return sysUserService.getAllUsers();
	}
	
}
