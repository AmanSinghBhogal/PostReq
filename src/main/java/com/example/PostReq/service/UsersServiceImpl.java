package com.example.PostReq.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.example.PostReq.entity.Users;
import com.example.PostReq.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	UsersRepository usersRepository;

	@Override
	public List<Users> findAllUsers() {
		List<Users> response = new ArrayList<Users>();
		Iterable<Users> users = usersRepository.findAll();
		
		// The below line is equivalent of a for loop shown below:
		users.forEach(response::add);
		// for(Users u: users)
		// {
		//      response.add(u);
		// }
		
		return response;
	}

	@Override
	public Users findUserByUid(String uid) {
		Users response;
		Optional<Users> user = usersRepository.findById(uid);
		response = user.get();
		return response;
	}

	@Override
	public Users postUser(Users user) {
		Users resp = usersRepository.save(user);
		return resp;
	}

	// Create Multiple users at a time.
	@Override
	public List<Users> postAllUsers(List<Users> userlist) {
		Iterable<Users> usersToPost = userlist;
		Iterable<Users> dbResp = usersRepository.saveAll(usersToPost);
		List<Users> Response = new ArrayList<Users>();
		dbResp.forEach(Response::add);
		return Response;
		
	}

	// Deletes given user
	@Override
	public String deleteUser(Users user) {
		try {
			usersRepository.delete(user);
			return "Success";
		}catch(Exception e) {
			System.out.println("Some fuck-up happened while deleting:");
			System.out.println(e);
			return "FAILURE";
		}
	}

	// Delete user with given uid
	@Override
	public String deleteUserByUid(String uid) {
		try {
			usersRepository.deleteById(uid);
			return "Success";
		}catch(Exception e) {
			System.out.println("Some fuck-up happened while deleting:");
			System.out.println(e);
			return "FAILURE";
		}
	}

	// Delete All users with given uid
	@Override
	public String deleteAllUsersByUid(List<Users> users) {
		try {
			// Fetch the given uids from the object list -> Make an iterable for it.
			List<String> userUidList = new ArrayList<String>();
			for(Users u: users) {
				userUidList.add(u.getUid());
			}
			Iterable<String> uids = userUidList;
			// Magic Happens below:
			usersRepository.deleteAllById(uids);
			return "Success";
		}catch(Exception e) {
			System.out.println("Some fuck-up happened while deleting:");
			System.out.println(e);
			return "FAILURE";
		}
	}

	// Delete all Given users
	@Override
	public String deleteAllUsers(List<Users> users) {
		try {
			Iterable<Users> userToDelete = users;
			// Magic Happens below:
			usersRepository.deleteAll(userToDelete);
			return "Success";
		}catch(Exception e) {
			System.out.println("Some fuck-up happened while deleting:");
			System.out.println(e);
			return "FAILURE";
		}
	}

	// Handles PUT request.
	@Override
	public Users putUser(Users user) {
		if(usersRepository.existsById(user.getUid())) {
			Users existingUser = usersRepository.findById(user.getUid()).get();
			existingUser.setName(user.getName());
			existingUser.setEmail(user.getEmail());
			return usersRepository.save(existingUser);
		}
		return null;
	}

	// Handles PATCH request
	@Override
	public Users patchUser(Map<String, Object> fields) {
		if(usersRepository.existsById((String) fields.get("uid"))) {
			Users existingUser = usersRepository.findById((String) fields.get("uid")).get();
			 fields.forEach((key, value) -> {
	                Field field = ReflectionUtils.findField(Users.class, key);
	                field.setAccessible(true);
	                ReflectionUtils.setField(field, existingUser, value);
	            });
            return usersRepository.save(existingUser);
		}
		return null;
	}
	
}
