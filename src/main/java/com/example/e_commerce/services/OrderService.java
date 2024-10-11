package com.example.e_commerce.services;

import java.util.List;

import com.example.e_commerce.domain.Orders;
import com.example.e_commerce.dto.OrdersDto;



public interface OrderService {

	String addOrder(OrdersDto orderDto);

	OrdersDto getOrder(String id);

	List<Orders> getOrdersBsedOnUser(String userId);

}
