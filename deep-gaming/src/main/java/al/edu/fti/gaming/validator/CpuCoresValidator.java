package al.edu.fti.gaming.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import al.edu.fti.gaming.dto.CpuDTO;

@Component
public class CpuCoresValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return CpuDTO.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		CpuDTO cpu = (CpuDTO) target;
		Byte physicalCores = cpu.getPhysicalCores();
		Byte threads = cpu.getThreads();
		
		if(physicalCores != null && threads != null ) {
			if(physicalCores > threads) {
				errors.rejectValue("physicalCores", "errors.rejectValue.validator.physicalCores.message");
				errors.rejectValue("threads", "errors.rejectValue.validator.threads.message");
			}
		}
	}

	
}
