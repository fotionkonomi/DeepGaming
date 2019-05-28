package al.edu.fti.deep_gaming.models;

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
public class StoragePort {

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

	// Motherboard_storage
}
