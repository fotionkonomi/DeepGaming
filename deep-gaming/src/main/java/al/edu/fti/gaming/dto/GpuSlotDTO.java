package al.edu.fti.gaming.dto;

public class GpuSlotDTO extends IdNameDescriptionDTO {

	private Boolean laptopOrDesktop;

	public GpuSlotDTO() {
		super();
	}

	public Boolean getLaptopOrDesktop() {
		return laptopOrDesktop;
	}

	public void setLaptopOrDesktop(Boolean laptopOrDesktop) {
		this.laptopOrDesktop = laptopOrDesktop;
	}

}
