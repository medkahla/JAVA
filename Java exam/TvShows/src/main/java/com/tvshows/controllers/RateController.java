package com.tvshows.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tvshows.models.Rate;
import com.tvshows.models.Show;
import com.tvshows.models.User;
import com.tvshows.services.RateService;
import com.tvshows.services.ShowService;
import com.tvshows.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class RateController {

	@Autowired
	private RateService rateServ;
	@Autowired
	private ShowService showServ;
	@Autowired
	private UserService userServ;
	
	@PostMapping("/shows/{showId}")
	public String addRate(@Valid @ModelAttribute("rate") Rate rate, BindingResult res, HttpSession session,
							Model model, @PathVariable("showId") Long showId) {
		
		if (res.hasErrors()) {
			return "/Shows/displayShow.jsp";
		} else {
			Long userId = (Long) session.getAttribute("user_id");
			User userIn = userServ.findById(userId);
			rate.setPoster(userIn);
			Show thisShow = showServ.findShow(showId);
			rate.setShow(thisShow);
			rate.setRate(Integer.valueOf(rate.getRate()));
			rateServ.saveRate(rate);
			return "redirect:/shows/"+thisShow.getId();
		}
	}
	
}
