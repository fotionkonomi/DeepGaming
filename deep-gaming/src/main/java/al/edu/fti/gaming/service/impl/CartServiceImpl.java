package al.edu.fti.gaming.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.CartRepository;
import al.edu.fti.gaming.dto.CartDTO;
import al.edu.fti.gaming.dto.UserDTO;
import al.edu.fti.gaming.models.Cart;
import al.edu.fti.gaming.models.User;
import al.edu.fti.gaming.service.CartService;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	@Qualifier("userConverter")
	private Converter userConverter;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	@Qualifier("cartConverter")
	private Converter cartConverter;

	@Override
	public boolean doesUserAlreadyHaveACart(UserDTO user) {
		return cartRepository.notReservedCartOfAUser((User) userConverter.toModel(user)) != null ? true : false;
	}
	
	@Override
	public CartDTO notReservedCartOfAUser(UserDTO user) {
		return (CartDTO) cartConverter.toDTO(cartRepository.notReservedCartOfAUser((User) userConverter.toModel(user)));
	}

	@Override
	public CartDTO add(UserDTO user) {
		CartDTO cartDTO = new CartDTO();
		cartDTO.setReserved(0);
		cartDTO.setUser(user);
		cartRepository.addCart((Cart) cartConverter.toModel(cartDTO));
		return cartDTO;
	}
}
