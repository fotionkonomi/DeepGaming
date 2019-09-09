package al.edu.fti.gaming.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import al.edu.fti.gaming.dto.CpuDTO;
import al.edu.fti.gaming.dto.ProductDTO;

@Component
public class ProductPriceQuantityValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CpuDTO.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		ProductDTO product = (ProductDTO) target;
		
		Integer price = product.getPrice();
		Integer quantity = product.getQuantity();

		if ((price == null && quantity != null) || (price != null && quantity == null)) {
			errors.rejectValue("price", "errors.rejectValue.validator.price_quantity.message");
			errors.rejectValue("quantity", "errors.rejectValue.validator.price_quantity.message");
		}

	}

}
