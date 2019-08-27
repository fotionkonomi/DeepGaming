package al.edu.fti.gaming.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import al.edu.fti.gaming.dto.CompanyDTO;

public interface CompanyService {

	int add(CompanyDTO companyDTO);
	
	List<CompanyDTO> getAllCompanies();
	
	CompanyDTO getCompanyById(int id);
	
	boolean update(CompanyDTO companyDTO);
	
	List<CompanyDTO> getAllCompaniesThatHaveCpuSockets();
	
	List<CompanyDTO> getAllCompaniesThatHaveChipsets();
	
	List<CompanyDTO> getAllCompaniesThatHaveCpuArchitectures();
	
	List<CompanyDTO> getAllCompaniesThatHaveCpuFamilies();
	
	List<CompanyDTO> getAllCompaniesThatHaveGpuArchitectures();
	
	List<CompanyDTO> getAllCompaniesThatHaveGpuFamilies();

	List<CompanyDTO> getAllCompaniesThatHaveOS();
}
