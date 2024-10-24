package com.xresult.api_ev.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xresult.api_ev.services.RegenerativeBrakingService;

@RestController
@RequestMapping("/api")
public class RegenerativeBrakingController {

	private static final Logger logger = LoggerFactory.getLogger(RegenerativeBrakingController.class);
	
	@Autowired
	private RegenerativeBrakingService reg;

	@PostMapping("/braking/regenerative")
	public String applyRegenerativeBraking(@RequestParam double brakingForce) {
		reg.applyRegenerativeBraking(brakingForce);
		String message = String.format(Locale.US, "Regenerative braking aplicaded with force of %.2f%%.", brakingForce);
	    logger.info(message);
	    
	    return message;
	}
}