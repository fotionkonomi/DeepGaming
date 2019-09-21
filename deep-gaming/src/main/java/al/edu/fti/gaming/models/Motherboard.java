package al.edu.fti.gaming.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "motherboard")
public class Motherboard extends Product {
	// MOS HARROOO
	// Motherboard_storage
	// Motherboard_storage
	// Motherboard_storage
	// Motherboard_storage
	// Motherboard_storage
	// Motherboard_storage
	// Motherboard_storage
	// Motherboard_storage
	// Motherboard_storage
	// Motherboard_storage
	// Motherboard_storage
	// Motherboard_storage
	/**
	 * 
	 */
	private static final long serialVersionUID = 5258804225255359490L;

	@Column(name = "maximum_ram_capacity", nullable = false)
	private Double maximumRamCapacity;

	@Column(name = "maximum_ram_speed", nullable = false)
	private Integer maximumRamSpeed;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_company", nullable = false)
	private Company companyOfThisMotherboard;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_cpu_socket", nullable = false)
	private CpuSocket cpuSocketOfThisMotherboard;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_motherboard_form_factor", nullable = false)
	private MotherboardFormFactor formFactorOfThisMotherboard;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE )
	@JoinColumn(name = "id_gpu_slot", nullable = false)
	private GpuSlot gpuSlot;

	// Motherboard_Storage

}
