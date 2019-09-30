package al.edu.fti.gaming.converter;

import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.CartItemDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.models.CartItem;
import al.edu.fti.gaming.models.IModel;

@Component
public class CartItemConverter implements Converter {
	
	
	
	@Override
	public IModel toModel(IDto dtoObject) {
		CartItem cartItem = new CartItem();
		CartItemDTO cartItemDTO = (CartItemDTO) dtoObject;
		if(cartItemDTO.getId() != null) {
			cartItem.setId(cartItemDTO.getId());
		}
		return cartItem;
		
	}

	@Override
	public IDto toDTO(IModel modelObject) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
