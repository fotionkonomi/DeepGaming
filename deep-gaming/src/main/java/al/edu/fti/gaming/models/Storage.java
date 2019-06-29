package al.edu.fti.gaming.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "storage")
public class Storage extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1367838846228028050L;

	@Column(name = "write_speed", nullable = false)
	private Double writeSpeed;

	@Column(name = "read_speed", nullable = false)
	private Double readSpeed;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_company", nullable = false)
	private Company companyOfThisStorage;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_storage_type", nullable = false)
	private StorageType storageType;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_storage_port", nullable = false)
	private StoragePort storagePort;

	@ManyToMany(mappedBy = "storagesOfThisComputer")
	private Set<Computer> computersWithThisStorage = new HashSet<Computer>();

	public Storage(Integer idProduct, String productName, String productDescription, Date releaseDate, Integer price,
			Integer quantity, Date uploadDate, Date editedDate, User suggestedBy, User approvedBy, String hyperlink) {
		super(idProduct, productName, productDescription, releaseDate, price, quantity, uploadDate, editedDate,
				suggestedBy, approvedBy, hyperlink);
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

	public Company getCompanyOfThisStorage() {
		return companyOfThisStorage;
	}

	public void setCompanyOfThisStorage(Company companyOfThisStorage) {
		this.companyOfThisStorage = companyOfThisStorage;
	}

	public StorageType getStorageType() {
		return storageType;
	}

	public void setStorageType(StorageType storageType) {
		this.storageType = storageType;
	}

	public StoragePort getStoragePort() {
		return storagePort;
	}

	public void setStoragePort(StoragePort storagePort) {
		this.storagePort = storagePort;
	}

	public Set<Computer> getComputersWithThisStorage() {
		return computersWithThisStorage;
	}

	public void setComputersWithThisStorage(Set<Computer> computersWithThisStorage) {
		this.computersWithThisStorage = computersWithThisStorage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((companyOfThisStorage == null) ? 0 : companyOfThisStorage.hashCode());
		result = prime * result + ((computersWithThisStorage == null) ? 0 : computersWithThisStorage.hashCode());
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
		Storage other = (Storage) obj;
		if (companyOfThisStorage == null) {
			if (other.companyOfThisStorage != null)
				return false;
		} else if (!companyOfThisStorage.equals(other.companyOfThisStorage))
			return false;
		if (computersWithThisStorage == null) {
			if (other.computersWithThisStorage != null)
				return false;
		} else if (!computersWithThisStorage.equals(other.computersWithThisStorage))
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
