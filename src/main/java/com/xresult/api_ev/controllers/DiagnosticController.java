package com.xresult.api_ev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xresult.api_ev.services.DiagnosticService;

@RestController
@RequestMapping("/api")
public class DiagnosticController {

	@Autowired
	private DiagnosticService diag;

	@GetMapping("/diagnostics")
	public String perfomDiagnostics() {
		return diag.perfomDiagnostics();
	}
}
