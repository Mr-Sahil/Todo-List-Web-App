package com.sahil.springboot.myfirstwebapp.todo;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{
	
	@Bean
	public List<Todo> findByUsername(String username);

}
