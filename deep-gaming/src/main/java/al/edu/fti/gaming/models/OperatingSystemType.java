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
@Table(name = "operating_system_type")
public class OperatingSystemType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2173320839854507209L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_operating_system_type", nullable = false)
	private Integer idOperatingSystemType;

	@Column(name = "operating_system_type_name", unique = true, nullable = false, length = 30)
	private String operatingSystemTypeName;

	@Column(name = "operating_system_type_description", nullable = false, length = 65535)
	private String operatingSystemTypeDescription;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_company", nullable = false)
	private Company companyOfThisOS;

	@OneToMany(mappedBy = "operatingSystemType")
	private List<OperatingSystem> operatingSystemsOfThisType = new ArrayList<OperatingSystem>();

	public OperatingSystemType(Integer idOperatingSystemType, String operatingSystemTypeName,
			String operatingSystemTypeDescription, Company companyOfThisOS,
			List<OperatingSystem> operatingSystemsOfThisType) {
		super();
		this.idOperatingSystemType = idOperatingSystemType;
		this.operatingSystemTypeName = operatingSystemTypeName;
		this.operatingSystemTypeDescription = operatingSystemTypeDescription;
		this.companyOfThisOS = companyOfThisOS;
		this.operatingSystemsOfThisType = operatingSystemsOfThisType;
	}

	public OperatingSystemType() {

	}

	public Integer getIdOperatingSystemType() {
		return idOperatingSystemType;
	}

	public void setIdOperatingSystemType(Integer idOperatingSystemType) {
		this.idOperatingSystemType = idOperatingSystemType;
	}

	public String getOperatingSystemTypeName() {
		return operatingSystemTypeName;
	}

	public void setOperatingSystemTypeName(String operatingSystemTypeName) {
		this.operatingSystemTypeName = operatingSystemTypeName;
	}

	public String getOperatingSystemTypeDescription() {
		return operatingSystemTypeDescription;
	}

	public void setOperatingSystemTypeDescription(String operatingSystemTypeDescription) {
		this.operatingSystemTypeDescription = operatingSystemTypeDescription;
	}

	public Company getCompanyOfThisOS() {
		return companyOfThisOS;
	}

	public void setCompanyOfThisOS(Company companyOfThisOS) {
		this.companyOfThisOS = companyOfThisOS;
	}

	public List<OperatingSystem> getOperatingSystemsOfThisType() {
		return operatingSystemsOfThisType;
	}

	public void setOperatingSystemsOfThisType(List<OperatingSystem> operatingSystemsOfThisType) {
		this.operatingSystemsOfThisType = operatingSystemsOfThisType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyOfThisOS == null) ? 0 : companyOfThisOS.hashCode());
		result = prime * result + ((idOperatingSystemType == null) ? 0 : idOperatingSystemType.hashCode());
		result = prime * result
				+ ((operatingSystemTypeDescription == null) ? 0 : operatingSystemTypeDescription.hashCode());
		result = prime * result + ((operatingSystemTypeName == null) ? 0 : operatingSystemTypeName.hashCode());
		result = prime * result + ((operatingSystemsOfThisType == null) ? 0 : operatingSystemsOfThisType.hashCode());
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
		OperatingSystemType other = (OperatingSystemType) obj;
		if (companyOfThisOS == null) {
			if (other.companyOfThisOS != null)
				return false;
		} else if (!companyOfThisOS.equals(other.companyOfThisOS))
			return false;
		if (idOperatingSystemType == null) {
			if (other.idOperatingSystemType != null)
				return false;
		} else if (!idOperatingSystemType.equals(other.idOperatingSystemType))
			return false;
		if (operatingSystemTypeDescription == null) {
			if (other.operatingSystemTypeDescription != null)
				return false;
		} else if (!operatingSystemTypeDescription.equals(other.operatingSystemTypeDescription))
			return false;
		if (operatingSystemTypeName == null) {
			if (other.operatingSystemTypeName != null)
				return false;
		} else if (!operatingSystemTypeName.equals(other.operatingSystemTypeName))
			return false;
		if (operatingSystemsOfThisType == null) {
			if (other.operatingSystemsOfThisType != null)
				return false;
		} else if (!operatingSystemsOfThisType.equals(other.operatingSystemsOfThisType))
			return false;
		return true;
	}

}
