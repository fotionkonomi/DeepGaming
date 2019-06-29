package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.Company;

public interface CompanyRepository {

	boolean add(Company company);
	
	List<Company> getAllCompanies();
}
