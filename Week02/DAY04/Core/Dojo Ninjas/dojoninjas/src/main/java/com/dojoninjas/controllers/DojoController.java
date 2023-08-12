package com.dojoninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojoninjas.models.Dojo;
import com.dojoninjas.services.DojoService;
import com.dojoninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	
	@Autowired
	private DojoService dojoServ;
	
	@Autowired
	private NinjaService ninjaServ;
	
	@GetMapping("/")
	public String homePage(Model model, @ModelAttribute("dojo") Dojo dojo) {
			List<Dojo> allDojos = dojoServ.allDojos();
			model.addAttribute("dojos",allDojos);
		return "index.jsp";
	}
	
	@PostMapping("/new")
    public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result,
							Model m) {
		if (result.hasErrors()) {
		List<Dojo> allDojos = dojoServ.allDojos();
		m.addAttribute("dojos",allDojos);
		return "index.jsp";
		} else {
			dojoServ.createDojo(dojo);
		return "redirect:/";
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String showOneDojo(@PathVariable("id") Long id, Model model) {
		Dojo thisDojo = dojoServ.findDojo(id);
		model.addAttribute("dojo",thisDojo);
		return "oneDojo.jsp";
	}
	
	
	
}
