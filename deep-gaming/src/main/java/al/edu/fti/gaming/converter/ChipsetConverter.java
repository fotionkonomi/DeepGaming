package al.edu.fti.gaming.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.ChipsetDTO;
import al.edu.fti.gaming.dto.CompanyDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.models.Chipset;
import al.edu.fti.gaming.models.Company;
import al.edu.fti.gaming.models.IModel;

@Component
public class ChipsetConverter implements Converter {

	@Autowired
	@Qualifier("companyConverter")
	private Converter companyConverter;

	@Override
	public IModel toModel(IDto dtoObject) {
		Chipset chipset = new Chipset();
		ChipsetDTO chipsetDTO = (ChipsetDTO) dtoObject;
		if (chipsetDTO.getId() != null) {
			chipset.setIdChipset(chipsetDTO.getId());
		}
		chipset.setChipsetName(chipsetDTO.getName());
		chipset.setChipsetDescription(chipsetDTO.getDescription());
		chipset.setCompanyThatCreatedThisChipset(
				(Company) companyConverter.toModel(chipsetDTO.getCompanyOfThisChipset()));
		return chipset;
	}

	@Override
	public IDto toDTO(IModel modelObject) {
		ChipsetDTO chipsetDTO = new ChipsetDTO();
		Chipset chipset = (Chipset) modelObject;
		chipsetDTO.setId(chipset.getIdChipset());
		chipsetDTO.setName(chipset.getChipsetName());
		chipsetDTO.setDescription(chipset.getChipsetDescription());
		chipsetDTO.setCompanyOfThisChipset(
				(CompanyDTO) (companyConverter.toDTO(chipset.getCompanyThatCreatedThisChipset())));
		return chipsetDTO;
	}

}
