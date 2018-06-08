package helper.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.training.BankingSystem.helper.BaseEntity;

@Entity
public class Denomination extends BaseEntity{

	@Id
	private Integer denomination;

	public Denomination(Integer denomination) {
		super();
		this.denomination = denomination;
	}

	public Integer getDenomination() {
		return denomination;
	}

	public void setDenomination(Integer denomination) {
		this.denomination = denomination;
	}

	public Denomination() {
		super();
	}
	
	
}
