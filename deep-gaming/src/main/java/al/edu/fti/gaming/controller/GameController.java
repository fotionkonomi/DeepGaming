package al.edu.fti.gaming.controller;

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

import al.edu.fti.gaming.dto.CategoryOfGameDTO;
import al.edu.fti.gaming.dto.CpuDTO;
import al.edu.fti.gaming.dto.DirectXDTO;
import al.edu.fti.gaming.dto.EsrbRatingsDTO;
import al.edu.fti.gaming.dto.GameDTO;
import al.edu.fti.gaming.dto.GpuDTO;
import al.edu.fti.gaming.service.CategoryOfGameService;
import al.edu.fti.gaming.service.CpuService;
import al.edu.fti.gaming.service.DirectXService;
import al.edu.fti.gaming.service.EsrbRatingsService;
import al.edu.fti.gaming.service.GameService;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.service.GpuService;
import al.edu.fti.gaming.utils.CategoryOfGamesEditor;
import al.edu.fti.gaming.utils.CpuEditor;
import al.edu.fti.gaming.utils.DirectXEditor;
import al.edu.fti.gaming.utils.EsrbRatingsEditor;
import al.edu.fti.gaming.utils.GpuEditor;
import al.edu.fti.gaming.utils.Messages;

@Controller
@RequestMapping("/game")
public class GameController {

	@Autowired
	private CpuService cpuService;

	@Autowired
	private GpuService gpuService;

	@Autowired
	private GameService gameService;

	@Autowired
	private CategoryOfGameService categoryOfGameService;

	@Autowired
	private Messages messages;

	@Autowired
	private GeneralService generalService;

	@Autowired
	private CpuEditor cpuEditor;

	@Autowired
	private GpuEditor gpuEditor;

	@Autowired
	private DirectXService directXService;

	@Autowired
	private DirectXEditor directXEditor;

	@Autowired
	private EsrbRatingsService esrbRatingsService;

	@Autowired
	private EsrbRatingsEditor esrbRatingsEditor;

	@Autowired
	private CategoryOfGamesEditor categoryOfGamesEditor;

	@InitBinder /* Converts empty strings into null when a form is submitted */
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.registerCustomEditor(CpuDTO.class, this.cpuEditor);
		binder.registerCustomEditor(GpuDTO.class, this.gpuEditor);
		binder.registerCustomEditor(DirectXDTO.class, this.directXEditor);
		binder.registerCustomEditor(EsrbRatingsDTO.class, this.esrbRatingsEditor);
		binder.registerCustomEditor(CategoryOfGameDTO.class, this.categoryOfGamesEditor);

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		GameDTO gameDTO = new GameDTO();
		model.addAttribute("newGame", gameDTO);
		model.addAttribute("allCpus", cpuService.getAllCpusMap());
		model.addAttribute("allGpus", gpuService.getAllGpusMap());
		model.addAttribute("allCategories", categoryOfGameService.getAllCategoryOfGamesMap());
		model.addAttribute("allDirectXs", directXService.getDirectXsMap());
		model.addAttribute("allEsrbRatings", esrbRatingsService.getAllEsrbRatingsMap());
		return "/game/addGame";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView processForm(@ModelAttribute("newGame") @Valid GameDTO gameDTO, BindingResult result,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			mav.addObject("newGame", gameDTO);
			mav.addObject("allCpus", cpuService.getAllCpusMap());
			mav.addObject("allGpus", gpuService.getAllGpusMap());
			mav.addObject("allCategories", categoryOfGameService.getAllCategoryOfGamesMap());
			mav.addObject("allDirectXs", directXService.getDirectXsMap());
			mav.addObject("allEsrbRatings", esrbRatingsService.getAllEsrbRatingsMap());
			mav.setViewName("/game/addGame");
			return mav;
		}
		return mav;
	}
}
