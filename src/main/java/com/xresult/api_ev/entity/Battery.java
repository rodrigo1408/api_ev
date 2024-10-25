package com.xresult.api_ev.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Battery { 
	private double voltage;
	private double current;
	private double chargeLevel;
	
	
	public Battery(double voltage, double current, double chargeLevel) {
		this.voltage = voltage;
		this.current = current;
		this.chargeLevel = chargeLevel;
	}
	
	public double getVoltage() {
		return voltage;
	}
	public void setVoltage(double voltage) {
		this.voltage = voltage;
	}
	public double getCurrent() {
		return current;
	}
	public void setCurrent(double current) {
		this.current = current;
	}
	public double getChargeLevel() {
		return chargeLevel;
	}
	public void setChargeLevel(double chargeLevel) {
		this.chargeLevel = chargeLevel;
	}
}
