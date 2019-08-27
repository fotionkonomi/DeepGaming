package al.edu.fti.gaming.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.CompanyRepository;
import al.edu.fti.gaming.dto.CompanyDTO;
import al.edu.fti.gaming.exception.CompanyNotFoundException;
import al.edu.fti.gaming.models.Company;
import al.edu.fti.gaming.service.CompanyService;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

	private static final Logger LOGGER = Logger.getLogger(CompanyService.class.getName());

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	@Qualifier("companyConverter")
	private Converter companyConverter;

	@Override
	public int add(CompanyDTO companyDTO) {
		Company company = (Company) companyConverter.toModel(companyDTO);
		int retVal = this.companyRepository.add(company);
		if (retVal != 0) {
			companyDTO.setId(retVal);
		}
		return retVal;
	}

	public CompanyRepository getCompanyRepository() {
		return companyRepository;
	}

	public void setCompanyRepository(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	public Converter getCompanyConverter() {
		return companyConverter;
	}

	public void setCompanyConverter(Converter companyConverter) {
		this.companyConverter = companyConverter;
	}

	@Override
	public List<CompanyDTO> getAllCompanies() {
		List<Company> companyModels = companyRepository.getAllCompanies();
		return convertList(companyModels);
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	@Override
	public CompanyDTO getCompanyById(int id) {
		Company company = companyRepository.getCompanyById(id);
		if (company == null) {
			throw new CompanyNotFoundException(id);
		} else {
			return (CompanyDTO) companyConverter.toDTO(company);
		}
	}

	@Override
	public boolean update(CompanyDTO companyDTO) {
		return this.companyRepository.update((Company) companyConverter.toModel(companyDTO));
	}

	@Override
	public List<CompanyDTO> getAllCompaniesThatHaveCpuSockets() {
		List<Company> companyModels = companyRepository.getAllCompaniesThatHaveCpuSockets();
		return convertList(companyModels);
	}

	@Override
	public List<CompanyDTO> getAllCompaniesThatHaveChipsets() {
		List<Company> companyModels = companyRepository.getAllCompaniesThatHaveChipsets();
		return convertList(companyModels);
	}

	@Override
	public List<CompanyDTO> getAllCompaniesThatHaveCpuArchitectures() {
		List<Company> companyModels = companyRepository.getAllCompaniesThatHaveCpuArchitectures();
		return convertList(companyModels);
	}
	
	@Override
	public List<CompanyDTO> getAllCompaniesThatHaveCpuFamilies() {
		List<Company> companyModels = companyRepository.getAllCompaniesThatHaveCpuFamilies();
		return convertList(companyModels);
	}
	
	@Override
	public List<CompanyDTO> getAllCompaniesThatHaveGpuArchitectures() {
		List<Company> companyModels = companyRepository.getAllCompaniesThatHaveGpuArchitectures();
		return convertList(companyModels);
	}

	@Override
	public List<CompanyDTO> getAllCompaniesThatHaveGpuFamilies() {
		List<Company> companyModels = companyRepository.getAllCompaniesThatHaveGpuFamilies();
		return convertList(companyModels);
	}

	@Override
	public List<CompanyDTO> getAllCompaniesThatHaveOS() {
		List<Company> companyModels = companyRepository.getAllCompaniesThatHaveOS();
		return convertList(companyModels);
	}
	
	private List<CompanyDTO> convertList(List<Company> companyModels) {
		LOGGER.log(Level.INFO, "Getting all the company models by calling the repository");
		List<CompanyDTO> companyDTOs = new ArrayList<CompanyDTO>();
		for (Company company : companyModels) {
			CompanyDTO companyDTO = (CompanyDTO) companyConverter.toDTO(company);
			if (companyDTO != null) {
				LOGGER.log(Level.INFO, companyDTO.getName() + " was converted and added to the list");
				companyDTOs.add(companyDTO);
			} else {
				LOGGER.log(Level.SEVERE, "One object couldn't be converted, process aborted!");
				return null;
			}
		}
		LOGGER.log(Level.INFO, "Process was finished successfully!");
		return companyDTOs;
	}

	




}
