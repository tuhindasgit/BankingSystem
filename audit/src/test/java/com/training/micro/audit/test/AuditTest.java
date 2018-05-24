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
import org.mockito.junit.MockitoJUnitRunner;

import com.training.micro.audit.document.Audit;
import com.training.micro.audit.repository.AuditRepo;
import com.training.micro.audit.service.AuditServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class AuditTest {

	@InjectMocks
	AuditServiceImpl auditService;
	@Mock
	AuditRepo auditRepo;
	
	@Test
	public void TestCreateAudit()
	{
		final Audit audit=new Audit("tuhin","das",new Date(),"123",new Object(),new Object());
		when(auditRepo.save(Mockito.<Audit>any())).thenReturn(audit);
		assertEquals(auditService.createAudit(audit).getEventName(),"tuhin");
	}
	
	@Test
	public void TestFindAudit()
	{
		List<Audit> auditList=new ArrayList<>();
		final Audit audit=new Audit("tuhin","das",new Date(),"123",new Object(),new Object());
		final Audit anotherAudit=new Audit("su","kumar",new Date(),"124",new Object(),new Object());
		auditList.add(audit);
		auditList.add(anotherAudit);
		when(auditRepo.findAll()).thenReturn(auditList);
		assertThat(auditService.viewAudit(),is(notNullValue()));
	}
	
	
	
}
