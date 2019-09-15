package al.edu.fti.gaming.utils;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.CpuDTO;
import al.edu.fti.gaming.service.CpuService;

@Component
public class CpuEditor extends PropertyEditorSupport {

	@Autowired
	private CpuService cpuService;
	
	@Override
	public void setAsText(String text) {
		try {
			Integer id  = Integer.parseInt(text);
			CpuDTO cpuDTO = cpuService.getCpuById(id);
			
			this.setValue(cpuDTO);
		} catch(NumberFormatException e) {
			return;
		}
	}
}
