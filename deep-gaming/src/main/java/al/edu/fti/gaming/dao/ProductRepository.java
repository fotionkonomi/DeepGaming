package al.edu.fti.gaming.dao;

import al.edu.fti.gaming.models.Product;

public interface ProductRepository {

	Product getProductById(int id);
	
	void updateProduct(Product product);
}
