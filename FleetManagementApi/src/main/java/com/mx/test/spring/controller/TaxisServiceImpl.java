package com.mx.test.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TaxisServiceImpl implements TaxisService {
	public TaxisServiceImpl() {
		
	}
	@Autowired	
	public TaxisRepository taxisRepository;
	
	@Override
	public Taxis createTaxis(Taxis id) {
		return taxisRepository.save(id);
	}

	@Override
	public Taxis getTaxisById(Integer Plate) {
		Optional<Taxis> optionalTaxis = taxisRepository.findById(Plate);
		return optionalTaxis.get();
	}

	@Override
    public List<Taxis> getAllTaxis() {
        return taxisRepository.findAll();
    }

	@Override
	public Taxis updateTaxis(Taxis updatedTaxi) {
	  
		Taxis existingTaxi = taxisRepository.findById(updatedTaxi.getId()).get();
		existingTaxi.setId(updatedTaxi.getId());
		existingTaxi.setPlate(updatedTaxi.getPlate());
		Taxis updatedTaxis = taxisRepository.save(existingTaxi);
        return updatedTaxis;

	    }


	@Override
	public void deleteTaxis(Integer id) {
		taxisRepository.deleteById(id);;
	}

	@Override
	public Page<Taxis> findAllPagination(Integer id) {
		Sort sort = Sort.by(Sort.Direction.ASC, "id");	
		Pageable pageable = PageRequest.of(id, 10, sort);
		return taxisRepository.findAll(pageable);
		
	}

}
