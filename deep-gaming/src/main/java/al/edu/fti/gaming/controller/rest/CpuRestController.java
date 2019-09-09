package al.edu.fti.gaming.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import al.edu.fti.gaming.dto.CpuDTO;
import al.edu.fti.gaming.dto.CpuFamilyDTO;
import al.edu.fti.gaming.exception.NoCpuFamilyFoundForCompanyException;
import al.edu.fti.gaming.exception.NoCpuFoundForCpuFamily;
import al.edu.fti.gaming.service.CpuFamilyService;
import al.edu.fti.gaming.service.CpuService;

@RestController
@RequestMapping("cpu/cpu-rest")
public class CpuRestController {

	@Autowired
	private CpuFamilyService cpuFamilyService;

	@Autowired
	private CpuService cpuService;

	@GetMapping(value = "/{companyName}", produces = "application/json")
	public List<CpuFamilyDTO> getCpuFamiliesByCompany(@PathVariable("companyName") String companyName) {
		List<CpuFamilyDTO> cpuFamilyList;
		try {
			cpuFamilyList = cpuFamilyService.getCpuFamiliesByCompany(companyName);
		} catch (NoCpuFamilyFoundForCompanyException ex) {
			cpuFamilyList = null;
		}
		return cpuFamilyList;
	}

	@GetMapping(value = "cpuFamily/{cpuFamilyId}", produces = "application/json")
	public List<CpuDTO> getCpusByCpuFamily(@PathVariable("cpuFamilyId") Integer cpuFamilyId) {
		List<CpuDTO> cpuList;
		try {
			cpuList = cpuService.getCpusByCpuFamily(cpuFamilyId);
		} catch (NoCpuFoundForCpuFamily e) {
			cpuList = null;
		}
		return cpuList;
	}
}
