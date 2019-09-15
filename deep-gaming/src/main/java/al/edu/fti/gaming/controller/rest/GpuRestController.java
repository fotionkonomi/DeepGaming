package al.edu.fti.gaming.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import al.edu.fti.gaming.dto.CpuDTO;
import al.edu.fti.gaming.dto.CpuFamilyDTO;
import al.edu.fti.gaming.dto.GpuDTO;
import al.edu.fti.gaming.dto.GpuFamilyDTO;
import al.edu.fti.gaming.exception.NoCpuFamilyFoundForCompanyException;
import al.edu.fti.gaming.exception.NoCpuFoundForCpuFamily;
import al.edu.fti.gaming.exception.NoGpuFamilyFoundForCompanyException;
import al.edu.fti.gaming.exception.NoGpuFoundForGpuFamily;
import al.edu.fti.gaming.service.GpuFamilyService;
import al.edu.fti.gaming.service.GpuService;

@RestController
@RequestMapping("gpu/gpu-rest")
public class GpuRestController {

	@Autowired
	private GpuFamilyService gpuFamilyService;

	@Autowired
	private GpuService gpuService;

	@GetMapping(value = "/{companyName}", produces = "application/json")
	public List<GpuFamilyDTO> getGpuFamiliesByCompany(@PathVariable("companyName") String companyName) {
		List<GpuFamilyDTO> gpuFamilyList;
		try {
			gpuFamilyList = gpuFamilyService.getGuFamiliesByCompany(companyName);
		} catch (NoGpuFamilyFoundForCompanyException ex) {
			gpuFamilyList = null;
		}
		return gpuFamilyList;
	}

	@GetMapping(value = "gpuFamily/{gpuFamilyId}", produces = "application/json")
	public List<GpuDTO> getGpusByGpuFamily(@PathVariable("gpuFamilyId") Integer gpuFamilyId) {
		List<GpuDTO> gpuList;
		try {
			gpuList = gpuService.getGpusByFamily(gpuFamilyId);
		} catch (NoGpuFoundForGpuFamily e) {
			gpuList = null;
		}
		return gpuList;
	}
}
