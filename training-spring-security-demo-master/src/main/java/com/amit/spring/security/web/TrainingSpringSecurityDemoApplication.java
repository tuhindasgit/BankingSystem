package com.amit.spring.security.web;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amit.spring.security.web.entity.Role;
import com.amit.spring.security.web.entity.User;
import com.amit.spring.security.web.repository.UserRepository;

@SpringBootApplication
public class TrainingSpringSecurityDemoApplication implements CommandLineRunner{

	@Autowired
	UserRepository repository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(TrainingSpringSecurityDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();
		Role role = new Role("ADMIN");
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		roles.add(new Role("USER"));
		User user = new User("Sanjay", "koala", roles) ;
		repository.saveAndFlush(user);
		
		Set<Role> darsRole = new HashSet<>();
		darsRole.add(new Role("USER"));
		User user2 = new User("Darshit", "koala", darsRole) ;
		repository.saveAndFlush(user2);
		
	}
	
	
	
}
