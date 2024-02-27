package com.mx.test.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrajectoriesServiceImpl implements TrajectoriesService {
	public  TrajectoriesServiceImpl() {
		
	}
	@Autowired
	private TrajectoriesRepository trajectoriesRepository;

	@Override
	public Trajectories createTrajectories(Trajectories trajectories) {
		return trajectoriesRepository.save(trajectories);
	}

	@Override
	public Trajectories getTrajectoriesById(Integer id) {
		Optional<Trajectories> optionalTrajectories = trajectoriesRepository.findById(id);
		return optionalTrajectories.get();
	}

	@Override
	public List<Trajectories> getAllTrajectories() {
		 return trajectoriesRepository.findAll();
	}

	@Override
	public Trajectories updateTrajectories(Trajectories trajectories) {
		Trajectories existingTrajectories = trajectoriesRepository.findById(trajectories.getId()).get();
		existingTrajectories.setId(trajectories.getId());
		existingTrajectories.setTaxi_id(trajectories.getTaxi_id());
		existingTrajectories.setDate(trajectories.getDate());
		existingTrajectories.setLatitude(trajectories.getLatitude());
		existingTrajectories.setLongitude(trajectories.getLongitude());
		Trajectories updatedTrajectories = trajectoriesRepository.save(existingTrajectories);
		
		return updatedTrajectories;
	}

	@Override
	public void deleteTrajectories(Integer id) {
		trajectoriesRepository.deleteById(id);
		
	}
}