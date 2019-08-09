package al.edu.fti.gaming.converter;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.CompanyDTO;
import al.edu.fti.gaming.dto.CpuSocketDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.models.Company;
import al.edu.fti.gaming.models.CpuSocket;
import al.edu.fti.gaming.models.IModel;

@Component
public class CpuSocketConverter implements Converter {

	private static final Logger LOGGER = Logger.getLogger(CpuSocketConverter.class.getName());

	@Autowired
	@Qualifier("companyConverter")
	private Converter companyConverter;

	@Override
	public IModel toModel(IDto dtoObject) {
		CpuSocket cpuSocket = new CpuSocket();
		CpuSocketDTO cpuSocketDTO = (CpuSocketDTO) dtoObject;
		LOGGER.log(Level.INFO, "Starting the conversion from CpuSocketDTO to CpuSocket:\n");
		LOGGER.log(Level.INFO, "|-----------------------------------------------------------------------");
		if (cpuSocketDTO.getId() != null) {
			cpuSocket.setIdCpuSocket(cpuSocketDTO.getId());
			LOGGER.log(Level.INFO, "1) The id has been converted.");
		} else {
			LOGGER.log(Level.INFO, "1) The id in the dto object was null, so an auto-increment will happen.");
		}
		cpuSocket.setSocketName(cpuSocketDTO.getName());
		LOGGER.log(Level.INFO, "2) The name has been converted.");
		cpuSocket.setSocketDescription(cpuSocketDTO.getDescription());
		LOGGER.log(Level.INFO, "3) The description has been converted.");
		cpuSocket.setLaptopOrDesktop(cpuSocketDTO.getLaptopOrDesktop());
		LOGGER.log(Level.INFO, "4) The laptop/desktop attribute has been converted.");
		cpuSocket.setCompanyThatCreatedThisSocket(
				(Company) companyConverter.toModel(cpuSocketDTO.getCompanyOfThisSocket()));
		LOGGER.log(Level.INFO, "5) The company attribute has been converted.");
		LOGGER.log(Level.INFO, "The conversion has finished successfully!");
		LOGGER.log(Level.INFO, "-----------------------------------------------------------------------|");
		return cpuSocket;
	}

	@Override
	public IDto toDTO(IModel modelObject) {
		CpuSocketDTO cpuSocketDTO = new CpuSocketDTO();
		CpuSocket cpuSocket = (CpuSocket) modelObject;
		LOGGER.log(Level.INFO, "Starting the conversion from CpuSocket to CpuSocketDTO:");
		LOGGER.log(Level.INFO, "|----------------------------------------------------------------------");
		cpuSocketDTO.setId(cpuSocket.getIdCpuSocket());
		LOGGER.log(Level.INFO, "1) The id has been converted.");
		cpuSocketDTO.setName(cpuSocket.getSocketName());
		LOGGER.log(Level.INFO, "2) The name has been converted.");
		cpuSocketDTO.setDescription(cpuSocket.getSocketDescription());
		LOGGER.log(Level.INFO, "3) The description has been converted");
		cpuSocketDTO.setLaptopOrDesktop(cpuSocket.getLaptopOrDesktop());
		LOGGER.log(Level.INFO, "4) The laptop/desktop attribute has been converted.");
		cpuSocketDTO.setCompanyOfThisSocket(
				((CompanyDTO) companyConverter.toDTO(cpuSocket.getCompanyThatCreatedThisSocket())));
		LOGGER.log(Level.INFO, "5) The company attribute has been converted.");
		LOGGER.log(Level.INFO, "The conversion has finished successfully!");
		LOGGER.log(Level.INFO, "-----------------------------------------------------------------------|");
		return cpuSocketDTO;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	public Converter getCompanyConverter() {
		return companyConverter;
	}

	public void setCompanyConverter(Converter companyConverter) {
		this.companyConverter = companyConverter;
	}

}
