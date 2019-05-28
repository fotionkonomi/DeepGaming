package al.edu.fti.deep_gaming.models;

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
public class OperatingSystem {

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
}
