package al.edu.fti.gaming.dto;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

public class ProductDTO extends IdNameDescriptionDTO {

	private Date releaseDate;

	@Min(value = 1, message = "{validation.field.min.one}")
	private Integer price;

	@Min(value = 1, message = "{validation.field.min.one}")
	private Integer quantity;

	private Date uploadDate;

	private Date editedDate;

	@NotBlank(message = "{Pattern.Hyperlink.Validation}")
	@URL(message = "{Pattern.Hyperlink.Validation}")
	private String hyperlink;

	@Pattern(regexp = "(20\\d{2})-(\\d{2})-(\\d{2})", message = "{date.validator}")
	@NotEmpty(message = "{validation.field.required}")
	private String date;

	private ProductTypeDTO productType;

	public ProductDTO() {
		super();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getHyperlink() {
		return hyperlink;
	}

	public void setHyperlink(String hyperlink) {
		this.hyperlink = hyperlink;
	}

	public ProductTypeDTO getProductType() {
		return productType;
	}

	public void setProductType(ProductTypeDTO productType) {
		this.productType = productType;
	}

}
