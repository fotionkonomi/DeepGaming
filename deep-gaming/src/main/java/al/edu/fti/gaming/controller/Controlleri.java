package al.edu.fti.gaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import al.edu.fti.gaming.dao.Repository;
import al.edu.fti.gaming.dto.EsrbRatingsDTO;
import al.edu.fti.gaming.models.CpuSocket;
import al.edu.fti.gaming.models.EsrbRatings;

@Controller
@RequestMapping("/")
public class Controlleri {

	@Autowired
	private Repository repo;
	
	@RequestMapping("/home")
	public String welcome(Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddSocketForm(Model model) {
		EsrbRatings newEsrb = new EsrbRatings();
		model.addAttribute("newEsrb", newEsrb);
		return "test";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("newEsrb")EsrbRatings newEsrb) {
		System.out.println("Emri: "+ newEsrb.getEsrbRatingName());
		System.out.println("Descriptioni: " + newEsrb.getEsrbRatingDescription());
		repo.add(newEsrb);
		return "redirect:/home";
	}
}
