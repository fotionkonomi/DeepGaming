package al.edu.fti.gaming.validator;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import al.edu.fti.gaming.dto.CpuDTO;

public class CpuValidator implements Validator {

	@Autowired
	private javax.validation.Validator beanValidator;
	
	private Set<Validator> springValidators;
	
	public CpuValidator() {
		springValidators = new HashSet<Validator>();
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CpuDTO.class.isAssignableFrom(clazz);
	}
	
    public void setSpringValidators(Set<Validator> springValidators) {
		this.springValidators = springValidators;
	}

	@Override
	public void validate(Object target, Errors errors) {

		Set<ConstraintViolation<Object>> constraintViolations = beanValidator.validate(target);
		
		for(ConstraintViolation<Object> constraintViolation : constraintViolations) {
			String propertyPath = constraintViolation.getPropertyPath().toString();
			String message = constraintViolation.getMessage();
			errors.rejectValue(propertyPath, "", message);
			
		}
		
		for(Validator validator : springValidators) {
			validator.validate(target, errors);
		}
	}

	
}
