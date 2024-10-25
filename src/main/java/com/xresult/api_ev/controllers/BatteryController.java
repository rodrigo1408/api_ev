package com.xresult.api_ev.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xresult.api_ev.entity.Battery;
import com.xresult.api_ev.services.BatteryService;

@RestController
@RequestMapping("/api")
public class BatteryController {
	
	private static final Logger logger = LoggerFactory.getLogger(BatteryController.class);
	
	@Autowired
	private BatteryService batt;
	
	@GetMapping("/battery/status")
	public Battery getBatteryStatus() {
		String message = String.format("Status battery: " 
				+ " Voltage: " + batt.getBatteryStatus().getVoltage()
				+ " Current: " + batt.getBatteryStatus().getCurrent() 
				+ " ChargeLevel: " + batt.getBatteryStatus().getChargeLevel());
		logger.info(message);
		
		return batt.getBatteryStatus();
	}
	
	@PostMapping("/battery/recharge")
	public String rechargeBattery(@RequestParam double amount) {
		batt.rechargeBattery(amount);
		String message = String.format(Locale.US, "Battery recharged by %.2f%%.", amount);
	    logger.info(message);
	    
	    return message;
	}
	
	@PostMapping("/battery/discharge")
	public String dischargeBattery(@RequestParam double amount) {
		batt.dischargeBattery(amount);
		String message = String.format(Locale.US, "Battery discharged by %.2f%%.", amount);
	    logger.info(message);
	    
	    return message;
	}
	
}
