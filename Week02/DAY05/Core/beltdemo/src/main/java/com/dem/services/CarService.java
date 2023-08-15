package com.dem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dem.models.Car;
import com.dem.repositories.CarRepository;

@Service
public class CarService {
	// === CRUD ===
	
		@Autowired
		private CarRepository carRepo;
		
		// READ ALL
		public List<Car> allCars(){
			return carRepo.findAll();
		}
		
		// CREATE
		public Car createCar(Car b) {
			return carRepo.save(b);
		}
		
		// READ ONE
		public Car findCar(Long id) {
			
			Optional<Car> maybeCar = carRepo.findById(id);
			if(maybeCar.isPresent()) {
				return maybeCar.get();
			}else {
				return null;
			}
		}
		
		// UPDATE 
		public Car updateCar(Car b) {
			return carRepo.save(b);
		}
		
		// DELETE
		public void deleteCar(Long id) {
			carRepo.deleteById(id);
		}
}
