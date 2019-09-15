package al.edu.fti.gaming.utils;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.DirectXDTO;
import al.edu.fti.gaming.service.DirectXService;

@Component
public class DirectXEditor extends PropertyEditorSupport {

	@Autowired
	private DirectXService directXService;

	@Override
	public void setAsText(String text) {
		try {
			Integer id = Integer.parseInt(text);
			DirectXDTO directXDTO = this.directXService.getDirectXById(id);

			this.setValue(directXDTO);
		} catch (NumberFormatException e) {
			return;
		}
	}
}
