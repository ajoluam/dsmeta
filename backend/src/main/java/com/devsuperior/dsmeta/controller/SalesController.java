package com.devsuperior.dsmeta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.service.SalesService;

@RestController
@RequestMapping(value="sales")
public class SalesController {
	
	@Autowired
	private SalesService service;
	
	@GetMapping(value = "page")
	public Page<Sale> findSales (
			@RequestParam(value = "dataMinima", defaultValue = "") String minDate,
			@RequestParam(value = "dataMaxima", defaultValue = "") String maxDate,
			Pageable pageable) {
		
		return service.findSales(minDate, maxDate, pageable);
		
	}
	
	@GetMapping
	public List<Sale> findAllSales(){
		return service.findAllSales();
	}

}
