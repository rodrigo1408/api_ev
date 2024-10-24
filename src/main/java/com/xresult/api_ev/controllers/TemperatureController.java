package com.xresult.api_ev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xresult.api_ev.services.TemperatureService;


@RestController
@RequestMapping("/api")
public class TemperatureController {

	@Autowired
	private TemperatureService temp;

	@GetMapping("/temperature/status")
	public String getTemperatureStatus() {
		return "Battery temperature: " + temp.getBatteryTemperature() +
				"°C, Motor temperature: " + temp.getMotorTemperature() + "°C" +
				(temp.isSafeTemperature() ? " - Temperatures are safe." : " - Alert: Overheating detected!");
	}
	
	@PostMapping("/temperature/overheat/battery")
	public String overheatBattery() {
		temp.overheatBattery();
		return "Simulated battery overheating! New temperature: " + temp.getBatteryTemperature() + "°C";
	}
	
	@PostMapping("/temperature/overheat/motor")
	public String overheatMotor() {
		temp.overheatMotor();
		return "Simulated motor overheating! New temperature: " + temp.getMotorTemperature() + "°C";
	}
	
	@PostMapping("/temperature/reset")
	public String resetTemperatures() {
		temp.resetTemperatures();
		return "Temperatures reset to normal value.";
	}
	
}
