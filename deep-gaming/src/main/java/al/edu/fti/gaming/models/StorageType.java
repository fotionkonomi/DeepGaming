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
@Table(name = "storage_type")
public class StorageType implements Serializable, IModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 676526752538373348L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_storage_type", nullable = false)
	private Integer idStorageType;

	@Column(name = "storage_type_name", nullable = false, length = 50)
	private String storageTypeName;

	@Column(name = "storage_type_description", nullable = false, length = 65535)
	private String storageTypeDescription;

	@OneToMany(mappedBy = "storageType")
	private List<Storage> storagesOfThisType = new ArrayList<Storage>();

	public StorageType(Integer idStorageType, String storageTypeName, String storageTypeDescription,
			List<Storage> storagesOfThisType) {
		super();
		this.idStorageType = idStorageType;
		this.storageTypeName = storageTypeName;
		this.storageTypeDescription = storageTypeDescription;
		this.storagesOfThisType = storagesOfThisType;
	}

	public StorageType() {
		super();
	}

	public Integer getIdStorageType() {
		return idStorageType;
	}

	public void setIdStorageType(Integer idStorageType) {
		this.idStorageType = idStorageType;
	}

	public String getStorageTypeName() {
		return storageTypeName;
	}

	public void setStorageTypeName(String storageTypeName) {
		this.storageTypeName = storageTypeName;
	}

	public String getStorageTypeDescription() {
		return storageTypeDescription;
	}

	public void setStorageTypeDescription(String storageTypeDescription) {
		this.storageTypeDescription = storageTypeDescription;
	}

	public List<Storage> getStoragesOfThisType() {
		return storagesOfThisType;
	}

	public void setStoragesOfThisType(List<Storage> storagesOfThisType) {
		this.storagesOfThisType = storagesOfThisType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idStorageType == null) ? 0 : idStorageType.hashCode());
		result = prime * result + ((storageTypeDescription == null) ? 0 : storageTypeDescription.hashCode());
		result = prime * result + ((storageTypeName == null) ? 0 : storageTypeName.hashCode());
		result = prime * result + ((storagesOfThisType == null) ? 0 : storagesOfThisType.hashCode());
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
		StorageType other = (StorageType) obj;
		if (idStorageType == null) {
			if (other.idStorageType != null)
				return false;
		} else if (!idStorageType.equals(other.idStorageType))
			return false;
		if (storageTypeDescription == null) {
			if (other.storageTypeDescription != null)
				return false;
		} else if (!storageTypeDescription.equals(other.storageTypeDescription))
			return false;
		if (storageTypeName == null) {
			if (other.storageTypeName != null)
				return false;
		} else if (!storageTypeName.equals(other.storageTypeName))
			return false;
		if (storagesOfThisType == null) {
			if (other.storagesOfThisType != null)
				return false;
		} else if (!storagesOfThisType.equals(other.storagesOfThisType))
			return false;
		return true;
	}

}
