package al.edu.fti.gaming.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import al.edu.fti.gaming.dto.GpuDTO;

@Component
public class GpuSpeedValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return GpuDTO.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		GpuDTO gpu = (GpuDTO) target;

		if (gpu.getCoreSpeed() != null && gpu.getBoostClock() != null) {
			if (gpu.getCoreSpeed() > gpu.getBoostClock()) {
				errors.rejectValue("coreSpeed", "errors.rejectValue.validator.coreSpeed.message");
				errors.rejectValue("boostClock", "errors.rejectValue.validator.boostClock.message");
			}
		}
	}

}
