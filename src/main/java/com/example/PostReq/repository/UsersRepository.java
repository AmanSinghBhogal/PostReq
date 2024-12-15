package com.example.PostReq.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.PostReq.entity.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, String> {

}
