package al.edu.fti.gaming.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "storage_port")
public class StoragePort implements Serializable, IModel{

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
	private static final long serialVersionUID = 5333793910859336198L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_storage_port", nullable = false)
	private Integer idStoragePort;

	@Column(name = "name", unique = true, nullable = false, length = 100)
	private String name;

	@Column(name = "description", nullable = false, length = 65535)
	private String description;

	@OneToMany(mappedBy = "storagePort")
	private List<Storage> storagesWithThisPort = new ArrayList<Storage>();

	public StoragePort(Integer idStoragePort, String name, String description, List<Storage> storagesWithThisPort) {
		super();
		this.idStoragePort = idStoragePort;
		this.name = name;
		this.description = description;
		this.storagesWithThisPort = storagesWithThisPort;
	}

	public StoragePort() {
		super();
	}

	public Integer getIdStoragePort() {
		return idStoragePort;
	}

	public void setIdStoragePort(Integer idStoragePort) {
		this.idStoragePort = idStoragePort;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Storage> getStoragesWithThisPort() {
		return storagesWithThisPort;
	}

	public void setStoragesWithThisPort(List<Storage> storagesWithThisPort) {
		this.storagesWithThisPort = storagesWithThisPort;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((idStoragePort == null) ? 0 : idStoragePort.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((storagesWithThisPort == null) ? 0 : storagesWithThisPort.hashCode());
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
		StoragePort other = (StoragePort) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idStoragePort == null) {
			if (other.idStoragePort != null)
				return false;
		} else if (!idStoragePort.equals(other.idStoragePort))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (storagesWithThisPort == null) {
			if (other.storagesWithThisPort != null)
				return false;
		} else if (!storagesWithThisPort.equals(other.storagesWithThisPort))
			return false;
		return true;
	}

	

}
