package com.devsuperior.dsmeta.controller;

import java.time.LocalDate;
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
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

@RestController
@RequestMapping(value="sales")
public class SalesController {
	
	@Autowired
	private SalesService service;
	
	@GetMapping(value = "page")
	public Page<Sale> findSales (
			@RequestParam(name = "dataMinima") String min, 
			@RequestParam(name = "dataMaxima") String max) {
		
		return service.findSales(LocalDate.parse(min), LocalDate.parse(max), Pageable.unpaged());
		
	}
	
	@GetMapping
	public List<Sale> findAllSales(){
		return service.findAllSales();
	}

}
