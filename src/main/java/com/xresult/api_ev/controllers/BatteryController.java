package com.xresult.api_ev.controllers;

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
	
	@Autowired
	private BatteryService batt;
	
	@GetMapping("/battery/status")
	public Battery getBatteryStatus() {
		return batt.getBatteryStatus();
	}
	
	@PostMapping("/battery/recharge")
	public String rechargeBattery(@RequestParam double amount) {
		batt.rechargeBattery(amount);
		return "Battery recharged by " + amount + "%.";
	}
	
	@PostMapping("/battery/discharge")
	public String dischargeBattery(@RequestParam double amount) {
		batt.dischargeBattery(amount);
		return "Battery discharged by " + amount + "%.";
	}
	
}
