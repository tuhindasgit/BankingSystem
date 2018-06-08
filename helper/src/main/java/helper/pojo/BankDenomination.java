package helper.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.training.BankingSystem.helper.BaseEntity;
@Entity
public class BankDenomination extends BaseEntity {


	@Id
	private Integer denomination;
	private Integer noOfDenomination;
	private Integer bankId;
	
	public BankDenomination() {
		super();
	}
	public BankDenomination(Integer denomination, Integer noOfDenomination, Integer bankId) {
		super();
		this.denomination = denomination;
		this.noOfDenomination = noOfDenomination;
		this.bankId = bankId;
	}
	public Integer getDenomination() {
		return denomination;
	}
	public void setDenomination(Integer denomination) {
		this.denomination = denomination;
	}
	public Integer getNoOfDenomination() {
		return noOfDenomination;
	}
	public void setNoOfDenomination(Integer noOfDenomination) {
		this.noOfDenomination = noOfDenomination;
	}
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
}
