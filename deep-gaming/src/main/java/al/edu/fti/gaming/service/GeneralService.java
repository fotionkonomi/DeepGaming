package al.edu.fti.gaming.service;

import java.util.List;

import org.springframework.validation.ObjectError;
import org.springframework.web.multipart.MultipartFile;

public interface GeneralService {

	/**
	 * 
	 * @param companyImage
	 * @param id
	 * @param path
	 * @param addOrUpdate  Add Entity - true, Update Entity - false
	 */
	void imageProcessing(Object object, MultipartFile companyImage, int id, String path, boolean addOrUpdate);

	List<ObjectError> listOfErrorsWithoutImageError(List<ObjectError> errorsFromValidation, MultipartFile image, String errorMessage);
}
