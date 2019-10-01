package al.edu.fti.gaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import al.edu.fti.gaming.dto.CartDTO;
import al.edu.fti.gaming.dto.UserDTO;
import al.edu.fti.gaming.service.CartService;
import al.edu.fti.gaming.service.UserService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/details")
	public String details(Model model) {
		CartDTO cartDTO;
		UserDetails userLoggedIn = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDTO user = userService.findUserByUsername(userLoggedIn.getUsername());
		if(cartService.doesUserAlreadyHaveACart(user) == false) {
			cartDTO = cartService.add(user);
		} else {
			cartDTO = cartService.notReservedCartOfAUser(user);
		}
		model.addAttribute("cart", cartDTO);
		return "/cart/details";
	}
}
