package al.edu.fti.gaming.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class GpuArchitectureDTO extends IdNameDescriptionDTO {

	@NotNull(message = "{Pattern.CompanyOfObject.Validation}")
	private CompanyDTO companyOfThisGpuArchitecture;

	@Min(value = 1, message = "{addArchitecture.form.processNanometer.error}")
	@Max(value = 127, message = "{addArchitecture.form.processNanometer.error}")
	@NotNull(message = "{addArchitecture.form.processNanometer.required}")
	private Byte gpuProcessNanometers;

	public GpuArchitectureDTO() {
		super();
	}

	public CompanyDTO getCompanyOfThisGpuArchitecture() {
		return companyOfThisGpuArchitecture;
	}

	public void setCompanyOfThisGpuArchitecture(CompanyDTO companyOfThisGpuArchitecture) {
		this.companyOfThisGpuArchitecture = companyOfThisGpuArchitecture;
	}

	public Byte getGpuProcessNanometers() {
		return gpuProcessNanometers;
	}

	public void setGpuProcessNanometers(Byte gpuProcessNanometers) {
		this.gpuProcessNanometers = gpuProcessNanometers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((companyOfThisGpuArchitecture == null) ? 0 : companyOfThisGpuArchitecture.hashCode());
		result = prime * result + ((gpuProcessNanometers == null) ? 0 : gpuProcessNanometers.hashCode());
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
		GpuArchitectureDTO other = (GpuArchitectureDTO) obj;
		if (companyOfThisGpuArchitecture == null) {
			if (other.companyOfThisGpuArchitecture != null)
				return false;
		} else if (!companyOfThisGpuArchitecture.equals(other.companyOfThisGpuArchitecture))
			return false;
		if (gpuProcessNanometers == null) {
			if (other.gpuProcessNanometers != null)
				return false;
		} else if (!gpuProcessNanometers.equals(other.gpuProcessNanometers))
			return false;
		return true;
	}

}
