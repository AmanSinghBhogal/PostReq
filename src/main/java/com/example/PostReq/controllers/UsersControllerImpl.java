package com.example.PostReq.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.PostReq.entity.DeleteRequest;
import com.example.PostReq.entity.UserRequestBody;
import com.example.PostReq.entity.Users;
import com.example.PostReq.service.UsersService;

@RestController
public class UsersControllerImpl implements UsersController {
	
	@Autowired
	UsersService usersService;

	@GetMapping("/users")
	@Override
	public ResponseEntity<List<Users>> getAllUsers(@RequestBody UserRequestBody request) {
		// Map the Request to appropriate Service layer function.
		if(request.getAction().equals("FETCHBYUID"))
		{
			List<Users> users = new ArrayList<Users>();
			// Send this request to Service layer
			Users resp = usersService.findUserByUid(request.getUid());
			users.add(resp);
			return new ResponseEntity<>(users,HttpStatus.OK);
		}
		else if(request.getAction().equals("FETCHALL")) {			
			List<Users> allUsers = usersService.findAllUsers();
			return new ResponseEntity<>(allUsers,HttpStatus.OK);
		}
		else {
			List<Users> resp = new ArrayList<Users>();
			return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/users")
	@Override
	public ResponseEntity<Users> postUser(@RequestBody Users user) {
//		System.out.println("Post Request Incoming on /users");
//		System.out.println("User uid: "+user.getUid());
//		System.out.println("User name: "+user.getName());
//		System.out.println("User Email: "+user.getEmail());
		Users resp = usersService.postUser(user);
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}

	@PostMapping("/users/postAll")
	@Override
	public ResponseEntity<List<Users>> postAllUsers(@RequestBody List<Users> usersToPost) {
		List<Users> resp = usersService.postAllUsers(usersToPost);
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}

	@DeleteMapping("/users/delete")
	@Override
	public ResponseEntity<String> deleteUsers(@RequestBody DeleteRequest request) {
		if(request.getOperation().equals("DELETE")) {
			String response = usersService.deleteUser(request.getUsers().getFirst());
			if(response.equals("Success")) {
				return new ResponseEntity<>("User "+ request.getUsers().getFirst().getName()+ " has been Deleted Successfully.",HttpStatus.OK);
			}
		}
		else if(request.getOperation().equals("DELETEBYID")) {
			String response = usersService.deleteUserByUid(request.getUsers().getFirst().getUid());
			if(response.equals("Success")) {
				return new ResponseEntity<>("User "+ request.getUsers().getFirst().getName()+ " has been Deleted Successfully.",HttpStatus.OK);
			}
		}
		else if(request.getOperation().equals("DELETEALLBYUID")) {
			String response = usersService.deleteAllUsersByUid(request.getUsers());
			if(response.equals("Success")) {
				return new ResponseEntity<>("All Users with given UID Deleted Successfully.",HttpStatus.OK);
			}
		}
		else if(request.getOperation().equals("DELETEALL")) {
			String response = usersService.deleteAllUsers(request.getUsers());
			if(response.equals("Success")) {
				return new ResponseEntity<>("All given Users Deleted Successfully.",HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("Some thing went wrong.", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/users")
	@Override
	public ResponseEntity<Users> putUser(@RequestBody Users request) {
		Users user = usersService.putUser(request);
		if(user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
	}

	@PatchMapping("/users")
	@Override
	public ResponseEntity<Users> patchUser(@RequestBody Map<String, Object> request) {
		Users user = usersService.patchUser(request);
		if(user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
	}
	
	
	
}
