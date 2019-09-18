package al.edu.fti.gaming.controller;

import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import al.edu.fti.gaming.dto.CpuDTO;
import al.edu.fti.gaming.dto.GpuDTO;
import al.edu.fti.gaming.dto.UserDTO;
import al.edu.fti.gaming.service.GpuService;
import al.edu.fti.gaming.service.UserService;
import al.edu.fti.gaming.utils.CpuEditor;
import al.edu.fti.gaming.utils.GpuEditor;

@Controller
@RequestMapping("/signup")
public class SignupController {

	@Autowired
	private CpuEditor cpuEditor;

	@Autowired
	private GpuEditor gpuEditor;

	@Autowired
	private GpuService gpuService;

	@Autowired
	private UserService userService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.registerCustomEditor(CpuDTO.class, this.cpuEditor);
		binder.registerCustomEditor(GpuDTO.class, this.gpuEditor);

	}

	@RequestMapping
	public String signup(Model model) {
		UserDTO userDTO = new UserDTO();
		model.addAttribute("newUser", userDTO);
		model.addAttribute("cpus", gpuService.getAllCpusMap());
		model.addAttribute("gpus", gpuService.getAllGpusMap());
		return "signup";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processSignUp(@ModelAttribute("newUser") @Valid UserDTO userDTO, BindingResult result,
			HttpServletRequest request) throws ParseException {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			mav.setViewName("signup");
			mav.addObject("cpus", gpuService.getAllCpusMap());
			mav.addObject("gpus", gpuService.getAllGpusMap());
			return mav;
		}

		userService.add(userDTO);
		try {
			request.login(userDTO.getUsername(), userDTO.getPassword());
		} catch (ServletException e) {
			e.printStackTrace();
		}

		mav.setViewName("redirect:/cpu/cpus?page=1");
		return mav;
	}

}
