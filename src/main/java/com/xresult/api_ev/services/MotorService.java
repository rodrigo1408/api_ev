package com.xresult.api_ev.services;

import org.springframework.stereotype.Service;

import com.xresult.api_ev.entity.MotorStatus;

@Service
public class MotorService {
	private static final double MAX_POWER = 80.0;
	private static final double MAX_BATTERY_VOLTAGE = 400.0;
	
	private MotorStatus motorStatus;
	
	public MotorService() {
		this.motorStatus = new MotorStatus(0, 0);
	}
	
	public MotorStatus calculatePower(double throttlePosition, double batteryVoltage) {
		double power = throttlePosition / 100 * MAX_POWER;
		
		if(batteryVoltage < MAX_BATTERY_VOLTAGE) {
			power *= batteryVoltage / MAX_BATTERY_VOLTAGE;
		}
		
		motorStatus.setPower(power);
		motorStatus.setThrottlePosition(throttlePosition);
		return motorStatus;
	}
}
