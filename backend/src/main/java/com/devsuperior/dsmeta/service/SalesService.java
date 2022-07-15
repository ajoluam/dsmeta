package com.devsuperior.dsmeta.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repository.SalesRepository;

@Service
public class SalesService {
	
	@Autowired
	private SalesRepository repository;
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		LocalDate min = minDate.equals("") ? LocalDate.now().minusYears(1L) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? LocalDate.now() : LocalDate.parse(maxDate);


		return repository.findSales(min, max, pageable);
	}
	
	public List<Sale> findAllSales() {
		return repository.findAll();
	}
}
