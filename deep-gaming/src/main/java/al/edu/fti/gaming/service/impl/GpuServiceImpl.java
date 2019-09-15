package al.edu.fti.gaming.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.GpuRepository;
import al.edu.fti.gaming.dto.CpuDTO;
import al.edu.fti.gaming.dto.DirectXDTO;
import al.edu.fti.gaming.dto.GpuArchitectureDTO;
import al.edu.fti.gaming.dto.GpuDTO;
import al.edu.fti.gaming.dto.GpuFamilyDTO;
import al.edu.fti.gaming.dto.GpuMemoryTechnologyDTO;
import al.edu.fti.gaming.dto.GpuSlotDTO;
import al.edu.fti.gaming.exception.GpuNotFoundException;
import al.edu.fti.gaming.exception.NoGpuFoundForGpuFamily;
import al.edu.fti.gaming.exception.ProductsNotFoundException;
import al.edu.fti.gaming.models.GPU;
import al.edu.fti.gaming.service.CpuService;
import al.edu.fti.gaming.service.DirectXService;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.service.GpuArchitectureService;
import al.edu.fti.gaming.service.GpuFamilyService;
import al.edu.fti.gaming.service.GpuMemoryTechnologyService;
import al.edu.fti.gaming.service.GpuService;
import al.edu.fti.gaming.service.GpuSlotService;

@Service
@Transactional
public class GpuServiceImpl implements GpuService {

	@Autowired
	private GpuRepository gpuRepository;

	@Autowired
	@Qualifier("gpuConverter")
	private Converter gpuConverter;

	@Autowired
	@Qualifier("gpuFamilyConverter")
	private Converter gpuFamilyConverter;

	@Autowired
	@Qualifier("gpuArchitectureConverter")
	private Converter gpuArchitectureConverter;

	@Autowired
	@Qualifier("gpuSlotConverter")
	private Converter gpuSlotConverter;

	@Autowired
	@Qualifier("gpuMemoryTechnologyConverter")
	private Converter gpuMemoryTechnologyConverter;

	@Autowired
	private GpuFamilyService gpuFamilyService;

	@Autowired
	private GpuArchitectureService gpuArchitectureService;

	@Autowired
	private GpuSlotService gpuSlotService;

	@Autowired
	private GeneralService generalService;

	@Autowired
	private GpuMemoryTechnologyService gpuMemoryTechnologyService;

	@Autowired
	private DirectXService directXService;

	@Autowired
	private CpuService cpuService;

	@Override
	public int add(GpuDTO gpuDTO) {
		GPU gpu = (GPU) gpuConverter.toModel(gpuDTO);
		int retVal = gpuRepository.add(gpu);
		if (retVal != 0) {
			gpuDTO.setId(retVal);
		}
		return retVal;
	}

	@Override
	public ModelAndView getModelWithRequestParameters(String queryString) {
		String gpuFamilyIdString = getGpuFamilyStringId(queryString);

		String gpuArchitectureIdString = getGpuArchitectureStringId(queryString);

		String company = getCompany(queryString);

		ModelAndView mav = new ModelAndView();
		mav.addObject("gpuFamily", gpuFamilyIdString);
		mav.addObject("gpuArchitecture", gpuArchitectureIdString);
		mav.addObject("company", company);

		return mav;
	}

	@Override
	public Integer getGpuArchitectureId(String queryString) {
		return Integer.parseInt(getGpuArchitectureStringId(queryString));
	}

	@Override
	public Integer getGpuFamilyId(String queryString) {
		return Integer.parseInt(getGpuFamilyStringId(queryString));
	}

	@Override
	public Integer getGpuSlotId(String queryString) {
		return Integer.parseInt(getGpuArchitectureStringId(queryString));
	}

	@Override
	public void preGpuSave(GpuDTO gpuDTO, String queryString) throws ParseException {
		generalService.convertStringToDate(gpuDTO);
		gpuDTO.setUploadDate(new Date());
		gpuDTO.setEditedDate(new Date());
		gpuDTO.setFamilyOfThisGpu(gpuFamilyService.getGpuFamilyById(getGpuFamilyId(queryString)));
		gpuDTO.setArchitectureOfThisGpu(
				gpuArchitectureService.getGpuArchitectureById(getGpuArchitectureId(queryString)));

	}

	@Override
	public GpuDTO getGpuById(int id) {
		GPU gpu = gpuRepository.getGpuById(id);
		if (gpu == null) {
			throw new GpuNotFoundException(id);
		} else {
			return (GpuDTO) gpuConverter.toDTO(gpu);
		}
	}

	@Override
	public List<GpuDTO> getAllGpusInStock(int page, int numberOfItemsOnThePage) {

		page--;
		List<GPU> gpuModels = gpuRepository.getAllGpusInStock(page, numberOfItemsOnThePage);
		if (gpuModels == null || gpuModels.isEmpty()) {
			throw new ProductsNotFoundException();
		}
		return convertList(gpuModels);
	}

	@Override
	public Long countOfGpusInStock() {
		return gpuRepository.countOfGpusInStock();
	}

