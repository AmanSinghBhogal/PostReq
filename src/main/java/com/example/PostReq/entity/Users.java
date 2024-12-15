package com.example.PostReq.entity;


import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@UuidGenerator 
	private String uid;
	
//	@PrePersist
//	private void ensureId(){
//	    System.out.println("Before going to save:");
//	    System.out.println("Uid: "+this.getUid());
//	    System.out.println("Name: "+ this.getName());
//	    System.out.println("Email: "+this.getEmail());
//	}
	
	@Column
	private String name;
	
	@Column
	private String email;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	

}
