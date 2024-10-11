package com.example.e_commerce.mongoRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.e_commerce.domain.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
	
	public Product findByid(String id);
	
	 void deleteByid(String id);

}
