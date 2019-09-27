package al.edu.fti.gaming.utils;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.MotherboardFormFactorDTO;
import al.edu.fti.gaming.service.MotherboardFormFactorService;

@Component
public class MotherboardFormFactorEditor extends PropertyEditorSupport {

	@Autowired
	private MotherboardFormFactorService motherboardFormFactorService;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			System.out.println("TEXT: " + text);
			Integer id = Integer.parseInt(text);
			MotherboardFormFactorDTO motherboardFormFactorDTO = this.motherboardFormFactorService
					.getMotherboardFormFactorById(id);

			this.setValue(motherboardFormFactorDTO);
		} catch (NumberFormatException e) {
			return;
		}
	}
}
