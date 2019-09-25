package al.edu.fti.gaming.controller;

import org.springframework.stereotype.Component;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.dto.ProductTypeDTO;
import al.edu.fti.gaming.models.IModel;
import al.edu.fti.gaming.models.ProductType;

@Component
public class ProductTypeConverter implements Converter {

	@Override
	public IDto toDTO(IModel modelObject) {
		ProductTypeDTO productTypeDTO = new ProductTypeDTO();
		ProductType productType = (ProductType) modelObject;
		productTypeDTO.setIdProductType(productType.getIdProductType());
		productTypeDTO.setProductType(productType.getProductType());
		return productTypeDTO;
	}

	@Override
	public IModel toModel(IDto dtoObject) {
		ProductType productType = new ProductType();
		ProductTypeDTO productTypeDTO = (ProductTypeDTO) dtoObject;
		if (productTypeDTO.getIdProductType() != null) {
			productType.setIdProductType(productTypeDTO.getIdProductType());
		}
		productType.setProductType(productTypeDTO.getProductType());
		return productType;

	}
}
