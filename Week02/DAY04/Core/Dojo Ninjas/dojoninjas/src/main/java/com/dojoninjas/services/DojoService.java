package com.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojoninjas.models.Dojo;
import com.dojoninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepository dojoRep;
	
	//READ ALL
	public List<Dojo> allDojos(){
		return dojoRep.findAll();
	}
	
	//CREATE
	public Dojo createDojo(Dojo d) {
		return dojoRep.save(d);
	}
	
	//READ ONE
	public Dojo findDojo(Long id) {
		Optional<Dojo> maybeDojo = dojoRep.findById(id);
		if (maybeDojo.isPresent()) {
			return maybeDojo.get();
		} else {
			return null;
		}
	}
}
