package al.edu.fti.gaming.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import al.edu.fti.gaming.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/secretary")
public class SecretaryController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping("/allReservations")
	public String allReservations(Model model) {
		model.addAttribute("reservations", cartService.getAllReservations());
		return "/secretary/allReservations";
	}
}
