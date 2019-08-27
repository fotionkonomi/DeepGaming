package al.edu.fti.gaming.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "power_supply")
public class PowerSupply extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3453959672454371092L;

	@Column(name = "power_capacity", nullable = false)
	private Integer powerCapacity;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_company", nullable = false)
	private Company companyOfThisPowerSupply;

	

	public Integer getPowerCapacity() {
		return powerCapacity;
	}

	public void setPowerCapacity(Integer powerCapacity) {
		this.powerCapacity = powerCapacity;
	}

	public Company getCompanyOfThisPowerSupply() {
		return companyOfThisPowerSupply;
	}

	public void setCompanyOfThisPowerSupply(Company companyOfThisPowerSupply) {
		this.companyOfThisPowerSupply = companyOfThisPowerSupply;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((companyOfThisPowerSupply == null) ? 0 : companyOfThisPowerSupply.hashCode());
		result = prime * result + ((powerCapacity == null) ? 0 : powerCapacity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PowerSupply other = (PowerSupply) obj;
		if (companyOfThisPowerSupply == null) {
			if (other.companyOfThisPowerSupply != null)
				return false;
		} else if (!companyOfThisPowerSupply.equals(other.companyOfThisPowerSupply))
			return false;
		if (powerCapacity == null) {
			if (other.powerCapacity != null)
				return false;
		} else if (!powerCapacity.equals(other.powerCapacity))
			return false;
		return true;
	}
	
	

}
