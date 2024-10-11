package com.example.e_commerce.services;

import com.example.e_commerce.dto.UserDto;

public interface UserService {

	UserDto getUser(String id);

	String addUser(UserDto user);

	String updateUser(UserDto user);

	String deleteUser(String id);

}
