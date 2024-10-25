package com.xresult.api_ev.entity;
 
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MotorStatus { 
	 
	private double power;
	private double throttlePosition;
	
	public MotorStatus(double power, double throttlePosition) {
		this.power = power;
		this.throttlePosition = throttlePosition;
	}
	
	public double getPower() {
		return power;
	}
	public void setPower(double power) {
		this.power = power;
	}
	public double getThrottlePosition() {
		return throttlePosition;
	}
	public void setThrottlePosition(double throttlePosition) {
		this.throttlePosition = throttlePosition;
	}
}
