package al.edu.fti.gaming.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ram")
public class Ram extends Product {

	@Column(name = "capacity", nullable = false)
	private Double capacity;
	
	@Column(name = "frequency", nullable = false)
	private Integer frequency;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_company", nullable = false)
	private Company ramSticksCompany;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_ram_memory_technology", nullable = false)
	private RamMemoryTechnology technologyOfThisRamStick;
	
	
}
