package com.training.micro.audit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.micro.audit.document.Audit;
import com.training.micro.audit.exception.AuditException;
import com.training.micro.audit.repository.AuditRepo;
/**
 * @author tuhindas
 *
 */
@Service
public class AuditServiceImpl implements AuditService {

	@Autowired
	AuditRepo auditRepo;

	/**
	 * implementation of audit service
	 * creating a new audit
	 */
	@Override
	public Audit createAudit(Audit audit) {
		
		if(audit.getEventName()==null || audit.getEventType()==null)
		{
			throw new AuditException("can not accept without event name or event type");
		}
		else
		{
			return auditRepo.save(audit);
		}
	}
	/**
	 * List of all audit
	 */
	@Override
	public List<Audit> viewAudit() {
		
		return auditRepo.findAll();
	}
	/**
	 * All audit of a particular eventName
	 */
	@Override
	public List<Audit> viewOneByEvent(final String eventName) {
		if(eventName==null)
		{
			throw new AuditException("pass a event name");
		}
		else
		{
			return  auditRepo.findByEventName(eventName);
	}
	}
	/**
	 * updating a audit List of a particular event Name
	 */
	@Override
	public String updateAudit(final String eventName) {
		final List<Audit> auditOption= auditRepo.findByEventName(eventName);
		for(Audit list:auditOption)
		{
			list.setEventType("new created");
			 auditRepo.save(list);
			
					}
		return "updated";
	}
}
