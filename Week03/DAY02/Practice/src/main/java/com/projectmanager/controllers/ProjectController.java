package com.projectmanager.controllers;

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

import com.projectmanager.models.Project;
import com.projectmanager.models.User;
import com.projectmanager.services.ProjectService;
import com.projectmanager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class ProjectController {
	
    @Autowired
    private UserService userServ;
    @Autowired
    private ProjectService projectServ;
    
    //Main route to the Dashboard - pointing after connection
    @GetMapping("/dashboard")
    public String homePage(@ModelAttribute("project") Project project, HttpSession session, Model model) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if(userId == null) {
    		return "redirect:/";
    	}else {
    		List<Project> listProjects = projectServ.allProjects();
    		model.addAttribute("projectsList",listProjects);
    		User userIn = userServ.findOne(userId);
    		model.addAttribute("userIn",userIn);
    		return "home.jsp";
    	}	
    }
    
    // Form to add new project
    @GetMapping("/projects/new")
    public String addProject(@ModelAttribute("project") Project project, HttpSession session) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if(userId == null) {
    		return "redirect:/";
    	}else {
    		return "/projects/newProject.jsp";
    	}	
    }
    // Handle adding new project
    @PostMapping("/projects/new")
    public String makeProjects(@Valid @ModelAttribute("project") Project project, BindingResult res, HttpSession session,
    						Model model) {
    	if(res.hasErrors()) {
    		return "/projects/newProject.jsp";
    	}else {
    		Long userId = (Long) session.getAttribute("user_id");
    		User userIn = userServ.findOne(userId);
    		project.setLeader(userIn);
    		projectServ.createProject(project);
    		return "redirect:/dashboard";
    	}
    }
    
    //Joining a team
    @GetMapping("/jointheteam/{id}")
    public String joinTeam(HttpSession session, @PathVariable("id") Long projectId ) {
		
    	Long userId = (Long) session.getAttribute("user_id");
		User userIn = userServ.findOne(userId);
		
		Project thisProject = projectServ.findProject(projectId);
		thisProject.getTeamMembers().add(userIn);
		
		projectServ.updateProject(thisProject);
		
		return "redirect:/dashboard";
    }
    
    //leaving a team
    @GetMapping("/leavetheteam/{id}")
    public String leaveTeam(HttpSession session, @PathVariable("id") Long projectId ) {
		
    	Long userId = (Long) session.getAttribute("user_id");
		User userIn = userServ.findOne(userId);
		
		Project thisProject = projectServ.findProject(projectId);
		thisProject.getTeamMembers().remove(userIn);
		
		projectServ.updateProject(thisProject);
		
		return "redirect:/dashboard";
    }
    
    //Display form to update a project
    @GetMapping("/projects/{id}/edit")
    public String editproject(@ModelAttribute("project") Project project, HttpSession session,
    						@PathVariable("id") Long projectId, Model model) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if(userId == null) {
    		return "redirect:/";
    	}else {
    			Project projectToUpdate = projectServ.findProject(projectId);
    			if(projectToUpdate.getLeader().getId()==userId) {
    				model.addAttribute("project",projectToUpdate);
    				return "/projects/editProject.jsp";    				
    			}else {
    				return "redirect:/dashboard";
    			}
    	}	
    }
    
    //Handling the update of a project
    @PutMapping("/projects/{id}/edit")
    public String updateProject(@Valid @ModelAttribute("project") Project project, BindingResult res,
    							Model model, HttpSession session, @PathVariable("id") Long id) {
    	if(res.hasErrors()) {
    		return "/projects/editProject.jsp";
    	}else {
    		Project oldProject = projectServ.findProject(id);
    		project.setLeader(oldProject.getLeader());
    		projectServ.updateProject(project);
    		return "redirect:/dashboard";
    	}
    }
    
    //Delete a project
    @DeleteMapping("/projects/{id}/delete")
    public String destroy (@PathVariable("id") Long projectId) {
    	projectServ.deleteProject(projectId);
    	return "redirect:/dashboard";
    }
    
    
    //Show one project
    @GetMapping("/projects/{id}/show")
    public String showproject(@ModelAttribute("project") Project project, HttpSession session,
    						@PathVariable("id") Long projectId, Model model) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if(userId == null) {
    		return "redirect:/";
    	}else {
    		User userIn = userServ.findOne(userId);
    		model.addAttribute("userIn",userIn);
    		Project thisProject = projectServ.findProject(projectId);
    		model.addAttribute("project",thisProject);
    		return "/projects/showProject.jsp";
    	}	
    }
}
