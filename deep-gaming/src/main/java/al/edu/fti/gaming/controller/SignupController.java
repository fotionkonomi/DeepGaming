package al.edu.fti.gaming.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import al.edu.fti.gaming.dto.UserDTO;
import al.edu.fti.gaming.service.UserService;

@Controller
@RequestMapping("/signup")
public class SignupController {

	@Autowired
	private UserService userService;

	@RequestMapping
	public String signup(Model model) {
		UserDTO userDTO = new UserDTO();
		model.addAttribute("newUser", userDTO);
		return "signup";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processSingUp(@ModelAttribute("newUser") @Valid UserDTO userDTO, BindingResult result,
			HttpServletRequest request) throws ParseException {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			mav.setViewName("signup");
			return mav;
		}

		userService.add(userDTO);
		mav.setViewName("company/addCompany");
		return mav;
	}
}
