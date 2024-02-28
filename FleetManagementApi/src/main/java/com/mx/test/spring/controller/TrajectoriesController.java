package com.mx.test.spring.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("api/trajectories")
public class TrajectoriesController {
	public TrajectoriesController() {
		
	}
	@Autowired
    private TrajectoriesService trajectoriesService;
	@Autowired
	private TrajectoriesRepository trajectoriesRepository;
    
    @PostMapping
    public ResponseEntity<Trajectories> createTrajectories(@RequestBody Trajectories trajectories){
        Trajectories savedTrajectories = trajectoriesService.createTrajectories(trajectories);
        return new ResponseEntity<>(savedTrajectories, HttpStatus.CREATED);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Trajectories> getTrajectoriesById(@PathVariable("id") Integer id){
        Trajectories trajectories = trajectoriesService.getTrajectoriesById(id);
        return new ResponseEntity<>(trajectories, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Trajectories>> getAllTrajectories(){
    	List<Trajectories> trajectories = trajectoriesService.getAllTrajectories();
        return new ResponseEntity<>(trajectories, HttpStatus.OK);
    }
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<Trajectories> updateTrajectories(@PathVariable("id") Integer id,
                                           @RequestBody Trajectories trajectories){
        trajectories.setId(id);
        Trajectories updatedTrajectories = trajectoriesService.updateTrajectories(trajectories);
        return new ResponseEntity<>(updatedTrajectories, HttpStatus.OK);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTrajectoires(@PathVariable("id") Integer id){
        trajectoriesService.deleteTrajectories(id);
        return new ResponseEntity<>("Trajectori successfully deleted!", HttpStatus.OK);
    }
    @GetMapping("/page/")  //   Page<Trajectories> findAllPaginationTrajectories(Integer id);
    public ResponseEntity<Page<Trajectories>> findAllPage(@RequestParam Integer taxi_id,
    		@RequestParam String dateIn, @RequestParam Integer page){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Sort sort = Sort.by(Sort.Direction.ASC, "id");	
		Pageable pageable = PageRequest.of(page, 10, sort);
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date parsedDate = dateFormat.parse(dateIn, new ParsePosition(0));
		Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
		Page<Trajectories> page2 = trajectoriesRepository.findAllPaginationTrajectories(taxi_id,dateIn, pageable);
    	return new ResponseEntity<> (page2, HttpStatus.OK);
    }
}