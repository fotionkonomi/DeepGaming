package al.edu.fti.gaming.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CpuArchitectureDTO extends IdNameDescriptionDTO {

	@Min(0)
	@Max(127)
	private Byte cpuProcessNanometers;

	@NotNull(message = "{Pattern.CompanyOfObject.Validation}")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((companyOfThisCpuArchitecture == null) ? 0 : companyOfThisCpuArchitecture.hashCode());
		result = prime * result + ((cpuProcessNanometers == null) ? 0 : cpuProcessNanometers.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CpuArchitectureDTO other = (CpuArchitectureDTO) obj;
		if (companyOfThisCpuArchitecture == null) {
			if (other.companyOfThisCpuArchitecture != null)
				return false;
		} else if (!companyOfThisCpuArchitecture.equals(other.companyOfThisCpuArchitecture))
			return false;
		if (cpuProcessNanometers == null) {
			if (other.cpuProcessNanometers != null)
				return false;
		} else if (!cpuProcessNanometers.equals(other.cpuProcessNanometers))
			return false;
		return true;
	}

}
