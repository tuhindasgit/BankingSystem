package com.training.micro.audit.service;

import java.util.List;

import com.training.micro.audit.document.Audit;

public interface AuditService {

	Audit createAudit(Audit audit);
	
	List<Audit> viewAudit();
	
	List<Audit> viewOneByEvent(String eventName);
	
	String updateAudit(String eventName);
}
