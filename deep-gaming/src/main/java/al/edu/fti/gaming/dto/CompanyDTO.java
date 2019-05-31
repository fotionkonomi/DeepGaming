package al.edu.fti.gaming.dto;

import java.util.Date;

public class CompanyDTO extends IdNameDescriptionDTO {

	private Date dateOfCreation;

	private String hyperlink;

	public CompanyDTO() {
		super();
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public String getHyperlink() {
		return hyperlink;
	}

	public void setHyperlink(String hyperlink) {
		this.hyperlink = hyperlink;
	}
	
	
	

}
