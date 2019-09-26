package al.edu.fti.gaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import al.edu.fti.gaming.service.CpuSocketService;
import al.edu.fti.gaming.service.GpuSlotService;
import al.edu.fti.gaming.service.MotherboardFormFactorService;
import al.edu.fti.gaming.service.MotherboardService;

@Controller
@RequestMapping("/motherboard")
public class MotherboardController {

	@Autowired
	private MotherboardService motherboardService;
	
	@Autowired
	private MotherboardFormFactorService motherboardFormFactorService;

	@Autowired
	private CpuSocketService cpuSocketService;
	
	@Autowired
	private GpuSlotService gpuSlotService;
	
}
