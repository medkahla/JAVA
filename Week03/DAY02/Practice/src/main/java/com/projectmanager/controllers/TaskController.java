package com.projectmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projectmanager.models.Project;
import com.projectmanager.models.Task;
import com.projectmanager.models.User;
import com.projectmanager.services.ProjectService;
import com.projectmanager.services.TaskService;
import com.projectmanager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class TaskController {
    
    @Autowired
    private UserService userServ;
    
    @Autowired
    private ProjectService projectServ;
    
    @Autowired
    private TaskService taskServ;
    
	//Main route to the Dashboard - pointing after connection
    @GetMapping("/projects/{id}/tasks")
    public String showTasks(@ModelAttribute("task") Task task, HttpSession session, Model model,
    						@PathVariable("id") Long projectId) {
    	Long userId = (Long) session.getAttribute("user_id");
    	if(userId == null) {
    		return "redirect:/";
    	}else {
    		Project thisProject = projectServ.findProject(projectId);
    		model.addAttribute("thisProject",thisProject);
    		User userIn = userServ.findOne(userId);
    		model.addAttribute("userIn",userIn);
    		List<Task> listTasks = taskServ.thisProjectTasks(thisProject);
    		model.addAttribute("listTasks",listTasks);
    		return "/tasks/tasks.jsp";
    	}	
    }
    
    // Handle adding new project
    @PostMapping("/projects/{id}/tasks")
    public String addTask(@Valid @ModelAttribute("task") Task task, BindingResult res, HttpSession session,
    						Model model, @PathVariable("id") Long projectId) {
    	Long userId = (Long) session.getAttribute("user_id");
    	User userIn = userServ.findOne(userId);
    	Project thisProject = projectServ.findProject(projectId);
    	if(res.hasErrors()) {
    		model.addAttribute("userIn",userIn);
    		model.addAttribute("thisProject",thisProject);
    		List<Task> listTasks = taskServ.allTasks();
    		model.addAttribute(listTasks);
    		return "tasks/tasks.jsp";
    	}else {
    		task.setPoster(userIn);
    		task.setProject(thisProject);
    		taskServ.createTask(task);
    		return "redirect:/projects/{id}/tasks";
    	}
    }
}
