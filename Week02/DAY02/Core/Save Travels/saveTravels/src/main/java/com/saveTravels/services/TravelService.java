package com.saveTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saveTravels.Models.Travel;
import com.saveTravels.repositories.TravelRepo;

@Service
public class TravelService {
	
	@Autowired
	private TravelRepo travelRepo;
	
	public List<Travel> allTravels(){
		return travelRepo.findAll();
	}
	
	public Travel createTravel(Travel t) {
		return travelRepo.save(t);
	}
	
	public Travel updateTravel(Travel t) {
		return travelRepo.save(t);
	}
	
	public void deleteTravel(Long id) {
		travelRepo.deleteById(id);
	}
	
	public Travel oneTravel(Long id) {
		Optional<Travel> oneFoundTravel = travelRepo.findById(id);
		if(oneFoundTravel.isPresent()) {
			return oneFoundTravel.get();
		}else {
			return null;
		}
	}
	
}
