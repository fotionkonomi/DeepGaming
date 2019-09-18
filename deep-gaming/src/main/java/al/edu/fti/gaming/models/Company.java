package al.edu.fti.gaming.models;

import java.io.Serializable;
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
@Table(name = "company")
/**
 * Klasa Company sherben per te specifikuar cila kompani ka krijuar nje prej
 * produkteve qe ndodhen ne sistem
 * 
 * @author kfotj
 *
 */
public class Company implements IModel, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6246367071634836278L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_company")
	/**
	 * Çelesi primar ne tabelen "company" ne bazen e te dhenave, i cili
	 * autoinkrementohet
	 */
	private Integer idCompany;

	@Column(name = "company_name", nullable = false, length = 50, unique = true)
	/**
	 * Variabli lidhet me fushen "company_name" ne bazen e te dhenave, e cila mban
	 * informacion rreth emrit te kompanise
	 */
	private String companyName;

	@Column(name = "company_description", nullable = false, length = 65535)
	/**
	 * Variabli lidhet me fushen "company_description" ne bazen e te dhenave, e cila
	 * mban informacion per te pershkruar kompanine
	 */
	private String companyDescription;

	@Column(name = "hyperlink", nullable = false, length = 255)
	/**
	 * Variabli lidhet me fushen "hyperlink" ne bazen e te dhenave dhe mban nje link
	 * qe perdoruesi mund ta perdore per te pare me shume informacion rreth
	 * kompanise se ajo e ofruar ne sistemin tone
	 */
	private String hyperlink;

	@OneToMany(mappedBy = "companyOfThisCpuFamily")
	/**
	 * CPU Families that are created by this company
	 */
	private List<CpuFamily> cpuFamiliesOfThisCompany = new ArrayList<>();

	@OneToMany(mappedBy = "companyOfThisGpuFamily")
	/**
	 * GPU Families that are created by this company
	 */
	private List<GpuFamily> gpuFamiliesOfThisCompany = new ArrayList<>();

	@OneToMany(mappedBy = "companyOfThisCpuArchitecture")
	/**
	 * CPU architectures that are created by this company
	 */
	private List<CpuArchitecture> cpuArchitecturesOfThisCompany = new ArrayList<>();

	@OneToMany(mappedBy = "companyOfThisGpuArchitecture")
	/**
	 * GPU architectures that are created by this company
	 */
	private List<GpuArchitecture> gpuArchitecturesOfThisCompany = new ArrayList<>();

	@OneToMany(mappedBy = "companyThatCreatedThisSocket")
	/**
	 * CPU sockets that are created by this company
	 */
	private List<CpuSocket> cpuSocketsOfThisCompany = new ArrayList<>();

	@OneToMany(mappedBy = "companyOfThisMotherboard")
	private List<Motherboard> motherboardsOfThisCompany = new ArrayList<Motherboard>();

	public Integer getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Integer idCompany) {
		this.idCompany = idCompany;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	public String getHyperlink() {
		return hyperlink;
	}

	public void setHyperlink(String hyperlink) {
		this.hyperlink = hyperlink;
	}

	public List<CpuFamily> getCpuFamiliesOfThisCompany() {
		return cpuFamiliesOfThisCompany;
	}

	public void setCpuFamiliesOfThisCompany(List<CpuFamily> cpuFamiliesOfThisCompany) {
		this.cpuFamiliesOfThisCompany = cpuFamiliesOfThisCompany;
	}

	public List<GpuFamily> getGpuFamiliesOfThisCompany() {
		return gpuFamiliesOfThisCompany;
	}

	public void setGpuFamiliesOfThisCompany(List<GpuFamily> gpuFamiliesOfThisCompany) {
		this.gpuFamiliesOfThisCompany = gpuFamiliesOfThisCompany;
	}

	public List<CpuArchitecture> getCpuArchitecturesOfThisCompany() {
		return cpuArchitecturesOfThisCompany;
	}

	public void setCpuArchitecturesOfThisCompany(List<CpuArchitecture> cpuArchitecturesOfThisCompany) {
		this.cpuArchitecturesOfThisCompany = cpuArchitecturesOfThisCompany;
	}

	public List<GpuArchitecture> getGpuArchitecturesOfThisCompany() {
		return gpuArchitecturesOfThisCompany;
	}

	public void setGpuArchitecturesOfThisCompany(List<GpuArchitecture> gpuArchitecturesOfThisCompany) {
		this.gpuArchitecturesOfThisCompany = gpuArchitecturesOfThisCompany;
	}

	public List<CpuSocket> getCpuSocketsOfThisCompany() {
		return cpuSocketsOfThisCompany;
	}

	public void setCpuSocketsOfThisCompany(List<CpuSocket> cpuSocketsOfThisCompany) {
		this.cpuSocketsOfThisCompany = cpuSocketsOfThisCompany;
	}

	public List<Motherboard> getMotherboardsOfThisCompany() {
		return motherboardsOfThisCompany;
	}

	public void setMotherboardsOfThisCompany(List<Motherboard> motherboardsOfThisCompany) {
		this.motherboardsOfThisCompany = motherboardsOfThisCompany;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyDescription == null) ? 0 : companyDescription.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result
				+ ((cpuArchitecturesOfThisCompany == null) ? 0 : cpuArchitecturesOfThisCompany.hashCode());
		result = prime * result + ((cpuFamiliesOfThisCompany == null) ? 0 : cpuFamiliesOfThisCompany.hashCode());
		result = prime * result + ((cpuSocketsOfThisCompany == null) ? 0 : cpuSocketsOfThisCompany.hashCode());
		result = prime * result
				+ ((gpuArchitecturesOfThisCompany == null) ? 0 : gpuArchitecturesOfThisCompany.hashCode());
		result = prime * result + ((gpuFamiliesOfThisCompany == null) ? 0 : gpuFamiliesOfThisCompany.hashCode());
		result = prime * result + ((hyperlink == null) ? 0 : hyperlink.hashCode());
		result = prime * result + ((idCompany == null) ? 0 : idCompany.hashCode());
		result = prime * result + ((motherboardsOfThisCompany == null) ? 0 : motherboardsOfThisCompany.hashCode());
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
		Company other = (Company) obj;
		if (companyDescription == null) {
			if (other.companyDescription != null)
				return false;
		} else if (!companyDescription.equals(other.companyDescription))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (cpuArchitecturesOfThisCompany == null) {
			if (other.cpuArchitecturesOfThisCompany != null)
				return false;
		} else if (!cpuArchitecturesOfThisCompany.equals(other.cpuArchitecturesOfThisCompany))
			return false;
		if (cpuFamiliesOfThisCompany == null) {
			if (other.cpuFamiliesOfThisCompany != null)
				return false;
		} else if (!cpuFamiliesOfThisCompany.equals(other.cpuFamiliesOfThisCompany))
			return false;
		if (cpuSocketsOfThisCompany == null) {
			if (other.cpuSocketsOfThisCompany != null)
				return false;
		} else if (!cpuSocketsOfThisCompany.equals(other.cpuSocketsOfThisCompany))
			return false;
		if (gpuArchitecturesOfThisCompany == null) {
			if (other.gpuArchitecturesOfThisCompany != null)
				return false;
		} else if (!gpuArchitecturesOfThisCompany.equals(other.gpuArchitecturesOfThisCompany))
			return false;
		if (gpuFamiliesOfThisCompany == null) {
			if (other.gpuFamiliesOfThisCompany != null)
				return false;
		} else if (!gpuFamiliesOfThisCompany.equals(other.gpuFamiliesOfThisCompany))
			return false;
		if (hyperlink == null) {
			if (other.hyperlink != null)
				return false;
		} else if (!hyperlink.equals(other.hyperlink))
			return false;
		if (idCompany == null) {
			if (other.idCompany != null)
				return false;
		} else if (!idCompany.equals(other.idCompany))
			return false;
		if (motherboardsOfThisCompany == null) {
			if (other.motherboardsOfThisCompany != null)
				return false;
		} else if (!motherboardsOfThisCompany.equals(other.motherboardsOfThisCompany))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Company [idCompany=" + idCompany + ", companyName=" + companyName + ", companyDescription="
				+ companyDescription + ", hyperlink=" + hyperlink + ", cpuFamiliesOfThisCompany="
				+ cpuFamiliesOfThisCompany + ", gpuFamiliesOfThisCompany=" + gpuFamiliesOfThisCompany
				+ ", cpuArchitecturesOfThisCompany=" + cpuArchitecturesOfThisCompany
				+ ", gpuArchitecturesOfThisCompany=" + gpuArchitecturesOfThisCompany + ", cpuSocketsOfThisCompany="
				+ cpuSocketsOfThisCompany + ", motherboardsOfThisCompany=" + motherboardsOfThisCompany + "]";
	}

}
