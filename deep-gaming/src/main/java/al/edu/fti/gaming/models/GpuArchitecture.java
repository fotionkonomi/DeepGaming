package al.edu.fti.gaming.models;

import java.io.Serializable;
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
@Table(name = "gpu_architecture")
/**
 * This is the class which is mapped to the "gpu_architecture" table in the
 * database which contains information regarding the different types of graphic
 * card architectures
 * 
 * @author kfotj
 *
 */
public class GpuArchitecture implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4540326396482357907L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gpu_architecture", nullable = false)
	/**
	 * This variable is mapped to the primary key of the "gpu_architecture" table in
	 * the database
	 */
	private Integer idGpuArchitecture;

	@Column(name = "gpu_architecture_name", unique = true, nullable = false, length = 50)
	/**
	 * This variable is mapped to the "gpu_architecture_name" field in the
	 * "gpu_architecture" table in the database which contains the name of the
	 * specific graphic card architecture
	 */
	private String gpuArchitectureName;

	@Column(name = "gpu_architecture_description", nullable = false, length = 65535)
	/**
	 * This variable is mapped to the "gpu_architecture_description" field in the
	 * "gpu_architecture" table in the database and it contains generic information
	 * regarding a specific graphic card architecture
	 */
	private String gpuArchitectureDescription;

	@Column(name = "gpu_process_nm", nullable = false)
	/**
	 * This variable is mapped to the "gpu_process_nm" field in the
	 * "gpu_architecture" table in the database which contains information regarding
	 * the size of the transistors in this architecture
	 */
	private Byte gpuProcessNanometers;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_company", nullable = false)
	/**
	 * This variable contains the company that created a specific graphic card
	 * architecture
	 */
	private Company companyOfThisGpuArchitecture;

	@OneToMany(mappedBy = "architectureOfThisGpu")
	private List<GPU> gpusOfThisArchitecture = new ArrayList<GPU>();

	public GpuArchitecture(Integer idGpuArchitecture, String gpuArchitectureName, String gpuArchitectureDescription,
			Byte gpuProcessNanometers, Company companyOfThisGpuArchitecture, List<GPU> gpusOfThisArchitecture) {
		super();
		this.idGpuArchitecture = idGpuArchitecture;
		this.gpuArchitectureName = gpuArchitectureName;
		this.gpuArchitectureDescription = gpuArchitectureDescription;
		this.gpuProcessNanometers = gpuProcessNanometers;
		this.companyOfThisGpuArchitecture = companyOfThisGpuArchitecture;
		this.gpusOfThisArchitecture = gpusOfThisArchitecture;
	}

	public GpuArchitecture() {

	}

	public Integer getIdGpuArchitecture() {
		return idGpuArchitecture;
	}

	public void setIdGpuArchitecture(Integer idGpuArchitecture) {
		this.idGpuArchitecture = idGpuArchitecture;
	}

	public String getGpuArchitectureName() {
		return gpuArchitectureName;
	}

	public void setGpuArchitectureName(String gpuArchitectureName) {
		this.gpuArchitectureName = gpuArchitectureName;
	}

	public String getGpuArchitectureDescription() {
		return gpuArchitectureDescription;
	}

	public void setGpuArchitectureDescription(String gpuArchitectureDescription) {
		this.gpuArchitectureDescription = gpuArchitectureDescription;
	}

	public Byte getGpuProcessNanometers() {
		return gpuProcessNanometers;
	}

	public void setGpuProcessNanometers(Byte gpuProcessNanometers) {
		this.gpuProcessNanometers = gpuProcessNanometers;
	}

	public Company getCompanyOfThisGpuArchitecture() {
		return companyOfThisGpuArchitecture;
	}

	public void setCompanyOfThisGpuArchitecture(Company companyOfThisGpuArchitecture) {
		this.companyOfThisGpuArchitecture = companyOfThisGpuArchitecture;
	}

	public List<GPU> getGpusOfThisArchitecture() {
		return gpusOfThisArchitecture;
	}

	public void setGpusOfThisArchitecture(List<GPU> gpusOfThisArchitecture) {
		this.gpusOfThisArchitecture = gpusOfThisArchitecture;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((companyOfThisGpuArchitecture == null) ? 0 : companyOfThisGpuArchitecture.hashCode());
		result = prime * result + ((gpuArchitectureDescription == null) ? 0 : gpuArchitectureDescription.hashCode());
		result = prime * result + ((gpuArchitectureName == null) ? 0 : gpuArchitectureName.hashCode());
		result = prime * result + ((gpuProcessNanometers == null) ? 0 : gpuProcessNanometers.hashCode());
		result = prime * result + ((gpusOfThisArchitecture == null) ? 0 : gpusOfThisArchitecture.hashCode());
		result = prime * result + ((idGpuArchitecture == null) ? 0 : idGpuArchitecture.hashCode());
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
		GpuArchitecture other = (GpuArchitecture) obj;
		if (companyOfThisGpuArchitecture == null) {
			if (other.companyOfThisGpuArchitecture != null)
				return false;
		} else if (!companyOfThisGpuArchitecture.equals(other.companyOfThisGpuArchitecture))
			return false;
		if (gpuArchitectureDescription == null) {
			if (other.gpuArchitectureDescription != null)
				return false;
		} else if (!gpuArchitectureDescription.equals(other.gpuArchitectureDescription))
			return false;
		if (gpuArchitectureName == null) {
			if (other.gpuArchitectureName != null)
				return false;
		} else if (!gpuArchitectureName.equals(other.gpuArchitectureName))
			return false;
		if (gpuProcessNanometers == null) {
			if (other.gpuProcessNanometers != null)
				return false;
		} else if (!gpuProcessNanometers.equals(other.gpuProcessNanometers))
			return false;
		if (gpusOfThisArchitecture == null) {
			if (other.gpusOfThisArchitecture != null)
				return false;
		} else if (!gpusOfThisArchitecture.equals(other.gpusOfThisArchitecture))
			return false;
		if (idGpuArchitecture == null) {
			if (other.idGpuArchitecture != null)
				return false;
		} else if (!idGpuArchitecture.equals(other.idGpuArchitecture))
			return false;
		return true;
	}

}
