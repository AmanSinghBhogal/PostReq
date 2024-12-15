package com.example.PostReq.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.PostReq.entity.DeleteRequest;
import com.example.PostReq.entity.UserRequestBody;
import com.example.PostReq.entity.Users;

@RestController
public interface UsersController {
	
	// Returns all users:
	ResponseEntity<List<Users>> getAllUsers(UserRequestBody request);
	
	// Posts a new User
	ResponseEntity<Users> postUser(Users user);
	
	// Post multiple New Users at a time:
	ResponseEntity<List<Users>> postAllUsers(List<Users> usersToPost);
	
	// Handle Delete Requests:
	ResponseEntity<String> deleteUsers(DeleteRequest request);
	
	// Handles PUT Request:
	ResponseEntity<Users> putUser(Users request);
	
	// Handles Patch Request:
	ResponseEntity<Users> patchUser(Map<String, Object> request);

}
