package al.edu.fti.gaming.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class GpuSlotDTO extends IdNameDescriptionDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2589040333052651352L;
	
	@NotNull(message = "{Pattern.laptop/desktop.Validation}")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((laptopOrDesktop == null) ? 0 : laptopOrDesktop.hashCode());
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
		GpuSlotDTO other = (GpuSlotDTO) obj;
		if (laptopOrDesktop == null) {
			if (other.laptopOrDesktop != null)
				return false;
		} else if (!laptopOrDesktop.equals(other.laptopOrDesktop))
			return false;
		return true;
	}
	
	

}
