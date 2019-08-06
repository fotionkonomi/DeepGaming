package al.edu.fti.gaming.service;

import java.util.List;

import al.edu.fti.gaming.dto.CompanyDTO;

public interface CompanyService {

	boolean add(CompanyDTO companyDTO);
	
	List<CompanyDTO> getAllCompanies();
	
	CompanyDTO getCompanyById(int id);
	
	boolean update(CompanyDTO companyDTO);
}
