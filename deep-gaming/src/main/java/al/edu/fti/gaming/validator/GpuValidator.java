package al.edu.fti.gaming.validator;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import al.edu.fti.gaming.dto.GpuDTO;


public class GpuValidator implements Validator {

	@Autowired
	private javax.validation.Validator beanValidator;
	
	private Set<Validator> springValidators;
	
	public GpuValidator() {
		setSpringValidators(new HashSet<Validator>());
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return GpuDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Set<ConstraintViolation<Object>> constraintViolations = beanValidator.validate(target);
		
		for(ConstraintViolation<Object> constraintViolation : constraintViolations) {
			String propertyPath = constraintViolation.getPropertyPath().toString();
			String message = constraintViolation.getMessage();
			errors.rejectValue(propertyPath, "", message);
			
		}
		
		for(org.springframework.validation.Validator validator : springValidators) {
			validator.validate(target, errors);
		}
	}
	
	public Set<Validator> getSpringValidators() {
		return springValidators;
	}

	public void setSpringValidators(Set<Validator> springValidators) {
		this.springValidators = springValidators;
	}

	
}
