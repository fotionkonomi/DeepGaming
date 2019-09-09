package al.edu.fti.gaming.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import al.edu.fti.gaming.dto.CpuDTO;

@Component
public class CpuCacheValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CpuDTO.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		CpuDTO cpu = (CpuDTO) target;
		Integer l1Cache = cpu.getL1Cache();
		Integer l2Cache = cpu.getL2Cache();
		Integer l3Cache = cpu.getL3Cache();

		if (l1Cache != null && l2Cache != null && l3Cache != null) {

			if (l1Cache >= l2Cache) {
				errors.rejectValue("l1Cache", "errors.rejectValue.validator.l1Cache_l2Cache.message");
				errors.rejectValue("l2Cache", "errors.rejectValue.validator.l2Cache_l1Cache.message");
			}

			if (l1Cache >= l3Cache) {
				errors.rejectValue("l1Cache", "errors.rejectValue.validator.l1Cache_l3Cache.message");
				errors.rejectValue("l3Cache", "errors.rejectValue.validator.l3Cache_l1Cache.message");
			}

			if (l2Cache >= l3Cache) {
				errors.rejectValue("l2Cache", "errors.rejectValue.validator.l2Cache_l3Cache.message");
				errors.rejectValue("l3Cache", "errors.rejectValue.validator.l3Cache_l2Cache.message");
			}
		}
	}
}
