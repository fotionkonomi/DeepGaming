package al.edu.fti.gaming.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public class CompanyDTO extends IdNameDescriptionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5919058361078571414L;
	@NotBlank(message = "{Pattern.Hyperlink.Validation}")
	@URL(message = "{Pattern.Hyperlink.Validation}")
	private String hyperlink;

	public CompanyDTO() {
		super();
	}

	public String getHyperlink() {
		return hyperlink;
	}

	public void setHyperlink(String hyperlink) {
		this.hyperlink = hyperlink;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((hyperlink == null) ? 0 : hyperlink.hashCode());
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
		CompanyDTO other = (CompanyDTO) obj;
		if (hyperlink == null) {
			if (other.hyperlink != null)
				return false;
		} else if (!hyperlink.equals(other.hyperlink))
			return false;
		return true;
	}

}
