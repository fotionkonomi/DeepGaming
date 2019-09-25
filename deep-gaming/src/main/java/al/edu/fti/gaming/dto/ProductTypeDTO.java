package al.edu.fti.gaming.dto;

public class ProductTypeDTO implements IDto {

	private Integer idProductType;

	private String productType;

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

}
