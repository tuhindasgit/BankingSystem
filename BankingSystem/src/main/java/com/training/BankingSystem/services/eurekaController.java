package com.training.BankingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.training.BankingSystem.helper.Audit;

@Service
public class eurekaController {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	RestTemplate restTemplate;
	
	public Audit eurekaConnect(Audit audit) {
		
		List<ServiceInstance> instances = discoveryClient.getInstances("audit");
		
		instances.forEach(ins -> {
			System.out.println("INST: "+ins);
			System.out.println(ins.getHost() + ins.getPort() + ": "+ ins.getUri());
		});
				
		Audit auditres = restTemplate.postForObject("http://audit/audit", audit, Audit.class);

		return auditres;
	}
}
