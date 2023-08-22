package com.tvshows.controllers;

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

import com.tvshows.models.Rate;
import com.tvshows.models.Show;
import com.tvshows.models.User;
import com.tvshows.services.RateService;
import com.tvshows.services.ShowService;
import com.tvshows.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ShowController {

	@Autowired
	private ShowService showServ;
	@Autowired
	private UserService userServ;
	@Autowired
	private RateService rateServ;


	// Dashboard--> Display all shows
	@GetMapping("/shows")
	public String homePage(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		if (userId == null) {
			return "redirect:/";
		} else {
			User userIn = userServ.findById(userId);
			model.addAttribute("userIn", userIn);
			List<Show> listShows = showServ.allShows();
			//Adding AVG rate
				for (Show show : listShows) {
					if(show.getReviews().size()>0){				
						float sum = 0;
						int count = 0;
							for (Rate review : show.getReviews()) {
								count++;
								sum += review.getRate();
							}
						float avg = (float) sum / count;
						show.setAvgRate(avg);
					}else {
						show.setAvgRate(0);
					}
			}
			model.addAttribute("listShows", listShows);
			return "home.jsp";
		}
	}

	// Form to add new show
	@GetMapping("/shows/new")
	public String addShow(@ModelAttribute("show") Show show, HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		if (userId == null) {
			return "redirect:/";
		} else {
			return "/Shows/newShow.jsp";
		}
	}

	// Handle adding new show
	@PostMapping("/shows/new")
	public String craeteShow(@Valid @ModelAttribute("show") Show show, BindingResult res, HttpSession session,
			Model model) {
		if (res.hasErrors()) {
			return "/Shows/newShow.jsp";
		} else {
			Long userId = (Long) session.getAttribute("user_id");
			User userIn = userServ.findById(userId);
			show.setPoster(userIn);
			showServ.createShow(show, res);
			if (res.hasErrors()) {
				return "/Shows/newShow.jsp";
			} else {
				return "redirect:/shows";
			}
		}
	}

	// Display one Show
	@GetMapping("/shows/{id}")
	public String displayShow(@ModelAttribute("show") Show show, @ModelAttribute("rate") Rate rate, HttpSession session,
			@PathVariable("id") Long showId, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		if (userId == null) {
			return "redirect:/";
		} else {
			User userIn = userServ.findById(userId);
			model.addAttribute("userIn", userIn);
			Show thisShow = showServ.findShow(showId);
			model.addAttribute("show", thisShow);
			List<Rate> listRates = rateServ.thisShowReviews(thisShow);
			model.addAttribute("listRates", listRates);
			return "/Shows/displayShow.jsp";
		}
	}
    
    //Display form to update a show
    @GetMapping("/shows/{id}/edit")
    public String editShow(@ModelAttribute("show") Show show, HttpSession session,
    						@PathVariable("id") Long showId, Model model) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if(userId == null) {
    		return "redirect:/";
    	}else {
    			Show showToUpdate = showServ.findShow(showId);
    			if(showToUpdate.getPoster().getId()==userId) {
    				model.addAttribute("show",showToUpdate);
    				return "/Shows/editShow.jsp";    				
    			}else {
    				return "redirect:/shows";
    			}
    	}	
    }
    
    //Handling the update of a project
    @PutMapping("/shows/{id}/edit")
    public String updateShow(@Valid @ModelAttribute("show") Show show, BindingResult res,
    							Model model, HttpSession session, @PathVariable("id") Long id) {
    	if(res.hasErrors()) {
    		return "/Shows/editShow.jsp";
    	}else {
    		Show oldShow = showServ.findShow(id);
    		show.setPoster(oldShow.getPoster());
    		show.setReviews(oldShow.getReviews());
    		showServ.updateShow(show);
    		return "redirect:/shows";
    	}
    }
    
	// Delete a show
	@DeleteMapping("/show/{id}/delete")
	public String destroy(@PathVariable("id") Long showId) {
		Show thisShow = showServ.findShow(showId);
		if(thisShow.getReviews().size()>0) {
			System.out.println("you can't delete this cause of the relationship");
			return "redirect:/shows";	
		}else {
			showServ.deleteShow(showId);
			return "redirect:/shows";			
		}
		
	}

}
