package com.xresult.api_ev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xresult.api_ev.entity.MotorStatus;
import com.xresult.api_ev.services.BatteryService;
import com.xresult.api_ev.services.MotorService;

@RestController
@RequestMapping("/api")
public class MotorController {

	@Autowired
	private MotorService motor;
	
	@Autowired
	private BatteryService batt;
	
	@GetMapping("/motor/power")
	public MotorStatus calculateMotorPower(@RequestParam double throttlePosition) {
		double batteryVoltage = batt.getBatteryStatus().getVoltage();
		return motor.calculatePower(throttlePosition, batteryVoltage);
	}
}
