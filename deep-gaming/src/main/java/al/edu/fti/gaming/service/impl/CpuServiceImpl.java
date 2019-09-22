package al.edu.fti.gaming.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.CpuRepository;
import al.edu.fti.gaming.dto.CpuArchitectureDTO;
import al.edu.fti.gaming.dto.CpuDTO;
import al.edu.fti.gaming.dto.CpuFamilyDTO;
import al.edu.fti.gaming.dto.CpuSocketDTO;
import al.edu.fti.gaming.exception.CpuNotFoundException;
import al.edu.fti.gaming.exception.NoCpuFoundForCpuFamily;
import al.edu.fti.gaming.exception.ProductsNotFoundException;
import al.edu.fti.gaming.models.CPU;
import al.edu.fti.gaming.service.CpuArchitectureService;
import al.edu.fti.gaming.service.CpuFamilyService;
import al.edu.fti.gaming.service.CpuService;
import al.edu.fti.gaming.service.CpuSocketService;
import al.edu.fti.gaming.service.GeneralService;

@Service
@Transactional
public class CpuServiceImpl implements CpuService {

	@Autowired
	private CpuRepository cpuRepository;

	@Autowired
	@Qualifier("cpuConverter")
	private Converter cpuConverter;
	
	@Autowired
	@Qualifier("cpuFamilyConverter")
	private Converter cpuFamilyConverter;
	
	@Autowired
	@Qualifier("cpuArchitectureConverter")
	private Converter cpuArchitectureConverter;

	@Autowired
	@Qualifier("cpuSocketConverter")
	private Converter cpuSocketConverter;	
	
	@Autowired
	private CpuFamilyService cpuFamilyService;

	@Autowired
	private CpuArchitectureService cpuArchitectureService;

	@Autowired
	private CpuSocketService cpuSocketService;

	@Autowired
	private GeneralService generalService;

	@Override
	public int add(CpuDTO cpuDTO) {

		CPU cpu = (CPU) cpuConverter.toModel(cpuDTO);
		int retVal = cpuRepository.add(cpu);
		if (retVal != 0) {
			cpuDTO.setId(retVal);
		}
		return retVal;
	}

	@Override
	public ModelAndView getModelWithRequestParameters(String queryString) {

		String cpuFamilyIdString = getCpuFamilyStringId(queryString);

		String cpuArchitectureIdString = getCpuArchitectureStringId(queryString);

		String cpuSocketIdString = getCpuSocketStringId(queryString);

		String company = getCompany(queryString);


		ModelAndView mav = new ModelAndView();
		mav.addObject("cpuFamily", cpuFamilyIdString);
		mav.addObject("cpuArchitecture", cpuArchitectureIdString);
		mav.addObject("cpuSocket", cpuSocketIdString);
		mav.addObject("company", company);

		return mav;
	}
 
	private String getCpuFamilyStringId(String query) {
		String queryString = query;
		int indexOfCpuFamily = queryString.indexOf("cpuFamily=");
		int endOfFamilyParameter = queryString.indexOf("&");

		String cpuFamilyIdString = queryString.substring(indexOfCpuFamily + 10, endOfFamilyParameter);
		return cpuFamilyIdString;
	}

	private String getCpuArchitectureStringId(String query) {
		String queryString = query;
		int endOfArchitectureParameter = queryString.indexOf("&");
		queryString = queryString.substring(endOfArchitectureParameter + 1);

		int indexOfCpuArchitecture = 0;
		int endOfCpuArchitectureParameter = queryString.indexOf("&");
		String cpuArchitectureIdString = queryString.substring(indexOfCpuArchitecture + 16,
				endOfCpuArchitectureParameter);
		return cpuArchitectureIdString;
	}

	private String getCpuSocketStringId(String query) {
		String queryString = query;
		for (int i = 0; i < 2; i++) {
			int index = queryString.indexOf("&");
			queryString = queryString.substring(index + 1);
		}

		int indexOfCpuSocket = queryString.indexOf("cpuSocket=");
		int endOfSocketParameter = queryString.indexOf("&");

		String cpuSocketIdString = queryString.substring(indexOfCpuSocket + 10, endOfSocketParameter);

		return cpuSocketIdString;

	}

