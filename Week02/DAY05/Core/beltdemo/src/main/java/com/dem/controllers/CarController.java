package com.dem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.dem.models.Car;
import com.dem.models.User;
import com.dem.services.CarService;
import com.dem.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class CarController {
	
    @Autowired
    private UserService userServ;
    @Autowired
    private CarService carServ;
    
    @GetMapping("/home")
    public String homePage(@ModelAttribute("car") Car car, HttpSession session, Model model) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if(userId == null) {
    		return "redirect:/";
    	}else {
    		List<Car> listCars = carServ.allCars();
    		model.addAttribute("listCars",listCars);
    		User userIn = userServ.findOne(userId);
    		model.addAttribute("userIn",userIn);
    		return "home.jsp";
    	}	
    }
    
    @PostMapping("/cars")
    public String makeCars(@Valid @ModelAttribute("car") Car car, BindingResult res, HttpSession session,
    						Model model) {
    	if(res.hasErrors()) {
    		List<Car> listCars = carServ.allCars();
    		model.addAttribute("listCars",listCars);
    		return "home.jsp";
    	}else {
    		Long userId = (Long) session.getAttribute("user_id");
    		User userIn = userServ.findOne(userId);
    		car.setDriver(userIn);
    		carServ.createCar(car);
    		return "redirect:/home";
    	}
    }
    
    @GetMapping("/cars/{id}/edit")
    public String editCar(@ModelAttribute("car") Car car, HttpSession session,
    						@PathVariable("id") Long carId, Model model) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if(userId == null) {
    		return "redirect:/";
    	}else {
    		Car carToUpdate = carServ.findCar(carId);
    		model.addAttribute("car",carToUpdate);
    		return "edit.jsp";
    	}	
    }
    
    @PutMapping("/cars/{id}/edit")
    public String updateCar(@Valid @ModelAttribute("car") Car car, BindingResult res,
    							Model model, HttpSession session, @PathVariable("id") Long id) {
    	if(res.hasErrors()) {
    		return "edit.jsp";
    	}else {
    		Car oldCar = carServ.findCar(id);
    		car.setDriver(oldCar.getDriver());
    		carServ.updateCar(car);
    		return "redirect:/home";
    	}
    }
    
    @DeleteMapping("/cars/{id}/delete")
    public String destroy (@PathVariable("id") Long carId) {
    	carServ.deleteCar(carId);
    	return "redirect:/home";
    }
    
    @GetMapping("/cars/{id}/show")
    public String showCar(@ModelAttribute("car") Car car, HttpSession session,
    						@PathVariable("id") Long carId, Model model) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if(userId == null) {
    		return "redirect:/";
    	}else {
    		Car thisCar = carServ.findCar(carId);
    		model.addAttribute("car",thisCar);
    		return "showone.jsp";
    	}	
    }
}
