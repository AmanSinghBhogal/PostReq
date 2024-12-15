package com.example.PostReq.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.PostReq.entity.Users;

@Service
public interface UsersService {
	
	// Fetch all user details:
	List<Users> findAllUsers();
	
	// Fetch User by Uid:
	Users findUserByUid(String uid);
	
	// Post a new User:
	Users postUser(Users user);
	
	// Post Multiple users At a time
	List<Users> postAllUsers(List<Users> userlist);
	
	// Delete a particular user
	String deleteUser(Users user);
	
	// Delete Particular user with uid
	String deleteUserByUid(String uid);
	
	// Delete All users with given uid
	String deleteAllUsersByUid(List<Users> users);
	
	// Delete All given Users
	String deleteAllUsers(List<Users> users);
	
	// PUT Request Handling (i.e, Replace an entire existing record)
	Users putUser(Users user);
	
	// PATCH Request Handling (i.e, Update an existing record)
	Users patchUser(Map<String, Object> fields);
}
