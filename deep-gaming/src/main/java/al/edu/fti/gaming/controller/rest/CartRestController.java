package al.edu.fti.gaming.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import al.edu.fti.gaming.dto.CartDTO;
import al.edu.fti.gaming.dto.CartItemDTO;
import al.edu.fti.gaming.dto.ProductDTO;
import al.edu.fti.gaming.dto.UserDTO;
import al.edu.fti.gaming.service.CartService;
import al.edu.fti.gaming.service.ProductService;
import al.edu.fti.gaming.service.UserService;

@RestController
@RequestMapping("/cart-rest")
public class CartRestController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping(value = "/addItem/{productId}")
	public void addCartItem(@PathVariable("productId") Integer productId) {
		UserDetails userLoggedIn = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDTO user = userService.findUserByUsername(userLoggedIn.getUsername());
		CartDTO cartDTO;
		if(cartService.doesUserAlreadyHaveACart(user) == false) {
			cartDTO = cartService.add(user);
		} else {
			cartDTO = cartService.notReservedCartOfAUser(user);
		}
		ProductDTO productDTO = productService.getProductById(productId);
		CartItemDTO cartItemDTO = cartService.doesProductExistInPreviousCartItems(productDTO, cartDTO);
		if(cartItemDTO != null) {
			cartItemDTO.setQuantity(cartItemDTO.getQuantity() + 1);
		} else {
			cartItemDTO = new CartItemDTO();
			cartItemDTO.setProduct(productDTO);
			cartItemDTO.setQuantity(1);
			cartItemDTO.setIdCart(cartDTO);
		}
		cartService.addCartItem(cartItemDTO);
	}
	
	@DeleteMapping(value = "/deleteItem/{cartItemId}")
	public void deleteCartItem(@PathVariable("cartItemId") Integer idCartItem) {
		CartItemDTO cartItemDTO = cartService.getCartItemById(idCartItem);
		cartService.deleteCartItem(cartItemDTO);
	}
	
	@DeleteMapping(value = "/deleteCart")
	public void deleteAllCartItems() {
		UserDetails userLoggedIn = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDTO user = userService.findUserByUsername(userLoggedIn.getUsername());
		CartDTO cartDTO = cartService.notReservedCartOfAUser(user);
		cartService.deleteAllCartItemsForACart(cartDTO);
	}
	
	@PutMapping(value = "/reserve")
	public void reserve() {
		UserDetails userLoggedIn = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDTO user = userService.findUserByUsername(userLoggedIn.getUsername());
		CartDTO cartDTO = cartService.notReservedCartOfAUser(user);
		cartService.reserve(cartDTO);
	}
	
	@PutMapping(value = "/confirmPurchase/{cartId}")
	public void confirmPurchase(@PathVariable("cartId") Integer id) {
//		CartDTO cartDTO = cartService.
//		cartService.confirmPurchase(cartDTO);
	}
}
