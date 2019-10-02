package al.edu.fti.gaming.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.ProductRepository;
import al.edu.fti.gaming.dto.ProductDTO;
import al.edu.fti.gaming.models.Product;
import al.edu.fti.gaming.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	@Qualifier("productConverter")
	private Converter productConverter;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductDTO getProductById(int id) {
		Product product = productRepository.getProductById(id);
		return (ProductDTO) productConverter.toDTO(product);
	}
}
