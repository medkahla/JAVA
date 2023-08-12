package com.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojoninjas.models.Ninja;
import com.dojoninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	@Autowired
	private NinjaRepository ninjaRep;
	
	//READ ALL
	public List<Ninja> allNinjas(){
		return ninjaRep.findAll();
	}
	
	//CREATE
	public Ninja createNinja(Ninja n) {
		return ninjaRep.save(n);
	}
	
	//READ ONE
	public Ninja findNinja(Long id) {
		Optional<Ninja> maybeNinja = ninjaRep.findById(id);
		if (maybeNinja.isPresent()) {
			return maybeNinja.get();
		} else {
			return null;
		}
	}
}
