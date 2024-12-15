package com.example.PostReq.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class testControllers {
	
	@GetMapping
	public String Home() {
		return "Welcome to PostReq Spring Boot Application";
	}

	@GetMapping("/{name}")
	public String Hi(@PathVariable String name) {
		return "Hello "+name+"!!";
	}
}
