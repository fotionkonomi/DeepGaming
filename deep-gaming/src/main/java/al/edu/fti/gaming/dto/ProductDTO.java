package al.edu.fti.gaming.dto;

import java.util.Date;

public class ProductDTO extends IdNameDescriptionDTO {

	private Date releaseDate;
	
	private Integer price;
	
	private Integer quantity;
	
	private Date uploadDate;
	
	private Date editedDate;
	
	private UserDTO suggestedBy;
	
	private UserDTO approvedBy;
	
	private String hyperlink;
	
	public ProductDTO() {
		super();
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Date getEditedDate() {
		return editedDate;
	}

	public void setEditedDate(Date editedDate) {
		this.editedDate = editedDate;
	}

	public UserDTO getSuggestedBy() {
		return suggestedBy;
	}

	public void setSuggestedBy(UserDTO suggestedBy) {
		this.suggestedBy = suggestedBy;
	}

	public UserDTO getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(UserDTO approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getHyperlink() {
		return hyperlink;
	}

	public void setHyperlink(String hyperlink) {
		this.hyperlink = hyperlink;
	}
	
	
	
}
