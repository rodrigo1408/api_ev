package com.xresult.api_ev.services;

import org.springframework.stereotype.Service;

import com.xresult.api_ev.enums.DrivingMode;

@Service
public class DrivingModeService {

	private DrivingMode currentMode;

	public DrivingModeService() {
		this.currentMode = DrivingMode.NORMAL;
	}

	public void setDrivingMode(DrivingMode mode) {
		this.currentMode = mode;
	}

	public double adjustPowerByMode(double basePower) {
		switch (currentMode) {
		case ECO:
			return basePower * 0.7;
		case SPORT:
			return basePower * 1.2;
		case NORMAL:
		default:
			return basePower;
		}
	}
}
