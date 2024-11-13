package com.credithaat.crm.controller;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credithaat.crm.entity.anno.User;
import com.credithaat.crm.entity.hicredit.Apply;
import com.credithaat.crm.partner.TataDialer;
import com.credithaat.crm.repository.SysUserRepository;
import com.credithaat.crm.service.ApplyService;
import com.credithaat.crm.service.SysUserService;

@CrossOrigin("*")
@RestController
public class PartnerAPIController {
	
	@Autowired
	SysUserService sysUserService;
	@Autowired
	ApplyService applyService;
	
	@PostMapping("/call")
	public void call(Long userId,Long applyId)
	{
		Optional<User> user = sysUserService.getUserById(userId);
		Optional<Apply> apply = applyService.getApplyById(applyId);
		
		if(user.isPresent())
		{
			User user1 = user.get();
			String agentNumber = user1.getAgent_number();
			
			if(apply.isPresent())
			{
				Apply apply1 = apply.get();
				String phone = apply1.getApplyPhone();
				
				 JSONObject json = TataDialer.clickToCall(agentNumber, "91"+phone, "918062396305");
				 kvdhfvhkdvfys
			}
			
		}
	}

}
