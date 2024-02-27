package com.mx.test.spring.controller;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TrajectoriesRepository extends JpaRepository<Trajectories, Integer> {
	@Query(value = "SELECT * FROM Trajectories WHERE taxi_id = ? AND TO_CHAR(date, 'yyyy-MM-dd') like ?", nativeQuery = true)
	public Page<Trajectories> findAllPaginationTrajectories(Integer id, String date, Pageable pageable);
	
	}

