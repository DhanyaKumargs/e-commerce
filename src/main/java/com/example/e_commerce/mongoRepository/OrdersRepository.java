package com.example.e_commerce.mongoRepository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.e_commerce.domain.Orders;

public interface OrdersRepository extends MongoRepository<Orders, String> {
	
	Orders findByid(String id);

	List<Orders> findByUserid(String userId);

}
