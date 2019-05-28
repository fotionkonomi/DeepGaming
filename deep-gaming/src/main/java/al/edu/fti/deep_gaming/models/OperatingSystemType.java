package al.edu.fti.deep_gaming.models;

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
public class OperatingSystemType {

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
}
