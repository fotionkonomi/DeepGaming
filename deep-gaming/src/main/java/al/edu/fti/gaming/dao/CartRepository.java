package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.Cart;
import al.edu.fti.gaming.models.CartItem;
import al.edu.fti.gaming.models.User;

public interface CartRepository {

	int addCart(Cart cart);

	Cart notReservedCartOfAUser(User user);

	List<CartItem> cartItemsOfACart(Cart cart);

	void addCartItem(CartItem cartItem);

	CartItem getCartItemById(int id);

	void deleteCartItem(CartItem cartItem);

	void updateCart(Cart cart);
	
	List<Cart> getAllReservations();
 
	
}
