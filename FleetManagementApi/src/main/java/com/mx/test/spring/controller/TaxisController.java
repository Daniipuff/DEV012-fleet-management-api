package com.mx.test.spring.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/taxis")
public class TaxisController {
	
	public TaxisController() {
		
	}
	@Autowired
	private TaxisService taxisService;

	@PostMapping
    public ResponseEntity<Taxis> createTaxis(@RequestBody Taxis taxis){
        Taxis savedTaxis = taxisService.createTaxis(taxis);
        return new ResponseEntity<>(savedTaxis, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Taxis>> getAllTaxis(@PageableDefault(page = 0, size = 20)Pageable pageable){
        List<Taxis> taxis = taxisService.getAllTaxis();
        return new ResponseEntity<>(taxis, HttpStatus.OK);
    }
	
	@GetMapping("{id}")
    public ResponseEntity<Taxis> getTaxisById(@PathVariable("id") Integer id){
        Taxis taxis = taxisService.getTaxisById(id);
        return new ResponseEntity<>(taxis, HttpStatus.OK);
    }
	

    
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<Taxis> updateTaxis(@PathVariable("id") Integer id,
                                           @RequestBody Taxis taxis){
    	taxis.setId(id);
        Taxis updatedTaxis = taxisService.updateTaxis(taxis);
        return new ResponseEntity<>(updatedTaxis, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTaxis(@PathVariable("id") Integer id){
        taxisService.deleteTaxis(id);
        return new ResponseEntity<>("Taxi successfully deleted!", HttpStatus.OK);
    }
    
    @GetMapping("/page/")  //    List<Taxis> findAllPagination();
    public ResponseEntity<Page<Taxis>> findAllPage(@RequestParam Integer page){
    	Page<Taxis> page2 = taxisService.findAllPagination(page);
    	return new ResponseEntity<> (page2, HttpStatus.OK);
    }
    
}
