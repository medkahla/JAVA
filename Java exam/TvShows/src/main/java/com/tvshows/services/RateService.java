package com.tvshows.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvshows.models.Rate;
import com.tvshows.models.Show;
import com.tvshows.repositories.RateRepository;

@Service
public class RateService {
	
	@Autowired
	private RateRepository rateRepo;
	
	// READ ALL FOR ONE SHOW
	public List<Rate> thisShowReviews(Show show){
		return rateRepo.findByShowOrderByRateAsc(show);
	}
	
	// CREATE
	public Rate saveRate(Rate b) {
		return rateRepo.save(b);
	}
}
