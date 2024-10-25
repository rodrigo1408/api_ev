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
			String message = String.format("Alert: Low battery down!");
		    logger.info(message);
		    
		    return message;
		}
		
		if(!temp.isSafeTemperature()) {
			String message = String.format("Alert: Overheating system!");
			logger.info(message);
			
			return(message);
		}
		
		if(diagnosticReport.length() == 0) {
			String message = String.format("System working normally.");
			logger.info(message);
			
			return(message);
		}
		
		return diagnosticReport.toString();
	}	
}