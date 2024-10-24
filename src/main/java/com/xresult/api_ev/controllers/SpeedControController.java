package com.xresult.api_ev.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xresult.api_ev.services.SpeedControlService;

@RestController
@RequestMapping("/api")
public class SpeedControController {

	private static final Logger logger = LoggerFactory.getLogger(SpeedControController.class);
			
	@Autowired
	private SpeedControlService speedControlService;
	
	@GetMapping("/motor/speed")
	public String calculateSpeed(@RequestParam double power) {
        double speed = speedControlService.calculateSpeed(power);
        String message = String.format(Locale.US, "Calculated speed: " + speed + " km/h with power of " + power + " kW.");
	    logger.info(message);
	    
	    return message;
	}
}
