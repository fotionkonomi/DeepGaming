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
	
	

}
