package com.training.BankingSystem.services;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import com.training.BankingSystem.helper.Audit;

@FeignClient("zuul")
public interface AuditService {

	@PostMapping(path="dit/audit")
	Audit createAudit(Audit audit);
}
