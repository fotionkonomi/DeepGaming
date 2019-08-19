package al.edu.fti.gaming.service;

import java.util.List;
import java.util.Map;

import org.springframework.validation.ObjectError;
import org.springframework.web.multipart.MultipartFile;

import al.edu.fti.gaming.dto.IdNameDescriptionDTO;

public interface GeneralService {

	/**
	 * 
	 * @param companyImage
	 * @param id
	 * @param path
	 * @param addOrUpdate  Add Entity - true, Update Entity - false
	 */
	void imageProcessing(IdNameDescriptionDTO dtoObject, String path, boolean addOrUpdate);

	List<ObjectError> listOfErrorsWithoutImageError(List<ObjectError> errorsFromValidation, MultipartFile image,
			String errorMessage);
	
	Map<Integer, String> getAllCompaniesMap();
}