	@Override
	public List<GpuDTO> getGpusByFamily(Integer gpuFamilyId) {
		List<GPU> gpuModels = gpuRepository.getGpuByGpuFamily(gpuFamilyId);
		if (gpuModels == null || gpuModels.isEmpty()) {
			throw new NoGpuFoundForGpuFamily();
		} else {
			return convertList(gpuModels);
		}
	}

	@Override
	public void update(GpuDTO gpuDTO, int id) throws ParseException {
		GPU gpu = gpuRepository.getGpuById(id);
		gpuDTO.setId(gpu.getIdProduct());
		generalService.convertStringToDate(gpuDTO);
		gpuDTO.setEditedDate(new Date());
		gpuDTO.setUploadDate(gpu.getUploadDate());
		gpuDTO.setFamilyOfThisGpu((GpuFamilyDTO) gpuFamilyConverter.toDTO(gpu.getFamilyOfThisGpu()));
		gpuDTO.setArchitectureOfThisGpu(
				(GpuArchitectureDTO) gpuArchitectureConverter.toDTO(gpu.getArchitectureOfThisGpu()));
		gpuDTO.setGpuSlotOfThisGpu((GpuSlotDTO) gpuSlotConverter.toDTO(gpu.getGpuSlotOfThisGpu()));
		gpuRepository.update((GPU) gpuConverter.toModel(gpuDTO));

	}

	@Override
	public Map<Integer, String> getAllMemoryTechnologiesMap() {
		List<GpuMemoryTechnologyDTO> allMemoryTechnologies = gpuMemoryTechnologyService.getAllGpuMemoryTechnologies();
		Map<Integer, String> allMemoryTechnologiesMap = new HashMap<Integer, String>();
		for (GpuMemoryTechnologyDTO gpuMemoryTechnologyDTO : allMemoryTechnologies) {
			allMemoryTechnologiesMap.put(gpuMemoryTechnologyDTO.getId(), gpuMemoryTechnologyDTO.getName());
		}
		return allMemoryTechnologiesMap;
	}

	@Override
	public Map<Integer, String> getDirectXsMap() {
		List<DirectXDTO> allDirectXs = directXService.getAllDirectXs();
		Map<Integer, String> allDirectXsMap = new HashMap<Integer, String>();
		for (DirectXDTO directXDTO : allDirectXs) {
			allDirectXsMap.put(directXDTO.getId(), directXDTO.getName());
		}
		return allDirectXsMap;
	}

	@Override
	public Map<Integer, String> getAllGpuSlotsMap() {
		List<GpuSlotDTO> allGpuSlots = gpuSlotService.getAllGpuSlots();
		Map<Integer, String> allGpuSlotsMap = new HashMap<Integer, String>();
		for (GpuSlotDTO gpuSlotDTO : allGpuSlots) {
			allGpuSlotsMap.put(gpuSlotDTO.getId(), gpuSlotDTO.getName());
		}
		return allGpuSlotsMap;
	}

	@Override
	public Map<Integer, String> getAllCpusMap() {
		List<CpuDTO> allCpus = cpuService.getAllCpus();
		Map<Integer, String> allCpusMap = new HashMap<Integer, String>();
		for (CpuDTO cpuDTO : allCpus) {
			allCpusMap.put(cpuDTO.getId(), cpuDTO.getFamilyOfThisCpu().getCompanyOfThisCpuFamily().getName() + " "
					+ cpuDTO.getFamilyOfThisCpu().getName() + " " + cpuDTO.getName());
		}
		return allCpusMap;
	}

	private String getGpuFamilyStringId(String query) {
		String queryString = query;
		int indexOfGpuFamily = queryString.indexOf("gpuFamily=");
		int endOfFamilyParameter = queryString.indexOf("&");

		String gpuFamilyIdString = queryString.substring(indexOfGpuFamily + 10, endOfFamilyParameter);
		return gpuFamilyIdString;
	}

	private String getGpuArchitectureStringId(String query) {
		String queryString = query;
		int endOfFamilyParameter = queryString.indexOf("&");
		queryString = queryString.substring(endOfFamilyParameter + 1);

		int indexOfGpuArchitecture = 0;
		int endOfGpuArchitectureParameter = queryString.indexOf("&");
		String gpuArchitectureIdString = queryString.substring(indexOfGpuArchitecture + 16,
				endOfGpuArchitectureParameter);
		return gpuArchitectureIdString;
	}

	private String getCompany(String query) {
		String queryString = query;
		for (int i = 0; i < 2; i++) {
			int index = queryString.indexOf("&");
			queryString = queryString.substring(index + 1);
		}

		int indexOfCompany = queryString.indexOf("company=");
		int endOfCompanyParameter = queryString.indexOf("&");
		if (endOfCompanyParameter == -1) {
			endOfCompanyParameter = queryString.length();
		}

		String company = queryString.substring(indexOfCompany + 8, endOfCompanyParameter);
		return company;
	}

	private List<GpuDTO> convertList(List<GPU> gpuModels) {
		List<GpuDTO> gpuDTOs = new ArrayList<GpuDTO>();
		for (GPU gpu : gpuModels) {
			GpuDTO gpuDTO = (GpuDTO) gpuConverter.toDTO(gpu);
			gpuDTOs.add(gpuDTO);
		}
		return gpuDTOs;
	}

}
