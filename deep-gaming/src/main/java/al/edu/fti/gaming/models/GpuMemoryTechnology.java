package al.edu.fti.gaming.models;

import javax.persistence.Table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name = "gpu_memory_technology")
/**
 * Klasa e cila lidhet me tabelen "gpu_memory_technology" ne bazen e te dhenave,
 * e cila mban informacion rreth teknologjive te memories se kartave grafike
 * 
 * @author kfotj
 *
 */
public class GpuMemoryTechnology implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1000028234595028623L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gpu_memory_technology", nullable = false)
	/**
	 * Celesi primar ne tabelen "gpu_memory_technology" ne bazen e te dhenave
	 */
	private Integer idGpuMemoryTechnology;

	@Column(name = "gpu_memory_technology_name", unique = true, nullable = false, length = 50)
	/**
	 * Variabli lidhet me fushen "gpu_memory_technology_name" ne tabelen
	 * "gpu_memory_technology" ne bazen e te dhenave, e cila mban informacion ne
	 * lidhje me emrin e teknologjise
	 */
	private String gpuMemoryTechnologyName;

	@Column(name = "gpu_memory_technology_description", nullable = false, length = 65535)
	/**
	 * Variabli lidhet me fushen "gpu_memory_technology_description" ne tabelen
	 * "gpu_memory_technology" ne bazen e te dhenave, e cila mban informacion qe
	 * pershkruan kete lloj teknologjie
	 */
	private String gpuMemoryTechnologyDescription;

	@OneToMany(mappedBy = "memoryTechnologyOfThisGpu")
	private List<GPU> gpusWithThisMemoryTechnology = new ArrayList<GPU>();

	public GpuMemoryTechnology(Integer idGpuMemoryTechnology, String gpuMemoryTechnologyName,
			String gpuMemoryTechnologyDescription, List<GPU> gpusWithThisMemoryTechnology) {
		super();
		this.idGpuMemoryTechnology = idGpuMemoryTechnology;
		this.gpuMemoryTechnologyName = gpuMemoryTechnologyName;
		this.gpuMemoryTechnologyDescription = gpuMemoryTechnologyDescription;
		this.gpusWithThisMemoryTechnology = gpusWithThisMemoryTechnology;
	}

	public GpuMemoryTechnology() {

	}

	public Integer getIdGpuMemoryTechnology() {
		return idGpuMemoryTechnology;
	}

	public void setIdGpuMemoryTechnology(Integer idGpuMemoryTechnology) {
		this.idGpuMemoryTechnology = idGpuMemoryTechnology;
	}

	public String getGpuMemoryTechnologyName() {
		return gpuMemoryTechnologyName;
	}

	public void setGpuMemoryTechnologyName(String gpuMemoryTechnologyName) {
		this.gpuMemoryTechnologyName = gpuMemoryTechnologyName;
	}

	public String getGpuMemoryTechnologyDescription() {
		return gpuMemoryTechnologyDescription;
	}

	public void setGpuMemoryTechnologyDescription(String gpuMemoryTechnologyDescription) {
		this.gpuMemoryTechnologyDescription = gpuMemoryTechnologyDescription;
	}

	public List<GPU> getGpusWithThisMemoryTechnology() {
		return gpusWithThisMemoryTechnology;
	}

	public void setGpusWithThisMemoryTechnology(List<GPU> gpusWithThisMemoryTechnology) {
		this.gpusWithThisMemoryTechnology = gpusWithThisMemoryTechnology;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((gpuMemoryTechnologyDescription == null) ? 0 : gpuMemoryTechnologyDescription.hashCode());
		result = prime * result + ((gpuMemoryTechnologyName == null) ? 0 : gpuMemoryTechnologyName.hashCode());
		result = prime * result
				+ ((gpusWithThisMemoryTechnology == null) ? 0 : gpusWithThisMemoryTechnology.hashCode());
		result = prime * result + ((idGpuMemoryTechnology == null) ? 0 : idGpuMemoryTechnology.hashCode());
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
		GpuMemoryTechnology other = (GpuMemoryTechnology) obj;
		if (gpuMemoryTechnologyDescription == null) {
			if (other.gpuMemoryTechnologyDescription != null)
				return false;
		} else if (!gpuMemoryTechnologyDescription.equals(other.gpuMemoryTechnologyDescription))
			return false;
		if (gpuMemoryTechnologyName == null) {
			if (other.gpuMemoryTechnologyName != null)
				return false;
		} else if (!gpuMemoryTechnologyName.equals(other.gpuMemoryTechnologyName))
			return false;
		if (gpusWithThisMemoryTechnology == null) {
			if (other.gpusWithThisMemoryTechnology != null)
				return false;
		} else if (!gpusWithThisMemoryTechnology.equals(other.gpusWithThisMemoryTechnology))
			return false;
		if (idGpuMemoryTechnology == null) {
			if (other.idGpuMemoryTechnology != null)
				return false;
		} else if (!idGpuMemoryTechnology.equals(other.idGpuMemoryTechnology))
			return false;
		return true;
	}

}
