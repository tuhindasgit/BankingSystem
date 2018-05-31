package com.amit.spring.security.web.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amit.spring.security.web.entity.User;

public interface UserRepository extends JpaRepository<User, Serializable> {

	Optional<User> findByUserName(String userName);
}
