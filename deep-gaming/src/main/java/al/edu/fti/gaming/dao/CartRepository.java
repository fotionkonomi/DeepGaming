package al.edu.fti.gaming.dao;

import al.edu.fti.gaming.models.Cart;
import al.edu.fti.gaming.models.User;

public interface CartRepository {

	int addCart(Cart cart);
	
	Cart notReservedCartOfAUser(User user);
}
