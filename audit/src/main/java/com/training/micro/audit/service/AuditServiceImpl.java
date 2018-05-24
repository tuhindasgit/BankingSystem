package com.training.micro.audit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.micro.audit.document.Audit;
import com.training.micro.audit.repository.AuditRepo;
@Service
public class AuditServiceImpl implements AuditService {

	@Autowired
	AuditRepo auditRepo;
	
	@Override
	public Audit createAudit(Audit audit) {
	
		return auditRepo.save(audit);
	}

}
