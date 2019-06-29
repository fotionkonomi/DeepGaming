package al.edu.fti.gaming.dto;

public class StorageDTO extends ProductDTO {

	private Double writeSpeed;

	private Double readSpeed;

	private CompanyDTO companyOfThisStorage;

	private StorageTypeDTO storageType;

	private StoragePortDTO storagePort;

	public StorageDTO() {
		super();
	}

	public Double getWriteSpeed() {
		return writeSpeed;
	}

	public void setWriteSpeed(Double writeSpeed) {
		this.writeSpeed = writeSpeed;
	}

	public Double getReadSpeed() {
		return readSpeed;
	}

	public void setReadSpeed(Double readSpeed) {
		this.readSpeed = readSpeed;
	}

	public CompanyDTO getCompanyOfThisStorage() {
		return companyOfThisStorage;
	}

	public void setCompanyOfThisStorage(CompanyDTO companyOfThisStorage) {
		this.companyOfThisStorage = companyOfThisStorage;
	}

	public StorageTypeDTO getStorageType() {
		return storageType;
	}

	public void setStorageType(StorageTypeDTO storageType) {
		this.storageType = storageType;
	}

	public StoragePortDTO getStoragePort() {
		return storagePort;
	}

	public void setStoragePort(StoragePortDTO storagePort) {
		this.storagePort = storagePort;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((companyOfThisStorage == null) ? 0 : companyOfThisStorage.hashCode());
		result = prime * result + ((readSpeed == null) ? 0 : readSpeed.hashCode());
		result = prime * result + ((storagePort == null) ? 0 : storagePort.hashCode());
		result = prime * result + ((storageType == null) ? 0 : storageType.hashCode());
		result = prime * result + ((writeSpeed == null) ? 0 : writeSpeed.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		StorageDTO other = (StorageDTO) obj;
		if (companyOfThisStorage == null) {
			if (other.companyOfThisStorage != null)
				return false;
		} else if (!companyOfThisStorage.equals(other.companyOfThisStorage))
			return false;
		if (readSpeed == null) {
			if (other.readSpeed != null)
				return false;
		} else if (!readSpeed.equals(other.readSpeed))
			return false;
		if (storagePort == null) {
			if (other.storagePort != null)
				return false;
		} else if (!storagePort.equals(other.storagePort))
			return false;
		if (storageType == null) {
			if (other.storageType != null)
				return false;
		} else if (!storageType.equals(other.storageType))
			return false;
		if (writeSpeed == null) {
			if (other.writeSpeed != null)
				return false;
		} else if (!writeSpeed.equals(other.writeSpeed))
			return false;
		return true;
	}

}
