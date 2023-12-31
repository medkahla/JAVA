package com.tvshows.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tvshows.models.User;
import java.util.List;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByEmail(String email);
	
	Optional<User> findByUserName(String userName);
}
