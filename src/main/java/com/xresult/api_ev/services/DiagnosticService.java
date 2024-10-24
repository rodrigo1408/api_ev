package com.xresult.api_ev.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnosticService {

	private static final Logger logger = LoggerFactory.getLogger(DiagnosticService.class);
	
	@Autowired
	private BatteryService batt;
	
	@Autowired
	private TemperatureService temp;
	
	public String perfomDiagnostics() {
		StringBuilder diagnosticReport = new StringBuilder();
		
		if(batt.getBatteryStatus().getChargeLevel() < 20.0) {
			logger.info("Alerta: Bateria com carga baixa!\n");
			diagnosticReport.append("Alerta: Bateria com carga baixa!\n");
		}
		
		if(!temp.isSafeTemperature()) {
			logger.info("Alerta: Sistema superaquecido!\n");
			diagnosticReport.append("Alerta: Sistema superaquecido!\n");
		}
		
		if(diagnosticReport.length() == 0) {
			logger.info("Sistema funcionando normalmente.");
			diagnosticReport.append("Sistema funcionando normalmente.");
		}
		
		return diagnosticReport.toString();
	}	
}