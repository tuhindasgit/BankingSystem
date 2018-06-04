package com.amit.spring.security.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amit.spring.security.web.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	

}
