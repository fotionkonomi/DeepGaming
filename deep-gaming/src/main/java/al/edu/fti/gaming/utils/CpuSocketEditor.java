package al.edu.fti.gaming.utils;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.CpuSocketDTO;
import al.edu.fti.gaming.service.CpuSocketService;

@Component
public class CpuSocketEditor extends PropertyEditorSupport {

	@Autowired
	private CpuSocketService cpuSocketService;
	
	@Override
	public void setAsText(String text) {
		Integer id = Integer.parseInt(text);
		CpuSocketDTO cpuSocketDTO = this.cpuSocketService.getCpuSocketById(id);
		
		this.setValue(cpuSocketDTO);
	}
}
