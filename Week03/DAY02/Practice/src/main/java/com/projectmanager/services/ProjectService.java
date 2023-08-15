package com.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectmanager.models.Project;
import com.projectmanager.repositories.ProjectRepository;

@Service
public class ProjectService {
	// === CRUD ===
	
		@Autowired
		private ProjectRepository projectRepo;
		
		// READ ALL
		public List<Project> allProjects(){
			return projectRepo.findAll();
		}
		
		// CREATE
		public Project createProject(Project b) {
			return projectRepo.save(b);
		}
		
		// READ ONE
		public Project findProject(Long id) {
			
			Optional<Project> potentielProject = projectRepo.findById(id);
			if(potentielProject.isPresent()) {
				return potentielProject.get();
			}else {
				return null;
			}
		}
		
		// UPDATE 
		public Project updateProject(Project b) {
			return projectRepo.save(b);
		}
		
		// DELETE
		public void deleteProject(Long id) {
			projectRepo.deleteById(id);
		}
}
