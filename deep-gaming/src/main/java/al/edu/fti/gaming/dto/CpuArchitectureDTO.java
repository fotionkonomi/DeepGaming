package al.edu.fti.gaming.dto;

public class CpuArchitectureDTO extends IdNameDescriptionDTO {

	private Byte cpuProcessNanometers;

	private CompanyDTO companyOfThisCpuArchitecture;

	public CpuArchitectureDTO() {
		super();
	}

	public Byte getCpuProcessNanometers() {
		return cpuProcessNanometers;
	}

	public void setCpuProcessNanometers(Byte cpuProcessNanometers) {
		this.cpuProcessNanometers = cpuProcessNanometers;
	}

	public CompanyDTO getCompanyOfThisCpuArchitecture() {
		return companyOfThisCpuArchitecture;
	}

	public void setCompanyOfThisCpuArchitecture(CompanyDTO companyOfThisCpuArchitecture) {
		this.companyOfThisCpuArchitecture = companyOfThisCpuArchitecture;
	}

}
