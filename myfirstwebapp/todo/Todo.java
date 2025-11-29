package com.sahil.springboot.myfirstwebapp.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

// database (MySQL)
//static List of todos => Database (H2, MySQL)

@Entity
public class Todo {
	
	public void setId(int id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Todo() {
		
	}
	
	@Id
	@GeneratedValue
	private int id;
	
//	@Column(name="Name")
	private String username;
	
	@Size(min=5, message="Enter atleast 5 characters")
	private String description;
	private LocalDate targetDate;
	private boolean done;
	
	public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setUsername(String username) {
		// TODO Auto-generated method stub
		this.username = username;
	}
	
	
		
}
