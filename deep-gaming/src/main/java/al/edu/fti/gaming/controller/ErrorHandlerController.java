package al.edu.fti.gaming.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorHandlerController {

	@GetMapping("/error")
	public String errors(Model model, HttpServletResponse response) {
		switch (response.getStatus()) {
		case 404:
			model.addAttribute("errorCode", 404);
			model.addAttribute("errorMessage", "notFound");
			break;

		case 403:
			model.addAttribute("errorCode", 403);
			model.addAttribute("errorMessage", "notAuthorized");

			break;

		default:
			
		}

		return "clientErrors";

	}

}
