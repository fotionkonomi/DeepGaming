package al.edu.fti.gaming.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import al.edu.fti.gaming.dto.CpuDTO;

@Component
public class CpuSpeedValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CpuDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		CpuDTO cpu = (CpuDTO) target;

		if (cpu.getCpuSpeed() != null && cpu.getTurboSpeed() != null) {

			if (cpu.getCpuSpeed() > cpu.getTurboSpeed()) {
				errors.rejectValue("cpuSpeed", "errors.rejectValue.validator.cpuSpeed.message");
				errors.reject("turboSpeed", "errors.rejectValue.validator.turboSpeed.message");
			}
		}

	}
}
