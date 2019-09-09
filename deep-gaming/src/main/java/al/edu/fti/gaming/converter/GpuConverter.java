package al.edu.fti.gaming.converter;

import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.GpuDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.models.GPU;
import al.edu.fti.gaming.models.IModel;

@Component
public class GpuConverter implements Converter {

	@Override
	public IModel toModel(IDto dtoObject) {
		GPU gpu = new GPU();
		GpuDTO gpuDTO = (GpuDTO) dtoObject;
		if(gpuDTO.getId() != null) {
			gpu.setIdProduct(gpuDTO.getId());
		}
		gpu.setProductName(gpuDTO.getName());
		gpu.setProductDescription(gpuDTO.getDescription());
		gpu.setPrice(gpuDTO.getPrice());
		gpu.setQuantity(gpuDTO.getQuantity());
		gpu.setUploadDate(gpuDTO.getUploadDate());
		gpu.setEditedDate(gpuDTO.getEditedDate());
		gpu.setHyperlink(gpuDTO.getHyperlink());
		gpu.setTmu(gpuDTO.getTmu());
		gpu.setTextureRate(gpuDTO.getTextureRate());
		gpu.setRop(gpuDTO.getRop());
		gpu.setPixelRate(gpuDTO.getPixelRate());
		gpu.setShaderProcessingUnits(gpuDTO.getShaderProcessingUnits());
		gpu.setRayTracingCores(gpuDTO.getRayTracingCores());
		gpu.setTensorCores(gpuDTO.getTensorCores());
		gpu.setDriverSupport(gpuDTO.getDriverSupport());
		gpu.setMemorySize(gpuDTO.getMemorySize());
		gpu.setMemorySpeed(gpuDTO.getMemorySpeed());
		gpu.setMemoryBus(gpuDTO.getMemoryBus());
		gpu.setMemoryBandwidth(gpuDTO.getMemoryBandwidth());
		gpu.setCache(gpuDTO.getCache());
		gpu.setCoreSpeed(gpuDTO.getCoreSpeed());
		gpu.setBoostClock(gpuDTO.getBoostClock());
		gpu.setTdp(gpuDTO.getTdp());
		gpu.setShader(gpuDTO.getShader());
		gpu.setOpenGL(gpuDTO.getOpenGL());
//		gpu.setGpuBenchmark(gpuDTO.getGpuBenchmark());
		return gpu;
	}

	@Override
	public IDto toDTO(IModel modelObject) {
		return null;
	}

}
