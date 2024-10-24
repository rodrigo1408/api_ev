package com.xresult.api_ev.services;

import org.springframework.stereotype.Service;

@Service
public class TemperatureService {

	private double batteryTemperature;
	private double motorTemperature;

	private final static double MAX_BATTERY_TEMP = 45.0;
	private final static double MAX_MOTOR_TEMP = 80.0;


	public TemperatureService() {
		this.batteryTemperature = 30.0;
		this.motorTemperature = 35.0;
	}

	public void updateBatteryTemperature(double increment) {
		this.batteryTemperature += increment;
		if(this.batteryTemperature > MAX_BATTERY_TEMP) {
			this.batteryTemperature = MAX_BATTERY_TEMP;
		}
	}

	public void updateMotorTemperature(double increment) {
		this.motorTemperature += increment;
		if(this.motorTemperature > MAX_MOTOR_TEMP) {
			this.motorTemperature = MAX_MOTOR_TEMP;
		}
	}

	public double getBatteryTemperature() {
		return batteryTemperature;
	}

	public double getMotorTemperature() {
		return motorTemperature;
	}

	public void overheatBattery() {
		this.batteryTemperature = MAX_BATTERY_TEMP + 10;
	}
	
	public void overheatMotor() {
		this.motorTemperature = MAX_MOTOR_TEMP + 20;
	}
	
	public boolean isSafeTemperature() {
		return batteryTemperature <= MAX_BATTERY_TEMP && motorTemperature <= MAX_MOTOR_TEMP;
	}
	
	public void resetTemperatures() {
		this.batteryTemperature = 30.0;
		this.motorTemperature = 35.0;
	}
}