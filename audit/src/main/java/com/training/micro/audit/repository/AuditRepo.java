package com.training.micro.audit.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.training.micro.audit.document.Audit;

public interface AuditRepo extends MongoRepository<Audit,UUID> {

	/**
	 * will find all the audit of a particular event name
	 * @param eventName
	 * @return
	 */
	List<Audit> findByEventName(String eventName);
	
}
