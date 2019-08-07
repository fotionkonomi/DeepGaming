package al.edu.fti.gaming.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;
import org.springframework.web.multipart.MultipartFile;

import al.edu.fti.gaming.service.GeneralService;

@Service
public class GeneralServiceImpl implements GeneralService {

	@Override
	public void imageProcessing(Object object, MultipartFile companyImage, int id, String path, boolean addOrUpdate) {
		String nameOfClass = object.getClass().getSimpleName().toLowerCase();
		int indexOfDTO = nameOfClass.indexOf("dto");
		nameOfClass = nameOfClass.substring(0, indexOfDTO);
		String imageLocation = path + "resources\\img\\" + nameOfClass + id + ".png";
		try {
			if (addOrUpdate == false) {
				File existingImage = new File(imageLocation);
				existingImage.delete();
			}
			companyImage.transferTo(new File(imageLocation));
		} catch (Exception e) {
			throw new RuntimeException("Image saving failed");
		}

	}

	@Override
	public List<ObjectError> listOfErrorsWithoutImageError(List<ObjectError> errorsFromValidation, MultipartFile image,
			String errorMessage) {
		if (image == null || image.isEmpty()) {
			List<ObjectError> errorsWithoutImageError = new ArrayList<ObjectError>();
			for (ObjectError error : errorsFromValidation) {
				if (!error.getDefaultMessage().equals(errorMessage)) {
					errorsWithoutImageError.add(error); // exception UnsupportedOperationException nese beja vetem
														// remove
				}
			}
			return errorsWithoutImageError;
		} else {
			return errorsFromValidation;
		}
	}

}
