package com.example.PostReq.entity;

import java.util.List;

public class DeleteRequest {
	
	private String operation;
	
	private List<Users> users;

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}
	
	
}
