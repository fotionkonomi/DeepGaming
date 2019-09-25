package al.edu.fti.gaming.dao;

import al.edu.fti.gaming.models.ProductType;

public interface ProductTypeRepository {

	ProductType getCpuProductType();

	ProductType getGpuProductType();

	ProductType getGameProductType();

	ProductType getMotherboardProductType();
}
