package al.edu.fti.deep_gaming.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "chipset")
/**
 * This class is mapped to the "chipset" table in the database which contains
 * information about the different chipsets of a CPU
 * 
 * @author kfotj
 *
 */
public class Chipset {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_chipset", nullable = false)
	/**
	 * This variable is mapped to the primary key of the "chipset" table in the
	 * database
	 */
	private Integer idChipset;

	@Column(name = "chipset_name", nullable = false, length = 50)
	/**
	 * This variable is mapped to the "chipset_name" field in the "chipset" table in
	 * the database which contains the name of the CPU chipset. Has to be 50 or less
	 * characters long
	 */
	private String chipsetName;

	@Column(name = "chipset_description", nullable = false, length = 65535)
	/**
	 * This variable is mapped to the "chipset_description" field in the "chipset"
	 * table which contains generic information of a specific type of chipset
	 */
	private String chipsetDescription;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_company", nullable = false)
	/**
	 * The company which created this chipset
	 */
	private Company companyThatCreatedThisChipset;
	
	@ManyToMany(mappedBy = "chipsetsThatSupportThisCpu")
	private Set<CPU> cpusThatAreSupportedByThisChipset = new HashSet<CPU>();
}
