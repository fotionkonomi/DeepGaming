package al.edu.fti.gaming.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "computer")
public class Computer extends Product {

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_cpu", nullable = false)
	private CPU cpuOfThisComputer;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_gpu", nullable = false)
	private GPU gpuOfThisComputer;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_motherboard", nullable = false)
	private Motherboard motherboardOfThisComputer;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_ram", nullable = false)
	private Ram ramOfThisComputer;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_company", nullable = false)
	private Company companyOfThisComputer;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_operating_system", nullable = false)
	private OperatingSystem operatingSystemOfThisComputer;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_power_supply", nullable = false)
	private PowerSupply powerSupplyOfThisComputer;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "computer_storage", joinColumns = { @JoinColumn(name = "id_computer") }, inverseJoinColumns = {
			@JoinColumn(name = "id_storage") })
	private Set<Storage> storagesOfThisComputer = new HashSet<Storage>();
	
}
