package com.training.micro.audit.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.training.micro.audit.document.Audit;

public interface AuditRepo extends MongoRepository<Audit,UUID> {

	List<Audit> findByEventName(String eventName);
	
}
