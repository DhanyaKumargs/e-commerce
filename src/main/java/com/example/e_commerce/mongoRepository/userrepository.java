package com.example.e_commerce.mongoRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.e_commerce.domain.User;

public interface userrepository extends MongoRepository<User, String>{
	
	User findByid(String id);
	void deleteById(String id);

}
