package com.example.e_commerce.services;

import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.e_commerce.domain.Orders;
import com.example.e_commerce.dto.OrdersDto;
import com.example.e_commerce.exception.OrderException;
import com.example.e_commerce.mongoRepository.OrdersRepository;

@Service
public class orderServiceImpl implements OrderService {

	@Autowired
	OrdersRepository orderRepo;
	
	@Autowired
	ModelMapper modelmapper;
	
	@Override
	public String addOrder(OrdersDto orderDto) {
		Objects.requireNonNull(orderDto, "Order Object cannot be null");
		try {
			Orders order = modelmapper.map(orderDto, Orders.class);
			orderRepo.save(order);
			return "Order placed successfully";
		}catch(Exception e) {
			throw new OrderException(e.getMessage());
		}
	}

	@Override
	public OrdersDto getOrder(String id) {
		Objects.requireNonNull(id, "Request cannot be null");
		try {
			Orders order = orderRepo.findByid(id);
			return modelmapper.map(order, OrdersDto.class);
		}catch(Exception e) {
			throw new OrderException(e.getMessage());
		}
	}

	@Override
	public List<Orders> getOrdersBsedOnUser(String userId) {
		Objects.requireNonNull(userId, "User id cannot be null");
		try {
			return  orderRepo.findByUserid(userId);
			
		}catch(Exception e) {
			throw new OrderException(e.getMessage());
		}
	}
	
	

}
