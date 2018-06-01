package com.training.confiServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfiServerApplication.class, args);
	}
}
