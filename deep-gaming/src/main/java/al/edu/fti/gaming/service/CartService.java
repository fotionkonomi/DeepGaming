package al.edu.fti.gaming.service;

import java.util.List;

import al.edu.fti.gaming.dto.CartDTO;
import al.edu.fti.gaming.dto.CartItemDTO;
import al.edu.fti.gaming.dto.ProductDTO;
import al.edu.fti.gaming.dto.UserDTO;

public interface CartService {

	boolean doesUserAlreadyHaveACart(UserDTO user);

	CartDTO add(UserDTO user);

	CartDTO notReservedCartOfAUser(UserDTO user);

	List<CartItemDTO> cartItemsOfACart(CartDTO cartDTO);

	CartItemDTO doesProductExistInPreviousCartItems(ProductDTO productDTO, CartDTO cartDTO);

	void addCartItem(CartItemDTO cartItemDTO);

	CartItemDTO getCartItemById(int id);

	void deleteCartItem(CartItemDTO cartItem);

	void deleteAllCartItemsForACart(CartDTO cartDTO);

	void reserve(CartDTO cartDTO);

	List<CartDTO> getAllReservations();

	void confirmPurchase(CartDTO cartDTO);

	CartDTO getCartById(int id);
}
