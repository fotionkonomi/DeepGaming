package al.edu.fti.gaming.utils;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.CpuArchitectureDTO;
import al.edu.fti.gaming.service.CpuArchitectureService;

@Component
public class CpuArchitectureEditor extends PropertyEditorSupport {

	@Autowired
	private CpuArchitectureService cpuArchitectureService;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Integer id = Integer.parseInt(text);
		
		CpuArchitectureDTO cpuArchitectureDTO = this.cpuArchitectureService.getCpuArchitectureById(id);
		
		this.setValue(cpuArchitectureDTO);
	}
	
	
}
