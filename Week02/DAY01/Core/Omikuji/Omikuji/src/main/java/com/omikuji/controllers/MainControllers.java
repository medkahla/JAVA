package com.omikuji.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainControllers {
	
	@RequestMapping("/omikuji")
	public String main() {
		return "mainPage.jsp";
	}
	
	@RequestMapping(value="/process", method = RequestMethod.POST)
	public String hundleForm(@RequestParam("num") int num,
								@RequestParam("city") String city,
								@RequestParam("person") String person,
								@RequestParam("thing") String thing,
								@RequestParam("hobby") String hobby,
								@RequestParam("nice") String nice
								,HttpSession session) {
		session.setAttribute("num", num);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("thing", thing);
		session.setAttribute("hobby", hobby);
		session.setAttribute("nice", nice);
		
		return "redirect:/omikuji/show";
	}
	
	@RequestMapping("/omikuji/show")
	public String show() {
		return "show.jsp";
	}
}
