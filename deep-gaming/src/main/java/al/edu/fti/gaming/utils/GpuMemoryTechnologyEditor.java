package al.edu.fti.gaming.utils;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.GpuMemoryTechnologyDTO;
import al.edu.fti.gaming.service.GpuMemoryTechnologyService;

@Component
public class GpuMemoryTechnologyEditor extends PropertyEditorSupport {

	@Autowired
	private GpuMemoryTechnologyService gpuMemoryTechnologyService;

	@Override
	public void setAsText(String text) {
		try {
			Integer id = Integer.parseInt(text);
			GpuMemoryTechnologyDTO gpuMemoryTechnologyDTO = this.gpuMemoryTechnologyService.getGpuMemoryTechnologyById(id);

			this.setValue(gpuMemoryTechnologyDTO);
		} catch (NumberFormatException e) {
			return;
		}
	}
}
