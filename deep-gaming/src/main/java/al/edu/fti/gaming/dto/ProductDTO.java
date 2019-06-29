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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((approvedBy == null) ? 0 : approvedBy.hashCode());
		result = prime * result + ((editedDate == null) ? 0 : editedDate.hashCode());
		result = prime * result + ((hyperlink == null) ? 0 : hyperlink.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + ((suggestedBy == null) ? 0 : suggestedBy.hashCode());
		result = prime * result + ((uploadDate == null) ? 0 : uploadDate.hashCode());
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
		ProductDTO other = (ProductDTO) obj;
		if (approvedBy == null) {
			if (other.approvedBy != null)
				return false;
		} else if (!approvedBy.equals(other.approvedBy))
			return false;
		if (editedDate == null) {
			if (other.editedDate != null)
				return false;
		} else if (!editedDate.equals(other.editedDate))
			return false;
		if (hyperlink == null) {
			if (other.hyperlink != null)
				return false;
		} else if (!hyperlink.equals(other.hyperlink))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.equals(other.releaseDate))
			return false;
		if (suggestedBy == null) {
			if (other.suggestedBy != null)
				return false;
		} else if (!suggestedBy.equals(other.suggestedBy))
			return false;
		if (uploadDate == null) {
			if (other.uploadDate != null)
				return false;
		} else if (!uploadDate.equals(other.uploadDate))
			return false;
		return true;
	}
	
	
	
	
}
