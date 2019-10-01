package al.edu.fti.gaming.service;

import al.edu.fti.gaming.dto.CartDTO;
import al.edu.fti.gaming.dto.UserDTO;

public interface CartService {

	boolean doesUserAlreadyHaveACart(UserDTO user);
	
	CartDTO add(UserDTO user);
	
	CartDTO notReservedCartOfAUser(UserDTO user);
}
