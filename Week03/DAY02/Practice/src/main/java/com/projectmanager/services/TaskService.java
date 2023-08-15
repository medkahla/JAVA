package com.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectmanager.models.Project;
import com.projectmanager.models.Task;
import com.projectmanager.repositories.TaskRepository;

@Service
public class TaskService {
	// === CRUD ===
	
	@Autowired
	private TaskRepository taskRepo;
	
	// READ ALL
	public List<Task> allTasks(){
		return taskRepo.findAll();
	}
	
	// READ ALL FOR ONE PROJET
	public List<Task> thisProjectTasks(Project project){
		return taskRepo.findByProject(project);
	}
	
	// CREATE
	public Task createTask(Task b) {
		return taskRepo.save(b);
	}
	
	// READ ONE
	public Task findTask(Long id) {
		
		Optional<Task> potentielTask = taskRepo.findById(id);
		if(potentielTask.isPresent()) {
			return potentielTask.get();
		}else {
			return null;
		}
	}
	
	// UPDATE 
	public Task updateTask(Task b) {
		return taskRepo.save(b);
	}
	
	// DELETE
	public void deleteTask(Long id) {
		taskRepo.deleteById(id);
	}
}
