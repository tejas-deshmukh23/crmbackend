package com.credithaat.crm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credithaat.crm.entity.anno.User;
import com.credithaat.crm.entity.hicredit.Apply;
import com.credithaat.crm.repository.ApplyRepository;

@Service
public class ApplyService {
	
	@Autowired
	ApplyRepository applyRepository;
	
	public Optional<Apply> getApplyById(Long applyId)
	{
		return applyRepository.findById(applyId);
	}

}
