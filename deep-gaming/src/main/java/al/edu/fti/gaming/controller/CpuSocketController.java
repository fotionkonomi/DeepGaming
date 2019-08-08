package al.edu.fti.gaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import al.edu.fti.gaming.service.CpuSocketService;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.utils.Messages;

@Controller
@RequestMapping("/cpusocket")
public class CpuSocketController {
	
	@Autowired
	private CpuSocketService cpuSocketService;
	
	@Autowired
	private GeneralService generalService;
	
	@Autowired
	private Messages messages;
	
	
}
