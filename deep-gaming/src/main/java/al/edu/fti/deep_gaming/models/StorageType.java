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
@Table(name = "storage_type")
public class StorageType {

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
}
