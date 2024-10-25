package com.xresult.api_ev.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xresult.api_ev.enums.DrivingMode;
import com.xresult.api_ev.services.DrivingModeService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api")
public class DrivingModeController {

	private static final Logger logger = LoggerFactory.getLogger(DrivingModeController.class);
	
	@Autowired
	private DrivingModeService driv;
	 

	@PostMapping("/driving/mode")
	public String setDrivingMode(@RequestParam String mode) {
		try {
			DrivingMode selectedMode = DrivingMode.valueOf(mode.toUpperCase());
			driv.setDrivingMode(selectedMode);
			String message = String.format("Driving mode adjusted for: " + selectedMode);
			logger.info(message);
			
			return message;
		} catch (IllegalArgumentException e) {
			String message = String.format("Driving mode invalid. Use ECO, NORMAL ou SPORT.");
			logger.info(message);
			
			return message;
		}
	}

}
