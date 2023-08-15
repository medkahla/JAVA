package com.projectmanager.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="projects")
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message="Title is required!")
    @Size(min=10, max=128, message="Must be between 10 and 128 characters")
    private String title;
    
    @NotBlank(message="Description is required!")
    @Size(min=20, max=250, message="Must be between 20 and 250 characters")
    private String description;
    
    // A project can have only one leader
 	@ManyToOne(fetch = FetchType.LAZY)
 	@JoinColumn(name = "user_id")
    private User leader;
 	
    // One project can have Many tasks
    @OneToMany(mappedBy="project", fetch = FetchType.LAZY)
    private List <Task> tasks;
    
    // Every user can be on Many projects
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_projects", 
        joinColumns = @JoinColumn(name = "project_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List <User> teamMembers;
 	
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Future(message = "It can't be to do in the past!")
    private Date dueDate;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
  
    public Project() {}
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getLeader() {
		return leader;
	}
	public void setLeader(User leader) {
		this.leader = leader;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public List<User> getTeamMembers() {
		return teamMembers;
	}
	public void setTeamMembers(List<User> teamMembers) {
		this.teamMembers = teamMembers;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}    
    
}
