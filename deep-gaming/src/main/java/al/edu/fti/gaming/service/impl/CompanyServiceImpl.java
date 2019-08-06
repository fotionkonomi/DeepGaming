package al.edu.fti.gaming.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
	private Converter companyConverter;

	@Override
	public boolean add(CompanyDTO companyDTO) {
		return this.companyRepository.add((Company) companyConverter.toModel(companyDTO));
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
		LOGGER.log(Level.INFO, "Getting all the company models by calling the repository");
		List<Company> companyModels = companyRepository.getAllCompanies();
		List<CompanyDTO> companyDTOs = new ArrayList<CompanyDTO>();
		for (Company company : companyModels) {
			CompanyDTO companyDTO = (CompanyDTO) companyConverter.toDTO(company);
			if (companyDTO != null) {
				companyDTOs.add(companyDTO);
				LOGGER.log(Level.INFO, companyDTO.getName() + " was converted and added to the list");
			} else {
				LOGGER.log(Level.SEVERE, "One object couldn't be converted, process aborted!");
				return null;
			}
		}
		LOGGER.log(Level.INFO, "Process was finished successfully!");
		return companyDTOs;
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

}
