package com.tvshows.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tvshows.models.Rate;
import com.tvshows.models.Show;


@Repository
public interface RateRepository extends CrudRepository<Rate, Long> {
	
	List<Rate> findByShowOrderByRateAsc(Show show);
	
}
