package com.xresult.api_ev.services;

import org.springframework.stereotype.Service;

import com.xresult.api_ev.entity.Battery;

@Service
public class BatteryService {
	
	private Battery battery;
	
	public BatteryService() {
		this.battery = new Battery(400.0, 100.0, 80.0);
	}
	
	public Battery getBatteryStatus() {
		return battery;
	}
	
	public void dischargeBattery(double amount) {
		double newChargeLevel = battery.getChargeLevel() - amount;
		if(newChargeLevel < 0) {
			newChargeLevel = 0;
		}
		
		battery.setChargeLevel(newChargeLevel);
	}
	
	public void rechargeBattery(double amount) {
		double newChargeLevel = battery.getChargeLevel() + amount;
		if(newChargeLevel > 100) {
			newChargeLevel = 100;
		}
		
		battery.setChargeLevel(newChargeLevel);
	}
}
