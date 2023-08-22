package com.tvshows.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.tvshows.models.Show;
import com.tvshows.repositories.ShowRepository;

@Service
public class ShowService {

	// === CRUD ===
	@Autowired
	private ShowRepository showRepo;
	
	// READ ALL
	public List<Show> allShows(){
		return showRepo.findAll();
	}
	
	// CREATE
	public Show createShow(Show b, BindingResult result) {
        //Verify Unique TITLE
        Optional<Show> maybeTitleTaken= showRepo.findByTitle(b.getTitle());
        if(maybeTitleTaken.isPresent()) {
        	result.rejectValue("title", "registraterError", "This title is already present!");
        	return null;
        }else {
        	return showRepo.save(b);        	
        }
	}
	
	// READ ONE
	public Show findShow(Long id) {
		
		Optional<Show> potentielShow = showRepo.findById(id);
		if(potentielShow.isPresent()) {
			return potentielShow.get();
		}else {
			return null;
		}
	}
	
	// UPDATE 
	public Show updateShow(Show b) {
        	return showRepo.save(b);        	
	}
	
	// DELETE
	public void deleteShow(Long id) {
		showRepo.deleteById(id);
	}
}
