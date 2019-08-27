package al.edu.fti.gaming.service;

import java.util.List;

import al.edu.fti.gaming.dto.OperatingSystemTypeDTO;
import al.edu.fti.gaming.models.OperatingSystemType;

public interface OperatingSystemTypeService {

	int add( OperatingSystemTypeDTO operatingSystemTypeDTO);
	
	List<OperatingSystemTypeDTO> getOperatingSystemTypes();
	
	OperatingSystemTypeDTO getOperatingSystemTypeById(int id);
	
	boolean update(OperatingSystemTypeDTO peratingSystemTypeDTO);
	
	List<OperatingSystemTypeDTO> getAllOperatingSystemTypesThatHaveOperatingSystems();

    List<OperatingSystemTypeDTO> getAllOperatingSystemTypesByCompanyName(String companyName);


}
