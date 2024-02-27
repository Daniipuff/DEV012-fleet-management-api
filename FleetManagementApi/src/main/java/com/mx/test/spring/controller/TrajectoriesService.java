package com.mx.test.spring.controller;

import java.util.List;

public interface TrajectoriesService {
	
	public Trajectories createTrajectories(Trajectories trajectories);
	
	public Trajectories getTrajectoriesById(Integer id);
	
	public List<Trajectories> getAllTrajectories();
	
	public Trajectories updateTrajectories(Trajectories trajectories);
	
	void deleteTrajectories(Integer id);
	
}
