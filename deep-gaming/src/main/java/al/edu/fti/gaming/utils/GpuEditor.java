package al.edu.fti.gaming.utils;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.GpuDTO;
import al.edu.fti.gaming.service.GpuService;

@Component
public class GpuEditor extends PropertyEditorSupport {

	@Autowired
	private GpuService gpuService;

	@Override
	public void setAsText(String text) {
		try {
			Integer id = Integer.parseInt(text);
			GpuDTO gpuDTO = gpuService.getGpuById(id);

			this.setValue(gpuDTO);
		} catch (NumberFormatException e) {
			return;
		}
	}
}