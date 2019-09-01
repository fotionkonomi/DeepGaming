package al.edu.fti.gaming.service.impl;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;
import org.springframework.web.multipart.MultipartFile;

import al.edu.fti.gaming.dto.CompanyDTO;
import al.edu.fti.gaming.dto.IdNameDescriptionDTO;
import al.edu.fti.gaming.dto.ProductDTO;
import al.edu.fti.gaming.service.CompanyService;
import al.edu.fti.gaming.service.GeneralService;

@Service
public class GeneralServiceImpl implements GeneralService {

	@Autowired
	private CompanyService companyService;

	@Override
	public void imageProcessing(IdNameDescriptionDTO dtoObject, String path, boolean addOrUpdate) {
		String nameOfClass = dtoObject.getClass().getSimpleName().toLowerCase();
		int indexOfDTO = nameOfClass.indexOf("dto");
		nameOfClass = nameOfClass.substring(0, indexOfDTO);
		System.out.println(nameOfClass);
		String imageLocation = path + "resources\\img\\" + nameOfClass + dtoObject.getId() + ".png";
		try {
			if (addOrUpdate == false) {
				File existingImage = new File(imageLocation);
				existingImage.delete();
			}
			dtoObject.getImage().transferTo(new File(imageLocation));
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

	@Override
	public Map<Integer, String> getAllCompaniesMap() {
		List<CompanyDTO> allCompaniesList = companyService.getAllCompanies();
		Map<Integer, String> allCompanies = new HashMap<Integer, String>();
		for (CompanyDTO companyDTO : allCompaniesList) {
			allCompanies.put(companyDTO.getId(), companyDTO.getName());
		}
		return allCompanies;
	}

	@Override
	public void convertStringToDate(ProductDTO productDTO) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse(productDTO.getDate());
		productDTO.setReleaseDate(date);
	}

}
