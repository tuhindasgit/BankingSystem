package com.training.BankingSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.BankingSystem.helper.Audit;
import com.training.BankingSystem.services.CustomerServiceImpl;
@Service
public class eurekaController {
@Autowired
RestTemplate restTemplate;

	public  Audit eurekaConnect(Audit audit)
	{
	
	
	
		final String uri =  "http://audit/audit";
		Audit auditres=restTemplate.postForObject(uri,audit,Audit.class);
		
	return auditres;
	}
}

