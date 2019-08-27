package al.edu.fti.gaming.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.CpuArchitectureDTO;
import al.edu.fti.gaming.dto.CpuDTO;
import al.edu.fti.gaming.dto.CpuFamilyDTO;
import al.edu.fti.gaming.dto.CpuSocketDTO;
import al.edu.fti.gaming.dto.GpuDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.models.CPU;
import al.edu.fti.gaming.models.CpuArchitecture;
import al.edu.fti.gaming.models.CpuFamily;
import al.edu.fti.gaming.models.CpuSocket;
import al.edu.fti.gaming.models.GPU;
import al.edu.fti.gaming.models.IModel;

@Component
public class CpuConverter implements Converter {

	@Autowired
	@Qualifier("cpuFamilyConverter")
	private Converter cpuFamilyConverter;

	@Autowired
	@Qualifier("cpuSocketConverter")
	private Converter cpuSocketConverter;

	@Autowired
	@Qualifier("cpuArchitectureConverter")
	private Converter cpuArchitectureConverter;

	/*
	 * ------------ DONT FORGET ----------------
	 * 
	 * @Autowired
	 * 
	 * @Qualifier("gpuConverter") private Converter gpuConverter;
	 */

	@Override
	public IModel toModel(IDto dtoObject) {
		CPU cpu = new CPU();
		CpuDTO cpuDTO = (CpuDTO) dtoObject;
		if (cpuDTO.getId() != null) {
			cpu.setIdProduct(cpuDTO.getId());
		}
		cpu.setProductName(cpuDTO.getName());
		cpu.setProductDescription(cpuDTO.getDescription());
		cpu.setReleaseDate(cpuDTO.getReleaseDate());
		cpu.setPrice(cpuDTO.getPrice());
		cpu.setQuantity(cpuDTO.getQuantity());
		cpu.setUploadDate(cpuDTO.getUploadDate());
		cpu.setEditedDate(cpuDTO.getEditedDate());
		cpu.setHyperlink(cpuDTO.getHyperlink());
		cpu.setCpuSpeed(cpuDTO.getCpuSpeed());
		cpu.setTurboSpeed(cpuDTO.getTurboSpeed());
		cpu.setPhysicalCores(cpuDTO.getPhysicalCores());
		cpu.setThreads(cpuDTO.getThreads());
		cpu.setTdp(cpuDTO.getTdp());
		cpu.setBitWidth(cpuDTO.getBitWidth());
		cpu.setL1Cache(cpuDTO.getL1Cache());
		cpu.setL2Cache(cpuDTO.getL2Cache());
		cpu.setL3Cache(cpuDTO.getL3Cache());
		cpu.setFamilyOfThisCpu((CpuFamily) cpuFamilyConverter.toModel(cpuDTO.getFamilyOfThisCpu()));
		cpu.setSocketForThisCpu((CpuSocket) cpuSocketConverter.toModel(cpuDTO.getSocketOfThisCpu()));
		cpu.setArchitectureOfThisCpu(
				(CpuArchitecture) cpuArchitectureConverter.toModel(cpuDTO.getArchitectureOfThisCpu()));

		// cpu.setIntegratedGpuOfThisCpu((GPU)
		// gpuConverter.toModel(cpuDTO.getIntegratedGpuOfThisCpu()));

		return cpu;
	}

	@Override
	public IDto toDTO(IModel modelObject) {
		CpuDTO cpuDTO = new CpuDTO();
		CPU cpu = (CPU) modelObject;
		cpuDTO.setId(cpu.getIdProduct());
		cpuDTO.setName(cpu.getProductName());
		cpuDTO.setDescription(cpu.getProductDescription());
		cpuDTO.setReleaseDate(cpu.getReleaseDate());
		cpuDTO.setPrice(cpu.getPrice());
		cpuDTO.setQuantity(cpu.getQuantity());
		cpuDTO.setUploadDate(cpu.getUploadDate());
		cpuDTO.setEditedDate(cpu.getEditedDate());
		cpuDTO.setHyperlink(cpu.getHyperlink());
		cpuDTO.setCpuSpeed(cpu.getCpuSpeed());
		cpuDTO.setTurboSpeed(cpu.getTurboSpeed());
		cpuDTO.setPhysicalCores(cpu.getPhysicalCores());
		cpuDTO.setThreads(cpu.getThreads());
		cpuDTO.setTdp(cpu.getTdp());
		cpuDTO.setBitWidth(cpu.getBitWidth());
		cpuDTO.setL1Cache(cpu.getL1Cache());
		cpuDTO.setL2Cache(cpu.getL2Cache());
		cpuDTO.setL3Cache(cpu.getL3Cache());
		cpuDTO.setFamilyOfThisCpu((CpuFamilyDTO) cpuFamilyConverter.toDTO(cpu.getFamilyOfThisCpu()));
		cpuDTO.setSocketOfThisCpu((CpuSocketDTO) cpuSocketConverter.toDTO(cpu.getSocketForThisCpu()));
		cpuDTO.setArchitectureOfThisCpu(
				(CpuArchitectureDTO) cpuArchitectureConverter.toDTO(cpu.getArchitectureOfThisCpu()));

		// cpuDTO.setIntegratedGpuOfThisCpu((GpuDTO)
		// gpuConverter.toDTO(cpu.getIntegratedGpuOfThisCpu()));

		return cpuDTO;
	}

}
