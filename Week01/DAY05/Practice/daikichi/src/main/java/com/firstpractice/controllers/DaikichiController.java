package com.firstpractice.controllers;

import java.util.Iterator;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaikichiController {
	
	//Hello Human Practice Assignment
	@RequestMapping("/")
	public String home(@RequestParam(value="name", required=false) String name,
						@RequestParam(value="last_name", required=false) String last_name,
						 @RequestParam(value="time", required=false) int time) {
		
		String msg = "";
		if (time>0) {
			for (int i = 1	; i<=time ; i++) {
				msg += name + " " + last_name + " ";
			}			
		}
		if (name == null & last_name == null) {
			return "Hello Human";
		}
		return "Hello "+ msg;
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
	
	@RequestMapping("/daikichi/travel/{place}")
	public String daikiTravel(@PathVariable("place") String place) {
		return "Congratulations! You will soon travel to "+place;
		
	}
	
	@RequestMapping("/daikichi/lotto/{numb}")
	public String daikiTravel(@PathVariable("numb") int numb) {
		if (numb % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}
		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		
	}
	
}
