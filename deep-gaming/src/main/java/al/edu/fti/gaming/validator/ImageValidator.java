package al.edu.fti.gaming.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageValidator implements ConstraintValidator<Image, MultipartFile> {

	@Override
	public void initialize(Image constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
		if (value.getOriginalFilename().contains(".png") || value.getOriginalFilename().contains(".jpg")) {
			return true;
		} else {
			return false;
		}
	}

}
