package com.xresult.api_ev.services;

import org.springframework.stereotype.Service;

@Service
public class SpeedControlService {

	private static final double MAX_SPEED = 150.0;
	private static final double MAX_POWER = 80.0;
	
	public double calculateSpeed(double power) {
		return(power / MAX_POWER ) * MAX_SPEED;
	}		
}
