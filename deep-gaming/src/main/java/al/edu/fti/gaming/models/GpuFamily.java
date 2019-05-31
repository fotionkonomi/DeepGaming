package al.edu.fti.gaming.models;

import javax.persistence.Table;

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

@Entity
@Table(name = "gpu_family")
/**
 * The class which is mapped to the "cpu_family" table in the database which
 * contains information regarding the CPU families
 * 
 * @author kfotj
 *
 */
public class GpuFamily implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4250516646786292929L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gpu_family", nullable = false)
	/**
	 * This field is mapped to the primary key of the "gpu_family" table in the
	 * database
	 */
	private Integer idGpuFamily;

	@Column(name = "gpu_family_name", unique = true, nullable = false, length = 50)
	/**
	 * This variable is mapped to the "gpu_family_name" field in the "gpu_family"
	 * table in the database which contains information regarding the GPU family's
	 * name
	 */
	private String gpuFamilyName;

	@Column(name = "gpu_family_description", nullable = false, length = 65535)
	/**
	 * This variable is mapped to the "gpu_family_description" field in the
	 * "gpu_family" table in the database which contains information regarding
	 * generic information about a GPU family
	 */
	private String gpuFamilyDescription;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_company", nullable = false)
	/**
	 * This variable represents the company which created a GPU family. It maps the
	 * id of the company in the database
	 */
	private Company companyOfThisGpuFamily;

	@OneToMany(mappedBy = "familyOfThisGpu")
	private List<GPU> gpusOfThisFamily = new ArrayList<GPU>();

	public GpuFamily(Integer idGpuFamily, String gpuFamilyName, String gpuFamilyDescription,
			Company companyOfThisGpuFamily, List<GPU> gpusOfThisFamily) {
		super();
		this.idGpuFamily = idGpuFamily;
		this.gpuFamilyName = gpuFamilyName;
		this.gpuFamilyDescription = gpuFamilyDescription;
		this.companyOfThisGpuFamily = companyOfThisGpuFamily;
		this.gpusOfThisFamily = gpusOfThisFamily;
	}

	public GpuFamily() {

	}

	public Integer getIdGpuFamily() {
		return idGpuFamily;
	}

	public void setIdGpuFamily(Integer idGpuFamily) {
		this.idGpuFamily = idGpuFamily;
	}

	public String getGpuFamilyName() {
		return gpuFamilyName;
	}

	public void setGpuFamilyName(String gpuFamilyName) {
		this.gpuFamilyName = gpuFamilyName;
	}

	public String getGpuFamilyDescription() {
		return gpuFamilyDescription;
	}

	public void setGpuFamilyDescription(String gpuFamilyDescription) {
		this.gpuFamilyDescription = gpuFamilyDescription;
	}

	public Company getCompanyOfThisGpuFamily() {
		return companyOfThisGpuFamily;
	}

	public void setCompanyOfThisGpuFamily(Company companyOfThisGpuFamily) {
		this.companyOfThisGpuFamily = companyOfThisGpuFamily;
	}

	public List<GPU> getGpusOfThisFamily() {
		return gpusOfThisFamily;
	}

	public void setGpusOfThisFamily(List<GPU> gpusOfThisFamily) {
		this.gpusOfThisFamily = gpusOfThisFamily;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyOfThisGpuFamily == null) ? 0 : companyOfThisGpuFamily.hashCode());
		result = prime * result + ((gpuFamilyDescription == null) ? 0 : gpuFamilyDescription.hashCode());
		result = prime * result + ((gpuFamilyName == null) ? 0 : gpuFamilyName.hashCode());
		result = prime * result + ((gpusOfThisFamily == null) ? 0 : gpusOfThisFamily.hashCode());
		result = prime * result + ((idGpuFamily == null) ? 0 : idGpuFamily.hashCode());
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
		GpuFamily other = (GpuFamily) obj;
		if (companyOfThisGpuFamily == null) {
			if (other.companyOfThisGpuFamily != null)
				return false;
		} else if (!companyOfThisGpuFamily.equals(other.companyOfThisGpuFamily))
			return false;
		if (gpuFamilyDescription == null) {
			if (other.gpuFamilyDescription != null)
				return false;
		} else if (!gpuFamilyDescription.equals(other.gpuFamilyDescription))
			return false;
		if (gpuFamilyName == null) {
			if (other.gpuFamilyName != null)
				return false;
		} else if (!gpuFamilyName.equals(other.gpuFamilyName))
			return false;
		if (gpusOfThisFamily == null) {
			if (other.gpusOfThisFamily != null)
				return false;
		} else if (!gpusOfThisFamily.equals(other.gpusOfThisFamily))
			return false;
		if (idGpuFamily == null) {
			if (other.idGpuFamily != null)
				return false;
		} else if (!idGpuFamily.equals(other.idGpuFamily))
			return false;
		return true;
	}

}
