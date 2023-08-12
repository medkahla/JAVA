package com.dojoninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojoninjas.models.Dojo;
import com.dojoninjas.models.Ninja;
import com.dojoninjas.services.DojoService;
import com.dojoninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	
	@Autowired
	private DojoService dojoServ;
	@Autowired
	private NinjaService ninjaServ;
	
	@GetMapping("/ninja/add")
	public String addNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {
		List<Dojo> allDojos = dojoServ.allDojos();
		model.addAttribute("dojos",allDojos);
		return "addNinja.jsp";
	}
	
    @PostMapping("ninja/add")
    public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result,
    						Model m) {
        if (result.hasErrors()) {
        	List<Dojo> allDojos = dojoServ.allDojos();
    		m.addAttribute("dojos",allDojos);
    		return "addNinja.jsp";
        } else {
        	ninjaServ.createNinja(ninja);
            return "redirect:/";
        }
    }
}
