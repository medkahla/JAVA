package com.saveTravels.Controllers;

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

import com.saveTravels.Models.Travel;
import com.saveTravels.services.TravelService;

import jakarta.validation.Valid;

@Controller
public class TravelController {
	
	@Autowired
	private TravelService travelServ;
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("travel") Travel travel) {
		List<Travel> allTheTravels = travelServ.allTravels();
		model.addAttribute("travelsList",allTheTravels);
		return "index.jsp";
	}
	
    @PostMapping("/new")
    public String create(@Valid @ModelAttribute("travel") Travel travel, BindingResult result,
    						Model m) {
        if (result.hasErrors()) {
    		List<Travel> allTheTravels = travelServ.allTravels();
    		m.addAttribute("travelsList",allTheTravels);
            return "index.jsp";
        } else {
            travelServ.createTravel(travel);
            return "redirect:/";
        }
    }
    
    @GetMapping("/expenses/{id}")
    public String showOne(@PathVariable("id") Long id, Model model) {
    	Travel thisExpense = travelServ.oneTravel(id);
    	model.addAttribute("thisExpense",thisExpense);
    	return "showOne.jsp";
    }
    
    @GetMapping("expenses/edit/{id}")
    public String editOne(@PathVariable("id") Long id, Model model) {
    	Travel travel = travelServ.oneTravel(id);
    	model.addAttribute("travel",travel);
    	return "edit.jsp";
    }
    
    @PutMapping("/expenses/edit/{id}")
    public String updateExpense(@Valid @ModelAttribute("travel") Travel travel, BindingResult result) {
    	if (result.hasErrors()) {
    		return "edit.jsp";
		}else {
			travelServ.updateTravel(travel);
			return "redirect:/";
		}
    }
    
    @DeleteMapping("/travel/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
        travelServ.deleteTravel(id);
        return "redirect:/";
    }
    
    
}
