package com.training.BankingSystem.services;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigController {

	@Bean
	@LoadBalanced
	RestTemplate resttemplate()
	{
		return new RestTemplate();
	}
	
	
}
