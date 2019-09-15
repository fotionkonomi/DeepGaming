package al.edu.fti.gaming.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.CpuDTO;
import al.edu.fti.gaming.dto.DirectXDTO;
import al.edu.fti.gaming.dto.GpuArchitectureDTO;
import al.edu.fti.gaming.dto.GpuDTO;
import al.edu.fti.gaming.dto.GpuFamilyDTO;
import al.edu.fti.gaming.dto.GpuMemoryTechnologyDTO;
import al.edu.fti.gaming.dto.GpuSlotDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.models.CPU;
import al.edu.fti.gaming.models.DirectX;
import al.edu.fti.gaming.models.GPU;
import al.edu.fti.gaming.models.GpuArchitecture;
import al.edu.fti.gaming.models.GpuFamily;
import al.edu.fti.gaming.models.GpuMemoryTechnology;
import al.edu.fti.gaming.models.GpuSlot;
import al.edu.fti.gaming.models.IModel;

@Component
public class GpuConverter implements Converter {

	@Autowired
	@Qualifier("gpuFamilyConverter")
	private GpuFamilyConverter gpuFamilyConverter;

	@Autowired
	@Qualifier("gpuArchitectureConverter")
	private GpuArchitectureConverter gpuArchitectureConverter;

	@Autowired
	@Qualifier("gpuMemoryTechnologyConverter")
	private GpuMemoryTechnologyConverter gpuMemoryTechnologyConverter;

	@Autowired
	@Qualifier("directXConverter")
	private DirectXConverter directXConverter;

	@Autowired
	@Qualifier("gpuSlotConverter")
	private GpuSlotConverter gpuSlotConverter;

	@Autowired
	@Qualifier("cpuConverter")
	private CpuConverter cpuConverter;

	@Override
	public IModel toModel(IDto dtoObject) {
		GPU gpu = new GPU();
		GpuDTO gpuDTO = (GpuDTO) dtoObject;
		if (gpuDTO.getId() != null) {
			gpu.setIdProduct(gpuDTO.getId());
		}
		gpu.setProductName(gpuDTO.getName());
		gpu.setProductDescription(gpuDTO.getDescription());
		gpu.setPrice(gpuDTO.getPrice());
		gpu.setQuantity(gpuDTO.getQuantity());
		gpu.setReleaseDate(gpuDTO.getReleaseDate());
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
		gpu.setGpuBenchmark(gpuDTO.getGpuBenchmark());
		gpu.setFamilyOfThisGpu((GpuFamily) gpuFamilyConverter.toModel(gpuDTO.getFamilyOfThisGpu()));
		gpu.setArchitectureOfThisGpu(
				(GpuArchitecture) gpuArchitectureConverter.toModel(gpuDTO.getArchitectureOfThisGpu()));
		gpu.setMemoryTechnologyOfThisGpu(
				(GpuMemoryTechnology) gpuMemoryTechnologyConverter.toModel(gpuDTO.getMemoryTechnologyOfThisGpu()));
		gpu.setMaximumDirectXSupportedByThisGpu(
				(DirectX) directXConverter.toModel(gpuDTO.getMaximumDirectXSupportedByThisGpu()));
		gpu.setGpuSlotOfThisGpu((GpuSlot) gpuSlotConverter.toModel(gpuDTO.getGpuSlotOfThisGpu()));
		gpu.setCpuRecommendedForThisGpu((CPU) cpuConverter.toModel(gpuDTO.getCpuRecommendedForThisGpu()));

		return gpu;
	}

	@Override
	public IDto toDTO(IModel modelObject) {
		GpuDTO gpuDTO = new GpuDTO();
		GPU gpu = (GPU) modelObject;
		gpuDTO.setId(gpu.getIdProduct());
		gpuDTO.setName(gpu.getProductName());
		gpuDTO.setDescription(gpu.getProductDescription());
		gpuDTO.setPrice(gpu.getPrice());
		gpuDTO.setQuantity(gpu.getQuantity());
		gpuDTO.setReleaseDate(gpu.getReleaseDate());
		gpuDTO.setUploadDate(gpu.getUploadDate());
		gpuDTO.setEditedDate(gpu.getEditedDate());
		gpuDTO.setHyperlink(gpu.getHyperlink());
		gpuDTO.setTmu(gpu.getTmu());
		gpuDTO.setTextureRate(gpu.getTextureRate());
		gpuDTO.setRop(gpu.getRop());
		gpuDTO.setPixelRate(gpu.getPixelRate());
		gpuDTO.setShaderProcessingUnits(gpu.getShaderProcessingUnits());
		gpuDTO.setRayTracingCores(gpu.getRayTracingCores());
		gpuDTO.setTensorCores(gpu.getTensorCores());
		gpuDTO.setDriverSupport(gpu.getDriverSupport());
		gpuDTO.setMemorySize(gpu.getMemorySize());
		gpuDTO.setMemorySpeed(gpu.getMemorySpeed());
		gpuDTO.setMemoryBus(gpu.getMemoryBus());
		gpuDTO.setMemoryBandwidth(gpu.getMemoryBandwidth());
		gpuDTO.setCache(gpu.getCache());
		gpuDTO.setCoreSpeed(gpu.getCoreSpeed());
		gpuDTO.setBoostClock(gpu.getBoostClock());
		gpuDTO.setTdp(gpu.getTdp());
		gpuDTO.setShader(gpu.getShader());
		gpuDTO.setOpenGL(gpu.getOpenGL());
		gpuDTO.setGpuBenchmark(gpu.getGpuBenchmark());
		gpuDTO.setFamilyOfThisGpu((GpuFamilyDTO) gpuFamilyConverter.toDTO(gpu.getFamilyOfThisGpu()));
		gpuDTO.setArchitectureOfThisGpu(
				(GpuArchitectureDTO) gpuArchitectureConverter.toDTO(gpu.getArchitectureOfThisGpu()));
		gpuDTO.setMemoryTechnologyOfThisGpu(
				(GpuMemoryTechnologyDTO) gpuMemoryTechnologyConverter.toDTO(gpu.getMemoryTechnologyOfThisGpu()));

		gpuDTO.setMaximumDirectXSupportedByThisGpu(
				(DirectXDTO) directXConverter.toDTO(gpu.getMaximumDirectXSupportedByThisGpu()));
		gpuDTO.setGpuSlotOfThisGpu((GpuSlotDTO) gpuSlotConverter.toDTO(gpu.getGpuSlotOfThisGpu()));
		gpuDTO.setCpuRecommendedForThisGpu((CpuDTO) cpuConverter.toDTO(gpu.getCpuRecommendedForThisGpu()));
		return gpuDTO;
	}

}
