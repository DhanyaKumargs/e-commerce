package com.example.e_commerce.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.e_commerce.dto.UserDto;
import com.example.e_commerce.services.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserEndpoint {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/get-user")
	public ResponseEntity<UserDto> getUser(@RequestParam("id") String id) {
		
		return  ResponseEntity.ok( userService.getUser(id));
		
	}
	
	@PostMapping("/add-user")
	public  ResponseEntity<String> addUser(@RequestBody UserDto user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
		
		
	}
	
	@PutMapping("/update-user")
	public  ResponseEntity<String> updateUser(@RequestBody UserDto user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateUser(user));
		
		
	}
	
	@DeleteMapping("/delete-user")
	public  ResponseEntity<String> updateUser(@RequestParam("id") String id) {
		return  ResponseEntity.ok(userService.deleteUser(id));
		
		
	}
	
	@GetMapping("/csrf-tocken")
	public CsrfToken getTocken(HttpServletRequest http) {
		
		return(CsrfToken) http.getAttribute("_csrf");
		
	}

}
