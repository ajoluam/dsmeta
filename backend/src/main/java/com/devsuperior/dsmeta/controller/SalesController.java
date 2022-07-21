package com.devsuperior.dsmeta.controller;

import java.util.List;

import com.devsuperior.dsmeta.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.service.SalesService;

@RestController
@RequestMapping(value="sales")
public class SalesController {
	
	@Autowired
	private SalesService service;

	@Autowired
	private SmsService smsService;

	@GetMapping()
	public Page<Sale> findSales (
			@RequestParam(value = "dataMinima", defaultValue = "") String minDate,
			@RequestParam(value = "dataMaxima", defaultValue = "") String maxDate,
			Pageable pageable) {
		
		return service.findSales(minDate, maxDate, pageable);
		
	}
	
	@GetMapping(value = "/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}

}
