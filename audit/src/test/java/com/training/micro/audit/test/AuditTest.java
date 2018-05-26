package com.training.micro.audit.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.training.micro.audit.document.Audit;
import com.training.micro.audit.exception.AuditException;
import com.training.micro.audit.repository.AuditRepo;
import com.training.micro.audit.service.AuditServiceImpl;

/**
 * @author tuhindas
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AuditTest {

	@InjectMocks
	AuditServiceImpl auditService;
	@Mock
	AuditRepo auditRepo;
	/**
	 * positive test case for creation of a audit
	 */
	@Test
	public void testCreateAuditP()
	{
		final Audit audit=new Audit("tuhin","das",new Date(),"123",new Object(),new Object());
		when(auditRepo.save(Mockito.<Audit>any())).thenReturn(audit);
		assertEquals(auditService.createAudit(audit).getEventName(),"tuhin");
	}
	/**
	 * test case when exception thrown during creation of audit
	 */
	@Test(expected=AuditException.class)
	public void testCreateAuditN() {
		final Audit audit=new Audit("tuhin",null,new Date(),"123",new Object(),new Object());
		auditService.createAudit(audit);
			}
	/**
	 * finding audit list positive test case
	 */
	
	@Test
	public void testFindAudit()
	{
		List<Audit> auditList=new ArrayList<>();
		final Audit audit=new Audit("tuhin","das",new Date(),"123",new Object(),new Object());
		final Audit anotherAudit=new Audit("su","kumar",new Date(),"124",new Object(),new Object());
		auditList.add(audit);
		auditList.add(anotherAudit);
		when(auditRepo.findAll()).thenReturn(auditList);
		assertThat(auditService.viewAudit(),is(notNullValue()));
	}
	/**
	 * negetive test case for finding audit list of particular event name
	 */
	@Test(expected=AuditException.class)
	public void testEventAuditN()
	{

		auditService.viewOneByEvent(null);

	}
	/**
	 * positive test case for finding audit list of particular event name
	 */
	
	@Test
	public void testEventAuditP()
	{
		List<Audit> auditList=new ArrayList<>();
		final Audit audit=new Audit("tuhin","das",new Date(),"123",new Object(),new Object());
		final Audit anotherAudit=new Audit("su","kumar",new Date(),"124",new Object(),new Object());
		auditList.add(audit);
		auditList.add(anotherAudit);
		String eventName="create";
		when(auditRepo.findByEventName(Mockito.any())).thenReturn(auditList);
		assertEquals(auditService.viewOneByEvent(eventName).get(0),audit);
	}
	/**
	 * test case when a audit record is updated
	 */
	@Test
	public void testUpdateAudit()
	{
		List<Audit> auditList=new ArrayList<>();
		final Audit audit=new Audit("tuhin","das",new Date(),"123",new Object(),new Object());
		final Audit anotherAudit=new Audit("su","kumar",new Date(),"124",new Object(),new Object());
		auditList.add(audit);
		auditList.add(anotherAudit);
		when(auditRepo.findByEventName(Mockito.any())).thenReturn(auditList);
		when(auditRepo.save(Mockito.<Audit>any())).thenReturn(audit);
		assertThat(auditService.updateAudit(Mockito.any()),is(notNullValue()));
	}
	
}
