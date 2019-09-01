package al.edu.fti.gaming.utils;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.CpuFamilyDTO;
import al.edu.fti.gaming.service.CpuFamilyService;

@Component
public class CpuFamilyEditor extends PropertyEditorSupport {

	@Autowired
	private CpuFamilyService cpuFamilyService;
	
	@Override
	public void setAsText(String text) {
		Integer id = Integer.parseInt(text);
		CpuFamilyDTO cpuFamilyDTO = this.cpuFamilyService.getCpuFamilyById(id);
		
		this.setValue(cpuFamilyDTO);
	}
}
