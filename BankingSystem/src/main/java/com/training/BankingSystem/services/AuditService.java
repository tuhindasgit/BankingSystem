package com.training.BankingSystem.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.BankingSystem.helper.Audit;
import com.training.BankingSystem.model.Customer;
@Service
public class AuditService {

	public Audit sendToAudit(Audit audit)
	{
	    final String uri = "http://localhost:8080/audit";
	    RestTemplate restTemplate = new RestTemplate();
	    Audit result = restTemplate.postForObject( uri, audit, Audit.class);
	    return result;
	}
}