	private String getCompany(String query) {
		String queryString = query;
		for (int i = 0; i < 3; i++) {
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

	@Override
	public Integer getCpuFamilyId(String queryString) {
		return Integer.parseInt(getCpuFamilyStringId(queryString));
	}

	@Override
	public Integer getCpuArchitectureId(String queryString) {
		return Integer.parseInt(getCpuArchitectureStringId(queryString));
	}

	@Override
	public Integer getCpuSocketId(String queryString) {
		return Integer.parseInt(getCpuSocketStringId(queryString));
	}

	@Override
	public void preCpuSave(CpuDTO cpuDTO, String queryString) throws ParseException {
		generalService.convertStringToDate(cpuDTO);
		cpuDTO.setUploadDate(new Date());
		cpuDTO.setEditedDate(new Date());
		cpuDTO.setFamilyOfThisCpu(cpuFamilyService.getCpuFamilyById(getCpuFamilyId(queryString)));
		cpuDTO.setArchitectureOfThisCpu(
				cpuArchitectureService.getCpuArchitectureById(getCpuArchitectureId(queryString)));
		cpuDTO.setSocketOfThisCpu(cpuSocketService.getCpuSocketById(getCpuSocketId(queryString)));

	}

	@Override
	public CpuDTO getCpuById(int id) {
		CPU cpu = cpuRepository.getCpuById(id);
		if (cpu == null) {
			throw new CpuNotFoundException(id);
		} else {
			return (CpuDTO) cpuConverter.toDTO(cpu);
		}
	}

	@Override
	public List<CpuDTO> getAllCpusInStock(int page, int numberOfItemsOnThePage) {
		page--;
		List<CPU> cpuModels = cpuRepository.getAllCpusInStock(page, numberOfItemsOnThePage);
		if (cpuModels == null || cpuModels.isEmpty()) {
			throw new ProductsNotFoundException();
		}
		return convertList(cpuModels);
	}

	private List<CpuDTO> convertList(List<CPU> cpuModels) {
		List<CpuDTO> cpuDTOs = new ArrayList<CpuDTO>();
		for (CPU cpu : cpuModels) {
			CpuDTO cpuDTO = (CpuDTO) cpuConverter.toDTO(cpu);
			cpuDTOs.add(cpuDTO);
		}
		return cpuDTOs;

	}

	@Override
	public Long countOfCpusInStock() {
		return cpuRepository.countOfCpusInStock();
	}

	@Override
	public List<CpuDTO> getCpusByCpuFamily(Integer cpuFamilyId) {
		List<CPU> cpuModels = cpuRepository.getCpusByCpuFamily(cpuFamilyId);
		if (cpuModels == null || cpuModels.isEmpty()) {
			throw new NoCpuFoundForCpuFamily();
		}
		return convertList(cpuModels);
	}

	@Override
	public void update(CpuDTO cpuDTO, int id) throws ParseException {
		CPU cpu = cpuRepository.getCpuById(id);
		cpuDTO.setId(cpu.getIdProduct());
		generalService.convertStringToDate(cpuDTO);
		cpuDTO.setEditedDate(new Date());
		cpuDTO.setUploadDate(cpu.getUploadDate());
		cpuDTO.setFamilyOfThisCpu((CpuFamilyDTO) cpuFamilyConverter.toDTO(cpu.getFamilyOfThisCpu()));
		cpuDTO.setArchitectureOfThisCpu((CpuArchitectureDTO) cpuArchitectureConverter.toDTO(cpu.getArchitectureOfThisCpu()));
		cpuDTO.setSocketOfThisCpu((CpuSocketDTO) cpuSocketConverter.toDTO(cpu.getSocketForThisCpu()));
		cpuRepository.update((CPU) cpuConverter.toModel(cpuDTO));
	}
	
	@Override
	public List<CpuDTO> getAllCpus() {
		return convertList(cpuRepository.getAllCpus());
	}

}
