package al.edu.fti.gaming.models;

import javax.persistence.Table;

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

@Entity
@Table(name = "cpu_family")
/**
 * The class which is mapped to the "cpu_family" table in the database which
 * contains information regarding the CPU families
 * 
 * @author kfotj
 *
 */
public class CpuFamily implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2028190788656483328L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cpu_family", nullable = false)
	/**
	 * This field is mapped to the primary key of the "cpu_family" table in the
	 * database
	 */
	private Integer idCpuFamily;

	@Column(name = "cpu_family_name", unique = true, nullable = false, length = 50)
	/**
	 * This variable is mapped to the "cpu_family_name" field in the "cpu_family"
	 * table in the database which contains information regarding the CPU family's
	 * name
	 */
	private String cpuFamilyName;

	@Column(name = "cpu_family_description", nullable = false, length = 65535)
	/**
	 * This variable is mapped to the "cpu_family_description" field in the
	 * "cpu_family" table in the database which contains information regarding
	 * generic information about a CPU family
	 */
	private String cpuFamilyDescription;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_company", nullable = false)
	/**
	 * This variable represents the company which created a CPU family. It maps the
	 * id of the company in the database
	 */
	private Company companyOfThisCpuFamily;

	@OneToMany(mappedBy = "familyOfThisCpu")
	private List<CPU> cpusOfThisFamily = new ArrayList<CPU>();

	public CpuFamily(Integer idCpuFamily, String cpuFamilyName, String cpuFamilyDescription,
			Company companyOfThisCpuFamily, List<CPU> cpusOfThisFamily) {
		super();
		this.idCpuFamily = idCpuFamily;
		this.cpuFamilyName = cpuFamilyName;
		this.cpuFamilyDescription = cpuFamilyDescription;
		this.companyOfThisCpuFamily = companyOfThisCpuFamily;
		this.cpusOfThisFamily = cpusOfThisFamily;
	}

	public CpuFamily() {

	}

	public Integer getIdCpuFamily() {
		return idCpuFamily;
	}

	public void setIdCpuFamily(Integer idCpuFamily) {
		this.idCpuFamily = idCpuFamily;
	}

	public String getCpuFamilyName() {
		return cpuFamilyName;
	}

	public void setCpuFamilyName(String cpuFamilyName) {
		this.cpuFamilyName = cpuFamilyName;
	}

	public String getCpuFamilyDescription() {
		return cpuFamilyDescription;
	}

	public void setCpuFamilyDescription(String cpuFamilyDescription) {
		this.cpuFamilyDescription = cpuFamilyDescription;
	}

	public Company getCompanyOfThisCpuFamily() {
		return companyOfThisCpuFamily;
	}

	public void setCompanyOfThisCpuFamily(Company companyOfThisCpuFamily) {
		this.companyOfThisCpuFamily = companyOfThisCpuFamily;
	}

	public List<CPU> getCpusOfThisFamily() {
		return cpusOfThisFamily;
	}

	public void setCpusOfThisFamily(List<CPU> cpusOfThisFamily) {
		this.cpusOfThisFamily = cpusOfThisFamily;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyOfThisCpuFamily == null) ? 0 : companyOfThisCpuFamily.hashCode());
		result = prime * result + ((cpuFamilyDescription == null) ? 0 : cpuFamilyDescription.hashCode());
		result = prime * result + ((cpuFamilyName == null) ? 0 : cpuFamilyName.hashCode());
		result = prime * result + ((cpusOfThisFamily == null) ? 0 : cpusOfThisFamily.hashCode());
		result = prime * result + ((idCpuFamily == null) ? 0 : idCpuFamily.hashCode());
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
		CpuFamily other = (CpuFamily) obj;
		if (companyOfThisCpuFamily == null) {
			if (other.companyOfThisCpuFamily != null)
				return false;
		} else if (!companyOfThisCpuFamily.equals(other.companyOfThisCpuFamily))
			return false;
		if (cpuFamilyDescription == null) {
			if (other.cpuFamilyDescription != null)
				return false;
		} else if (!cpuFamilyDescription.equals(other.cpuFamilyDescription))
			return false;
		if (cpuFamilyName == null) {
			if (other.cpuFamilyName != null)
				return false;
		} else if (!cpuFamilyName.equals(other.cpuFamilyName))
			return false;
		if (cpusOfThisFamily == null) {
			if (other.cpusOfThisFamily != null)
				return false;
		} else if (!cpusOfThisFamily.equals(other.cpusOfThisFamily))
			return false;
		if (idCpuFamily == null) {
			if (other.idCpuFamily != null)
				return false;
		} else if (!idCpuFamily.equals(other.idCpuFamily))
			return false;
		return true;
	}

}
