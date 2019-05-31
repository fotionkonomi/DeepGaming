package al.edu.fti.gaming.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "operating_system")
public class OperatingSystem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9171101315007878444L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_operating_system", nullable = false)
	private Integer idOperatingSystem;

	@Column(name = "os_name", unique = true, nullable = false, length = 50)
	private String osName;

	@Column(name = "os_description", nullable = false, length = 65535)
	private String osDescription;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_operating_system_type", nullable = false)
	private OperatingSystemType operatingSystemType;

	public OperatingSystem(Integer idOperatingSystem, String osName, String osDescription,
			OperatingSystemType operatingSystemType) {
		super();
		this.idOperatingSystem = idOperatingSystem;
		this.osName = osName;
		this.osDescription = osDescription;
		this.operatingSystemType = operatingSystemType;
	}

	public OperatingSystem() {

	}

	public Integer getIdOperatingSystem() {
		return idOperatingSystem;
	}

	public void setIdOperatingSystem(Integer idOperatingSystem) {
		this.idOperatingSystem = idOperatingSystem;
	}

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public String getOsDescription() {
		return osDescription;
	}

	public void setOsDescription(String osDescription) {
		this.osDescription = osDescription;
	}

	public OperatingSystemType getOperatingSystemType() {
		return operatingSystemType;
	}

	public void setOperatingSystemType(OperatingSystemType operatingSystemType) {
		this.operatingSystemType = operatingSystemType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idOperatingSystem == null) ? 0 : idOperatingSystem.hashCode());
		result = prime * result + ((operatingSystemType == null) ? 0 : operatingSystemType.hashCode());
		result = prime * result + ((osDescription == null) ? 0 : osDescription.hashCode());
		result = prime * result + ((osName == null) ? 0 : osName.hashCode());
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
		OperatingSystem other = (OperatingSystem) obj;
		if (idOperatingSystem == null) {
			if (other.idOperatingSystem != null)
				return false;
		} else if (!idOperatingSystem.equals(other.idOperatingSystem))
			return false;
		if (operatingSystemType == null) {
			if (other.operatingSystemType != null)
				return false;
		} else if (!operatingSystemType.equals(other.operatingSystemType))
			return false;
		if (osDescription == null) {
			if (other.osDescription != null)
				return false;
		} else if (!osDescription.equals(other.osDescription))
			return false;
		if (osName == null) {
			if (other.osName != null)
				return false;
		} else if (!osName.equals(other.osName))
			return false;
		return true;
	}

}
