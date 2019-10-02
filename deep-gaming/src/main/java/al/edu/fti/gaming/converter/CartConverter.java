package al.edu.fti.gaming.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.CartDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.dto.UserDTO;
import al.edu.fti.gaming.models.Cart;
import al.edu.fti.gaming.models.IModel;
import al.edu.fti.gaming.models.User;
import al.edu.fti.gaming.service.CartService;

@Component
public class CartConverter implements Converter {

	@Autowired
	@Qualifier("userConverter")
	private UserConverter userConverter;
	
	@Autowired
	private CartService cartService;

	@Override
	public IModel toModel(IDto dtoObject) {
		Cart cart = new Cart();
		CartDTO cartDTO = (CartDTO) dtoObject;
		if (cartDTO.getId() != null) {
			cart.setIdCart(cartDTO.getId());
		}
		cart.setReserved(cartDTO.getReserved());
		cart.setUser((User) userConverter.toModel(cartDTO.getUser()));
		return cart;
	}

	@Override
	public IDto toDTO(IModel modelObject) {
		Cart cart = (Cart) modelObject;
		CartDTO cartDTO = new CartDTO();
		cartDTO.setId(cart.getIdCart());
		cartDTO.setReserved(cart.getReserved());
		cartDTO.setUser((UserDTO) userConverter.toDTO(cart.getUser()));
//		cartDTO.setCartItemDTOs(cartService.cartItemsOfACart(cartDTO));
		return cartDTO;
	}

}
