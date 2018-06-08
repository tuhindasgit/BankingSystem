package helper.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.training.BankingSystem.helper.BaseEntity;
@Entity
public class AtmDenominatio extends BaseEntity {


	@Id
	private Integer denomination;
	private Integer noOfDenomination;
	private Integer atmID;
	
	public AtmDenominatio() {
		super();
	}
	public AtmDenominatio(Integer denomination, Integer noOfDenomination, Integer atmID) {
		super();
		this.denomination = denomination;
		this.noOfDenomination = noOfDenomination;
		this.atmID = atmID;
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
	public Integer getAtmID() {
		return atmID;
	}
	public void setAtmID(Integer atmID) {
		this.atmID = atmID;
	}
}
