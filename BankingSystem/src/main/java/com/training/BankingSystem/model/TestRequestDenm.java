package com.training.BankingSystem.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TestRequestDenm extends BaseEntity{

	
	List<Integer> denomination;
	Integer bankId;
	Integer atmId;

	
	public List<Integer> getDenomination() {
		return denomination;
	}
	public void setDenomination(List<Integer> denomination) {
		this.denomination = denomination;
	}
	public Integer getBankId() {
		return bankId;
	}
	public TestRequestDenm() {
		super();
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	public Integer getAtmId() {
		return atmId;
	}
	public void setAtmId(Integer atmId) {
		this.atmId = atmId;
	}
	public TestRequestDenm(List<Integer> denomination, Integer bankId, Integer atmId) {
		super();
		this.denomination = denomination;
		this.bankId = bankId;
		this.atmId = atmId;
	}
	
}
