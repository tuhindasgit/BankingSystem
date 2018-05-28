package com.training.BankingSystem.services;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import com.training.BankingSystem.helper.Audit;

@FeignClient("audit")
public interface AuditService {

	@PostMapping(path="/audit")
	Audit createAudit(Audit audit);
}
