package com.projectmanager.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="tasks")
public class Task {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message="Discription is required!")
    @Size(min=3, max=30, message="Description must be meanful between 20 and 120 characters")
    private String description;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Future(message = "It can't be to do in the past!")
    private Date dueDate;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
    
    //One project can have many tasks
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="project_id")
    private Project project;
    
    //One teamMember can add many tasks    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User poster;

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    public Task() {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public User getPoster() {
		return poster;
	}
	public void setPoster(User poster) {
		this.poster = poster;
	}
}
