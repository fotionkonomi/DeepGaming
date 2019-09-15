package al.edu.fti.gaming.utils;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.GpuSlotDTO;
import al.edu.fti.gaming.service.GpuSlotService;

@Component
public class GpuSlotEditor extends PropertyEditorSupport {

	@Autowired
	private GpuSlotService gpuSlotService;

	@Override
	public void setAsText(String text) {
		try {
			Integer id = Integer.parseInt(text);
			GpuSlotDTO gpuSlotDTO = this.gpuSlotService.getGpuSlotById(id);

			this.setValue(gpuSlotDTO);
		} catch (NumberFormatException e) {
			return;
		}
	}
}
