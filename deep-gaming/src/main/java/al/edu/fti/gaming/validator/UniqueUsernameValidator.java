package al.edu.fti.gaming.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.service.UserService;

@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

	@Autowired
	private UserService userService;

	@Override
	public void initialize(UniqueUsername constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return !userService.doesUsernameExist(value);
	}

}
