package com.xresult.api_ev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnosticService {

	@Autowired
	private BatteryService batt;
	
	@Autowired
	private TemperatureService temp;
	
	public String perfomDiagnostics() {
		StringBuilder diagnosticReport = new StringBuilder();
		
		if(batt.getBatteryStatus().getChargeLevel() < 20.0) {
			diagnosticReport.append("Alerta: Bateria com carga baixa!\n");
		}
		
		if(!temp.isSafeTemperature()) {
			diagnosticReport.append("Alerta: Sistema superaquecido!\n");
		}
		
		if(diagnosticReport.length() == 0) {
			diagnosticReport.append("Sistema funcionando normalmente.");
		}
		
		return perfomDiagnostics().toString();
	}	
}