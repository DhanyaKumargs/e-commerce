package com.example.e_commerce.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.e_commerce.domain.Orders;
import com.example.e_commerce.dto.OrdersDto;
import com.example.e_commerce.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderEndpoint {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/add-order")
	public String addOrder(@RequestBody OrdersDto orderDto) {
		
		return orderService.addOrder(orderDto);
	}
	
	@GetMapping("/get-order")
	public OrdersDto getOrder(@RequestParam String id) {
		return orderService.getOrder(id);
	}
	
	@GetMapping("/user-orders")
	public List<Orders> getOrdersBasedOnUser(@RequestParam String userId) {
		return  orderService.getOrdersBsedOnUser(userId);
	}
	

}
