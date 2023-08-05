package com.displaydate.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateControllers {
	
	@RequestMapping("/")
	public String homePage() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String datePage(Model model) {
		DateFormat dateFormat = new SimpleDateFormat("E, MMMM MM ,yyyy");
		Date date = new Date();
		model.addAttribute("date" , dateFormat.format(date));
		return "datePage.jsp";
	}
	
	@RequestMapping("/time")
	public String timePage(Model model) {
		DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
		Date date = new Date();
		model.addAttribute("time" , dateFormat.format(date));
		return "timePage.jsp";
	}
}
