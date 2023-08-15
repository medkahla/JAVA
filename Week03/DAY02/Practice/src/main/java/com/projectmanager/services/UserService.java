package com.projectmanager.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.projectmanager.models.Project;
import com.projectmanager.models.LoginUser;
import com.projectmanager.models.User;
import com.projectmanager.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        Optional<User> maybeTaken= userRepo.findByEmail(newUser.getEmail());
        if(maybeTaken.isPresent()) {
        	result.rejectValue("email", "registraterError", "Invalid credentials!");
        }
        if(!newUser.getPassword().equals(newUser.getConfirm())){
        	result.rejectValue("password", "registraterError", "Invalid credentials!");
        }
        if(result.hasErrors()) {
        	return null;
        }else {
        	String hashedPwd = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        	newUser.setPassword(hashedPwd);
        	return userRepo.save(newUser);
        }
    }
    
    public User login(LoginUser newLoginObject, BindingResult result) {
    	Optional<User> maybeUser= userRepo.findByEmail(newLoginObject.getEmail());
        if(!maybeUser.isPresent()) {
        	result.rejectValue("email", "loginError", "Email is not found");
        }else {
        	User user = maybeUser.get();
        	if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
        		result.rejectValue("password", "loginError", "Invalid Password");
        	}
        	if(result.hasErrors()) {
        		return null;
        	}else {
        		return user;
        	}
        }
    	
        return null;
    }

	public User findOne(Long id) {
		
		Optional<User> maybeUser = userRepo.findById(id);
		if(maybeUser.isPresent()) {
			return maybeUser.get();
		}else {
			return null;
		}
	}
}
