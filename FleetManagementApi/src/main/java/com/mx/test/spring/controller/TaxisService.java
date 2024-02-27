package com.mx.test.spring.controller;

import java.util.List;

import org.springframework.data.domain.Page;

public interface TaxisService {
	
	Taxis createTaxis(Taxis id);//Firma de metodo 
	
	Taxis getTaxisById(Integer Plate);
	
	List<Taxis> getAllTaxis();
	
	Taxis updateTaxis(Taxis id);
	
	void deleteTaxis(Integer id);
	
    Page<Taxis> findAllPagination(Integer id);

}
	