package com.saveTravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saveTravels.Models.Travel;

@Repository
public interface TravelRepo extends CrudRepository<Travel, Long> {
	List<Travel> findAll();
}
