package al.edu.fti.gaming.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product_type")
public class ProductType implements Serializable, IModel {

	private static final long serialVersionUID = 6924536102790088327L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product_type")
	private Integer idProductType;

	@Column(name = "product_type", length = 30)
	private String productType;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "product_productType", joinColumns = {
			@JoinColumn(name = "id_product_type") }, inverseJoinColumns = { @JoinColumn(name = "id_product") })
	private Set<Product> products = new HashSet<Product>();

	public Integer getIdProductType() {
		return idProductType;
	}

	public void setIdProductType(Integer idProductType) {
		this.idProductType = idProductType;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProductType == null) ? 0 : idProductType.hashCode());
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
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
		ProductType other = (ProductType) obj;
		if (idProductType == null) {
			if (other.idProductType != null)
				return false;
		} else if (!idProductType.equals(other.idProductType))
			return false;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductType [idProductType=" + idProductType + ", productType=" + productType + ", products=" + products
				+ "]";
	}

}
