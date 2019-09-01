package al.edu.fti.gaming.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "product")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product implements Serializable, IModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6552784889750349072L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product")
	private Integer idProduct;

	@Column(name = "product_name", nullable = false, length = 100)
	private String productName;

	@Column(name = "product_description", nullable = false, length = 65535)
	private String productDescription;

	@Column(name = "release_date", nullable = false, columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date releaseDate;

	@Column(name = "price")
	private Integer price;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "upload_date", nullable = false, columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date uploadDate;

	@Column(name = "edited_date", nullable = false, columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date editedDate;

//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
//	@JoinColumn(name = "suggested_by")
//	private User suggestedBy;
//
//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
//	@JoinColumn(name = "approved_by")
//	private User approvedBy;

	@Column(name = "hyperlink", nullable = false, length = 255)
	private String hyperlink;

	@ManyToMany(mappedBy = "products")
	private Set<ProductType> productTypes = new HashSet<ProductType>();

	public Product() {
		super();
	}

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
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

	public Set<ProductType> getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(Set<ProductType> productTypes) {
		this.productTypes = productTypes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((editedDate == null) ? 0 : editedDate.hashCode());
		result = prime * result + ((hyperlink == null) ? 0 : hyperlink.hashCode());
		result = prime * result + ((idProduct == null) ? 0 : idProduct.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((productDescription == null) ? 0 : productDescription.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((productTypes == null) ? 0 : productTypes.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + ((uploadDate == null) ? 0 : uploadDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
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
		if (idProduct == null) {
			if (other.idProduct != null)
				return false;
		} else if (!idProduct.equals(other.idProduct))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (productDescription == null) {
			if (other.productDescription != null)
				return false;
		} else if (!productDescription.equals(other.productDescription))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productTypes == null) {
			if (other.productTypes != null)
				return false;
		} else if (!productTypes.equals(other.productTypes))
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
		if (uploadDate == null) {
			if (other.uploadDate != null)
				return false;
		} else if (!uploadDate.equals(other.uploadDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", productName=" + productName + ", productDescription="
				+ productDescription + ", releaseDate=" + releaseDate + ", price=" + price + ", quantity=" + quantity
				+ ", uploadDate=" + uploadDate + ", editedDate=" + editedDate + ", hyperlink=" + hyperlink
				+ ", productTypes=" + productTypes + "]";
	}

}
