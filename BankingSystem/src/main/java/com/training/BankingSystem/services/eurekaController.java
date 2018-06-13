package com.training.BankingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.training.BankingSystem.helper.Audit;
import com.training.BankingSystem.model.Customer;

@Service
public class eurekaController {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="doBreak")
	public String eurekaConnect() {
		
		List<ServiceInstance> instances = discoveryClient.getInstances("audit");
		
		instances.forEach(ins -> {
			System.out.println("INST: "+ins);
			System.out.println(ins.getHost() + ins.getPort() + ": "+ ins.getUri());
		});
				
		//Audit auditres = restTemplate.postForObject("http://audit/audit", audit, Audit.class);
	    ResponseEntity<Audit[]> custentity= restTemplate.getForEntity("http://audit/audit", Audit[].class);

		return "auditres";
	}
	
	public String doBreak()
	{
		return "In fallback Method";
	}
}
