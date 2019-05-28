package al.edu.fti.deep_gaming.models;

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
	
	@Column(name = "power_capacity", nullable = false)
	private Integer powerCapacity;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_company", nullable = false)
	private Company companyOfThisPowerSupply;
	
}
