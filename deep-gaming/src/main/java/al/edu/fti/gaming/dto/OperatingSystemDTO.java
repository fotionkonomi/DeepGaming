package al.edu.fti.gaming.dto;

public class OperatingSystemDTO extends IdNameDescriptionDTO {

	private OperatingSystemTypeDTO operatingSystemType;

	public OperatingSystemDTO() {
		super();
	}
	
	public OperatingSystemTypeDTO getOperatingSystemType() {
		return operatingSystemType;
	}

	public void setOperatingSystemType(OperatingSystemTypeDTO operatingSystemType) {
		this.operatingSystemType = operatingSystemType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((operatingSystemType == null) ? 0 : operatingSystemType.hashCode());
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
		OperatingSystemDTO other = (OperatingSystemDTO) obj;
		if (operatingSystemType == null) {
			if (other.operatingSystemType != null)
				return false;
		} else if (!operatingSystemType.equals(other.operatingSystemType))
			return false;
		return true;
	}
	
	

}
