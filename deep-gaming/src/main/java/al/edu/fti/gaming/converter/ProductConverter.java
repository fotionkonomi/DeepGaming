package al.edu.fti.gaming.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.controller.ProductTypeConverter;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.dto.ProductDTO;
import al.edu.fti.gaming.dto.ProductTypeDTO;
import al.edu.fti.gaming.models.IModel;
import al.edu.fti.gaming.models.Product;
import al.edu.fti.gaming.models.ProductType;

@Component
public class ProductConverter implements Converter {

	@Autowired
	@Qualifier("productTypeConverter")
	private ProductTypeConverter productTypeConverter;

	@Override
	public IModel toModel(IDto dtoObject) {
		Product product = new Product();
		ProductDTO productDTO = (ProductDTO) dtoObject;
		if (productDTO.getId() != null) {
			product.setIdProduct(productDTO.getId());
		}
		product.setProductName(productDTO.getName());
		product.setProductDescription(productDTO.getDescription());
		product.setReleaseDate(productDTO.getReleaseDate());
		product.setPrice(productDTO.getPrice());
		product.setQuantity(productDTO.getQuantity());
		product.setUploadDate(productDTO.getUploadDate());
		product.setEditedDate(productDTO.getEditedDate());
		product.setHyperlink(productDTO.getHyperlink());
		product.setProductType((ProductType) productTypeConverter.toModel(productDTO.getProductType()));
		return product;
	}

	@Override
	public IDto toDTO(IModel modelObject) {
		ProductDTO productDTO = new ProductDTO();
		Product product = (Product) modelObject;
		productDTO.setId(product.getIdProduct());
		productDTO.setName(product.getProductName());
		productDTO.setDescription(product.getProductDescription());
		productDTO.setReleaseDate(product.getReleaseDate());
		productDTO.setPrice(product.getPrice());
		productDTO.setQuantity(product.getQuantity());
		productDTO.setUploadDate(product.getUploadDate());
		productDTO.setEditedDate(product.getEditedDate());
		productDTO.setHyperlink(product.getHyperlink());
		productDTO.setProductType((ProductTypeDTO) productTypeConverter.toDTO(product.getProductType()));
		return productDTO;
	}

}
