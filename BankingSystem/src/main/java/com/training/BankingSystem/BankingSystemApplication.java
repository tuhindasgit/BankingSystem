package com.training.BankingSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * application starts here
 */
@SpringBootApplication
@ComponentScan(basePackages="com.training.BankingSystem")
@EnableEurekaClient
@EnableFeignClients
public class BankingSystemApplication {



	/**
	 * main method of the program
	 */
	public static void main(String[] args) {
		SpringApplication.run(BankingSystemApplication.class, args);

		
	}
}

