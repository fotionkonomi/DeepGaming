package al.edu.fti.gaming.models;

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

}
