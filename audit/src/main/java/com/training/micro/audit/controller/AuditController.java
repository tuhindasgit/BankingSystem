package com.training.micro.audit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.micro.audit.document.Audit;
import com.training.micro.audit.exception.AuditException;
import com.training.micro.audit.service.AuditService;

/**
 * @author tuhindas
 * rest end points
 */
@RefreshScope
@RestController
@RequestMapping(value="/audit")
public class AuditController {
	
	@Autowired
	AuditService auditservice;
	@Value("${hi:hello}")
	String hi;
	/**
	 * sending a audit object through JSON and saving it 
	 * @param audit
	 * @return ResponseEntity
	 */
	@PostMapping
	public ResponseEntity<?> addAudit(@RequestBody final Audit audit) {
		try
		{
		
		Audit auditResult=auditservice.createAudit(audit);
		return new ResponseEntity<Audit>(auditResult, HttpStatus.CREATED);
		}
		catch(AuditException e)
		{
			return new ResponseEntity<String>(e.toString(), HttpStatus.BAD_REQUEST);
		}
}
	
	
	@GetMapping
	public ResponseEntity<?> viewAudit() {
		List<Audit> auditResult=auditservice.viewAudit();
		return new ResponseEntity<List<Audit>>(auditResult, HttpStatus.CREATED);


}
	
	
	/**
	 * viewing list of audits 
	 * @return ResponseEntity
	 */
	@GetMapping(value="/hi")
	public ResponseEntity<?> viewhiAudit() {
		List<Audit> auditResult=auditservice.viewAudit();
		return new ResponseEntity<String>(hi, HttpStatus.CREATED);


}
	/**
	 * viewing a list of audits of aparticular eventname
	 * @param eventName
	 * @return
	 */
	@GetMapping(value="/{eventName}")
	public ResponseEntity<?> viewOneAudit(@PathVariable final String eventName) {
		List<Audit> auditResult=auditservice.viewOneByEvent(eventName);
		return new ResponseEntity<List<Audit>>(auditResult, HttpStatus.CREATED);

}
	/**
	 * updating list of audits of a particular event name type
	 * @param eventName
	 * @return
	 */
	@PostMapping(value="/{eventName}")
	public ResponseEntity<?> updateAudit(@PathVariable final String eventName) {
		String auditResult=auditservice.updateAudit(eventName);
		return new ResponseEntity<String>(auditResult, HttpStatus.CREATED);

}
}
