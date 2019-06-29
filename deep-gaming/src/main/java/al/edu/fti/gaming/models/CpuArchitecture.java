package al.edu.fti.gaming.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cpu_architecture")
/**
 * This class is mapped to the "cpu_architecture" table in the database which
 * contains information regarding different CPU architectures
 * 
 * @author kfotj
 *
 */
public class CpuArchitecture implements Serializable, IModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7286169322245792902L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cpu_architecture")
	/**
	 * This field is mapped to the primary key of the "cpu_architecture" table in
	 * the database
	 */
	private Integer idCpuArchitecture;

	@Column(name = "cpu_architecture_name", unique = true, nullable = false, length = 50)
	/**
	 * This variable is mapped to the "cpu_architecture_name" field in the
	 * "cpu_architecture" table in the database which contains information regarding
	 * the name of a CPU architecture
	 */
	private String cpuArchitectureName;

	@Column(name = "cpu_architecture_description", nullable = false, length = 65535)
	/**
	 * This variable is mapped to the "cpu_architecture_name" field in the
	 * "cpu_architecture" table in the database which contains information regarding
	 * generic information of a CPU architecture
	 */
	private String cpuArchitectureDescription;

	@Column(name = "cpu_process_nm", nullable = false)
	/**
	 * This variable is mapped to the "cpu_process_nm" field in the
	 * "cpu_architecture" table in the database which contains information regarding
	 * the sizes of the transistors which are forming a CPU
	 */
	private Byte cpuProcessNanometers;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_company", nullable = false)
	/**
	 * This variable represents the company which created this architecture. It is
	 * mapped to the foreign key which connects "cpu_architecture" and "company"
	 * tables
	 */
	private Company companyOfThisCpuArchitecture;

	@OneToMany(mappedBy = "architectureOfThisCpu")
	private List<CPU> cpusOfThisArchitecture = new ArrayList<CPU>();

	public CpuArchitecture(Integer idCpuArchitecture, String cpuArchitectureName, String cpuArchitectureDescription,
			Byte cpuProcessNanometers, Company companyOfThisCpuArchitecture, List<CPU> cpusOfThisArchitecture) {
		super();
		this.idCpuArchitecture = idCpuArchitecture;
		this.cpuArchitectureName = cpuArchitectureName;
		this.cpuArchitectureDescription = cpuArchitectureDescription;
		this.cpuProcessNanometers = cpuProcessNanometers;
		this.companyOfThisCpuArchitecture = companyOfThisCpuArchitecture;
		this.cpusOfThisArchitecture = cpusOfThisArchitecture;
	}

	public CpuArchitecture() {

	}

	public Integer getIdCpuArchitecture() {
		return idCpuArchitecture;
	}

	public void setIdCpuArchitecture(Integer idCpuArchitecture) {
		this.idCpuArchitecture = idCpuArchitecture;
	}

	public String getCpuArchitectureName() {
		return cpuArchitectureName;
	}

	public void setCpuArchitectureName(String cpuArchitectureName) {
		this.cpuArchitectureName = cpuArchitectureName;
	}

	public String getCpuArchitectureDescription() {
		return cpuArchitectureDescription;
	}

	public void setCpuArchitectureDescription(String cpuArchitectureDescription) {
		this.cpuArchitectureDescription = cpuArchitectureDescription;
	}

	public Byte getCpuProcessNanometers() {
		return cpuProcessNanometers;
	}

	public void setCpuProcessNanometers(Byte cpuProcessNanometers) {
		this.cpuProcessNanometers = cpuProcessNanometers;
	}

	public Company getCompanyOfThisCpuArchitecture() {
		return companyOfThisCpuArchitecture;
	}

	public void setCompanyOfThisCpuArchitecture(Company companyOfThisCpuArchitecture) {
		this.companyOfThisCpuArchitecture = companyOfThisCpuArchitecture;
	}

	public List<CPU> getCpusOfThisArchitecture() {
		return cpusOfThisArchitecture;
	}

	public void setCpusOfThisArchitecture(List<CPU> cpusOfThisArchitecture) {
		this.cpusOfThisArchitecture = cpusOfThisArchitecture;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((companyOfThisCpuArchitecture == null) ? 0 : companyOfThisCpuArchitecture.hashCode());
		result = prime * result + ((cpuArchitectureDescription == null) ? 0 : cpuArchitectureDescription.hashCode());
		result = prime * result + ((cpuArchitectureName == null) ? 0 : cpuArchitectureName.hashCode());
		result = prime * result + ((cpuProcessNanometers == null) ? 0 : cpuProcessNanometers.hashCode());
		result = prime * result + ((cpusOfThisArchitecture == null) ? 0 : cpusOfThisArchitecture.hashCode());
		result = prime * result + ((idCpuArchitecture == null) ? 0 : idCpuArchitecture.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CpuArchitecture other = (CpuArchitecture) obj;
		if (companyOfThisCpuArchitecture == null) {
			if (other.companyOfThisCpuArchitecture != null)
				return false;
		} else if (!companyOfThisCpuArchitecture.equals(other.companyOfThisCpuArchitecture))
			return false;
		if (cpuArchitectureDescription == null) {
			if (other.cpuArchitectureDescription != null)
				return false;
		} else if (!cpuArchitectureDescription.equals(other.cpuArchitectureDescription))
			return false;
		if (cpuArchitectureName == null) {
			if (other.cpuArchitectureName != null)
				return false;
		} else if (!cpuArchitectureName.equals(other.cpuArchitectureName))
			return false;
		if (cpuProcessNanometers == null) {
			if (other.cpuProcessNanometers != null)
				return false;
		} else if (!cpuProcessNanometers.equals(other.cpuProcessNanometers))
			return false;
		if (cpusOfThisArchitecture == null) {
			if (other.cpusOfThisArchitecture != null)
				return false;
		} else if (!cpusOfThisArchitecture.equals(other.cpusOfThisArchitecture))
			return false;
		if (idCpuArchitecture == null) {
			if (other.idCpuArchitecture != null)
				return false;
		} else if (!idCpuArchitecture.equals(other.idCpuArchitecture))
			return false;
		return true;
	}

}
