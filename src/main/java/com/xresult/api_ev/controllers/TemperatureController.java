package com.xresult.api_ev.controllers;

 import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xresult.api_ev.services.TemperatureService;


@RestController
@RequestMapping("/api")
public class TemperatureController {

	private static final Logger logger = LoggerFactory.getLogger(TemperatureController.class);
	
	@Autowired
	private TemperatureService temp;

	@GetMapping("/temperature/status")
	public String getTemperatureStatus() {
		String message = String.format("Battery temperature: " + temp.getBatteryTemperature() +
				"°C, Motor temperature: " + temp.getMotorTemperature() + "°C" +
				(temp.isSafeTemperature() ? " - Temperatures are safe." : " - Alert: Overheating detected!"));
		logger.info(message);

		return message;
	}
	
	@PostMapping("/temperature/overheat/battery")
	public String overheatBattery() {
		temp.overheatBattery();
		String message = String.format("Simulated battery overheating! New temperature: " + temp.getBatteryTemperature() + "°C");
		logger.info(message);
		
		return message;
	}
	
	@PostMapping("/temperature/overheat/motor")
	public String overheatMotor() {
		temp.overheatMotor();
		String message = String.format("Simulated motor overheating! New temperature: " + temp.getMotorTemperature() + "°C");
		logger.info(message);
		
		return message;
	}
	
	@PostMapping("/temperature/reset")
	public String resetTemperatures() {
		temp.resetTemperatures();
		String message = String.format("Temperatures reset to normal value.");
		logger.info(message);
		
		return message;
	}
	
}
