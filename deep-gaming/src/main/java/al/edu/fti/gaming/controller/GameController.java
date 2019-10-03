package al.edu.fti.gaming.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import al.edu.fti.gaming.dto.CategoryOfGameDTO;
import al.edu.fti.gaming.dto.CpuDTO;
import al.edu.fti.gaming.dto.DirectXDTO;
import al.edu.fti.gaming.dto.EsrbRatingsDTO;
import al.edu.fti.gaming.dto.GameDTO;
import al.edu.fti.gaming.dto.GpuDTO;
import al.edu.fti.gaming.dto.MotherboardDTO;
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
			HttpServletRequest request) throws ParseException {
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
		gameService.preGameSave(gameDTO);
		gameService.add(gameDTO);
		generalService.imageProcessing(gameDTO, request.getSession().getServletContext().getRealPath("/"), true);
		mav.setViewName("redirect:/game/details?id=" + gameDTO.getId());
		return mav;
	}

	@RequestMapping("/details")
	public String details(@RequestParam("id") int gameId, Model model) {
		GameDTO gameDTO = gameService.getGameById(gameId);
		model.addAttribute("game", gameDTO);
		return "/game/details";
	}

	@RequestMapping("games")
	public String list(Model model, @RequestParam("page") int currentPage) {
		List<Integer> pageNumbers = new ArrayList<Integer>();
		int numberOfItemsOnThePage = 6;
		Long numberOfGames = gameService.countGamesInStock();
		for (int i = 1; i < numberOfGames; i++) {
			if (i % 3 == 0) {
				pageNumbers.add(i / 3);
			}
		}
		if (numberOfGames > pageNumbers.size() * numberOfItemsOnThePage) {
			pageNumbers.add(pageNumbers.size() + 1);
		}

		model.addAttribute("numberOfItemsOnThePage", numberOfItemsOnThePage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageNumbers", pageNumbers);
		model.addAttribute("count", numberOfGames);
		model.addAttribute("games", gameService.getAllGamesInStock(currentPage, numberOfItemsOnThePage));
		return "/game/games";
	}

	@RequestMapping("/update")
	public String update(@RequestParam("id") int gameId, Model model) {
		GameDTO gameDTO = gameService.getGameById(gameId);
		model.addAttribute("game", gameDTO);
		model.addAttribute("newGame", gameDTO);
		model.addAttribute("allCpus", cpuService.getAllCpusMap());
		model.addAttribute("allGpus", gpuService.getAllGpusMap());
		model.addAttribute("allCategories", categoryOfGameService.getAllCategoryOfGamesMap());
		model.addAttribute("allDirectXs", directXService.getDirectXsMap());
		model.addAttribute("allEsrbRatings", esrbRatingsService.getAllEsrbRatingsMap());
		return "game/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateGame(@ModelAttribute("game") @Valid GameDTO gameDTO, BindingResult result,
			HttpServletRequest request, @RequestParam("id") int id) throws ParseException {

		ModelAndView mav = new ModelAndView();
		List<ObjectError> listOfErrorsWithoutImageError = generalService.listOfErrorsWithoutImageError(
				result.getAllErrors(), gameDTO.getImage(), messages.get("al.edu.fti.gaming.validator.image"));
		if (!listOfErrorsWithoutImageError.isEmpty()) {
			mav.addObject("newGame", gameDTO);
			mav.addObject("allCpus", cpuService.getAllCpusMap());
			mav.addObject("allGpus", gpuService.getAllGpusMap());
			mav.addObject("allCategories", categoryOfGameService.getAllCategoryOfGamesMap());
			mav.addObject("allDirectXs", directXService.getDirectXsMap());
			mav.addObject("allEsrbRatings", esrbRatingsService.getAllEsrbRatingsMap());
			mav.setViewName("/game/update");
			return mav;
		} else {
			if (listOfErrorsWithoutImageError.size() == result.getAllErrors().size()) {
				generalService.imageProcessing(gameDTO,
						request.getSession().getServletContext().getRealPath("/"), false);
			}
			//meService
			return null;
		}
	}

}
