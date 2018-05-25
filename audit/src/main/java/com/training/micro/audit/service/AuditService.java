package com.training.micro.audit.service;

import java.util.List;

import com.training.micro.audit.document.Audit;

/**
 * @author tuhin
 *
 */
public interface AuditService {

	/**
	 * creating a audit 
	 * @param audit
	 * @return created audit
	 */
	Audit createAudit(Audit audit);
	/**
	 * list of all audit
	 * @return List of all audit
	 */
	List<Audit> viewAudit();
	/**
	 * List of audits sorted by specific event
	 * @param eventName
	 * @return list of audit
	 */
	List<Audit> viewOneByEvent(String eventName);
	/**
	 * updating a audit
	 * @param eventName
	 * @return status
	 */
	String updateAudit(String eventName);
}
