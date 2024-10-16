package com.credithaat.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.credithaat.crm.entity.User;
import com.credithaat.crm.entity.anno.User;
import com.credithaat.crm.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@CrossOrigin("*")
@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService; 
	
//	@RequestMapping("/validate")
//	public String validateUser(@RequestParam(name="username") String username, @RequestParam(name="password") String password)
//	{
//		return "Valid/Invalid";
//	}
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password,
			HttpServletRequest request, HttpServletResponse response){
		
		return loginService.validateUser(username, password, request,response);
		
	}

}
