package com.xresult.api_ev.controllers;

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

	@Autowired
	private DrivingModeService driv;
	 

	@PostMapping("/driving/mode")
	public String setDrivingMode(@RequestParam String mode) {
		try {
			DrivingMode selectedMode = DrivingMode.valueOf(mode.toUpperCase());
			driv.setDrivingMode(selectedMode);
			return "Driving mode adjusted for: " + selectedMode;
		} catch (IllegalArgumentException e) {
			return "Driving mode invalid. Use ECO, NORMAL ou SPORT.";
		}
	}

}
