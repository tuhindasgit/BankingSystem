package com.training.micro.audit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.micro.audit.document.Audit;
import com.training.micro.audit.service.AuditService;

@RestController
@RequestMapping(value="/audit")
public class AuditController {
	
	@Autowired
	AuditService auditservice;
	@PostMapping
	public ResponseEntity<?> addAudit(@RequestBody final Audit audit) {
		Audit auditResult=auditservice.createAudit(audit);
		return new ResponseEntity<Audit>(auditResult, HttpStatus.CREATED);

}
}
