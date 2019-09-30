package al.edu.fti.gaming.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MotherboardDTO extends ProductDTO {

	@NotNull(message = "{validation.field.required}")
	@Min(value = 1, message = "{validation.field.min.one}")
	private Double maximumRamCapacity;

	@NotNull(message = "{validation.field.required}")
	@Min(value = 1, message = "{validation.field.min.one}")
	private Integer maximumRamSpeed;

	@NotNull(message = "{validation.field.required}")
	private CompanyDTO companyOfThisMotherboard;

	@NotNull(message = "{validation.field.required}")
	private CpuSocketDTO cpuSocketOfThisMotherboard;

	@NotNull(message = "{validation.field.required}")
	private MotherboardFormFactorDTO formFactorOfThisMotherboard;

	@NotNull(message = "{validation.field.required}")
	private GpuSlotDTO gpuSlotOfThisMotherboard;

	public MotherboardDTO() {
		super();
	}

	public Double getMaximumRamCapacity() {
		return maximumRamCapacity;
	}

	public void setMaximumRamCapacity(Double maximumRamCapacity) {
		this.maximumRamCapacity = maximumRamCapacity;
	}

	public Integer getMaximumRamSpeed() {
		return maximumRamSpeed;
	}

	public void setMaximumRamSpeed(Integer maximumRamSpeed) {
		this.maximumRamSpeed = maximumRamSpeed;
	}

	public CompanyDTO getCompanyOfThisMotherboard() {
		return companyOfThisMotherboard;
	}

	public void setCompanyOfThisMotherboard(CompanyDTO companyOfThisMotherboard) {
		this.companyOfThisMotherboard = companyOfThisMotherboard;
	}

	public CpuSocketDTO getCpuSocketOfThisMotherboard() {
		return cpuSocketOfThisMotherboard;
	}

	public void setCpuSocketOfThisMotherboard(CpuSocketDTO cpuSocketOfThisMotherboard) {
		this.cpuSocketOfThisMotherboard = cpuSocketOfThisMotherboard;
	}

	public MotherboardFormFactorDTO getFormFactorOfThisMotherboard() {
		return formFactorOfThisMotherboard;
	}

	public void setFormFactorOfThisMotherboard(MotherboardFormFactorDTO formFactorOfThisMotherboard) {
		this.formFactorOfThisMotherboard = formFactorOfThisMotherboard;
	}

	@Override
	public String toString() {
		return "MotherboardDTO [maximumRamCapacity=" + maximumRamCapacity + ", maximumRamSpeed=" + maximumRamSpeed
				+ ", companyOfThisMotherboard=" + companyOfThisMotherboard + ", cpuSocketOfThisMotherboard="
				+ cpuSocketOfThisMotherboard + ", formFactorOfThisMotherboard=" + formFactorOfThisMotherboard + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((companyOfThisMotherboard == null) ? 0 : companyOfThisMotherboard.hashCode());
		result = prime * result + ((cpuSocketOfThisMotherboard == null) ? 0 : cpuSocketOfThisMotherboard.hashCode());
		result = prime * result + ((formFactorOfThisMotherboard == null) ? 0 : formFactorOfThisMotherboard.hashCode());
		result = prime * result + ((maximumRamCapacity == null) ? 0 : maximumRamCapacity.hashCode());
		result = prime * result + ((maximumRamSpeed == null) ? 0 : maximumRamSpeed.hashCode());
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
		MotherboardDTO other = (MotherboardDTO) obj;
		if (companyOfThisMotherboard == null) {
			if (other.companyOfThisMotherboard != null)
				return false;
		} else if (!companyOfThisMotherboard.equals(other.companyOfThisMotherboard))
			return false;
		if (cpuSocketOfThisMotherboard == null) {
			if (other.cpuSocketOfThisMotherboard != null)
				return false;
		} else if (!cpuSocketOfThisMotherboard.equals(other.cpuSocketOfThisMotherboard))
			return false;
		if (formFactorOfThisMotherboard == null) {
			if (other.formFactorOfThisMotherboard != null)
				return false;
		} else if (!formFactorOfThisMotherboard.equals(other.formFactorOfThisMotherboard))
			return false;
		if (maximumRamCapacity == null) {
			if (other.maximumRamCapacity != null)
				return false;
		} else if (!maximumRamCapacity.equals(other.maximumRamCapacity))
			return false;
		if (maximumRamSpeed == null) {
			if (other.maximumRamSpeed != null)
				return false;
		} else if (!maximumRamSpeed.equals(other.maximumRamSpeed))
			return false;
		return true;
	}

	public GpuSlotDTO getGpuSlotOfThisMotherboard() {
		return gpuSlotOfThisMotherboard;
	}

	public void setGpuSlotOfThisMotherboard(GpuSlotDTO gpuSlotOfThisMotherboard) {
		this.gpuSlotOfThisMotherboard = gpuSlotOfThisMotherboard;
	}

}
