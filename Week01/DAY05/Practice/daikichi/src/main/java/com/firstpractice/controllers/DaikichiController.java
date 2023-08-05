package com.firstpractice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaikichiController {
	
	@RequestMapping("/")
	public String home() {
		return "Hello";
	}
	
	@RequestMapping("/daikichi")
	public String daiki() {
		return "Welcome";
	}
	
	@RequestMapping("/daikichi/today")
	public String daikiToday() {
		return "Today you will find luck in all your endeavors!";
	}
	
	@RequestMapping("/daikichi/tomorrow")
	public String daikiTomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	
}
