package al.edu.fti.gaming.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.CartRepository;
import al.edu.fti.gaming.dao.ProductRepository;
import al.edu.fti.gaming.dto.CartDTO;
import al.edu.fti.gaming.dto.CartItemDTO;
import al.edu.fti.gaming.dto.ProductDTO;
import al.edu.fti.gaming.dto.UserDTO;
import al.edu.fti.gaming.models.Cart;
import al.edu.fti.gaming.models.CartItem;
import al.edu.fti.gaming.models.Product;
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

	@Autowired
	@Qualifier("cartItemConverter")
	private Converter cartItemConverter;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	@Qualifier("productConverter")
	private Converter productConverter;

	@Override
	public boolean doesUserAlreadyHaveACart(UserDTO user) {
		return cartRepository.notReservedCartOfAUser((User) userConverter.toModel(user)) != null ? true : false;
	}

	@Override
	public CartDTO notReservedCartOfAUser(UserDTO user) {
		CartDTO cartToBeReturned = (CartDTO) cartConverter
				.toDTO(cartRepository.notReservedCartOfAUser((User) userConverter.toModel(user)));
		cartToBeReturned.setCartItemDTOs(cartItemsOfACart(cartToBeReturned));
		return cartToBeReturned;
	}

	@Override
	public CartDTO add(UserDTO user) {
		CartDTO cartDTO = new CartDTO();
		cartDTO.setReserved(0);
		cartDTO.setUser(user);
		cartDTO.setId(cartRepository.addCart((Cart) cartConverter.toModel(cartDTO)));
		return cartDTO;
	}

	@Override
	public List<CartItemDTO> cartItemsOfACart(CartDTO cartDTO) {
		List<CartItem> cartItems = cartRepository.cartItemsOfACart((Cart) cartConverter.toModel(cartDTO));
		List<CartItemDTO> cartItemDTOs = new ArrayList<CartItemDTO>();
		for (CartItem cartItem : cartItems) {
			cartItemDTOs.add((CartItemDTO) cartItemConverter.toDTO(cartItem));
		}
		return cartItemDTOs;
	}

	@Override
	public CartItemDTO doesProductExistInPreviousCartItems(ProductDTO productDTO, CartDTO cartDTO) {
		if (cartDTO.getCartItemDTOs() != null) {
			for (CartItemDTO cartItemIterable : cartDTO.getCartItemDTOs()) {
				if (productDTO.getId() == cartItemIterable.getProduct().getId()) {
					return cartItemIterable;
				}
			}
		}
		return null;

	}

	@Override
	public void addCartItem(CartItemDTO cartItemDTO) {
		ProductDTO productDTO = cartItemDTO.getProduct();
		productDTO.setQuantity(productDTO.getQuantity() - 1);
		productRepository.updateProduct((Product) productConverter.toModel(productDTO));
		cartRepository.addCartItem((CartItem) cartItemConverter.toModel(cartItemDTO));
	}

	@Override
	public CartItemDTO getCartItemById(int id) {
		return (CartItemDTO) cartItemConverter.toDTO(cartRepository.getCartItemById(id));
	}

	@Override
	public void deleteCartItem(CartItemDTO cartItem) {
		ProductDTO productDTO = cartItem.getProduct();
		productDTO.setQuantity(productDTO.getQuantity() - 1);
		productRepository.updateProduct((Product) productConverter.toModel(productDTO));
		cartRepository.deleteCartItem((CartItem) cartItemConverter.toModel(cartItem));
	}

	@Override
	public void deleteAllCartItemsForACart(CartDTO cartDTO) {
		for (CartItemDTO cartItemDTO : cartDTO.getCartItemDTOs()) {
			deleteCartItem(cartItemDTO);
		}
	}

	@Override
	public void reserve(CartDTO cartDTO) {
		cartDTO.setReserved(1);
		cartRepository.updateCart((Cart) cartConverter.toModel(cartDTO));
	}

	@Override
	public List<CartDTO> getAllReservations() {
		List<Cart> reservationModels = cartRepository.getAllReservations();
		List<CartDTO> reservationDTOs = new ArrayList<CartDTO>();
		for (Cart cart : reservationModels) {
			CartDTO cartDTO = (CartDTO) cartConverter.toDTO(cart);
			cartDTO.setCartItemDTOs(cartItemsOfACart(cartDTO));
			reservationDTOs.add(cartDTO);
		}
		return reservationDTOs;
	}

	@Override
	public void confirmPurchase(CartDTO cartDTO) {
		cartDTO.setReserved(2);
		cartRepository.updateCart((Cart) cartConverter.toModel(cartDTO));
	}

	@Override
	public CartDTO getCartById(int id) {
		CartDTO cartDTO = (CartDTO) cartConverter.toDTO(cartRepository.getCartById(id));
		cartDTO.setCartItemDTOs(cartItemsOfACart(cartDTO));
		return cartDTO;
	}
}
