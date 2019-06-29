package al.edu.fti.gaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Controlleri {

	@RequestMapping("/index")
	public String index(Model model) {
		return "index";
	}

	@RequestMapping("/home")
	public String welcome(Model model) {
		return "home";
	}

}
