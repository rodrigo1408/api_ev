package com.xresult.api_ev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegenerativeBrakingService {
	
	@Autowired
	private BatteryService batt;
	
	public void applyRegenerativeBraking(double brakingForce) {
		double regeneration = brakingForce * 0.1;
		batt.rechargeBattery(regeneration);
	}
	
}
