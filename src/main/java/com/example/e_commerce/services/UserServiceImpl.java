package com.example.e_commerce.services;

import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.e_commerce.domain.User;
import com.example.e_commerce.dto.UserDto;
import com.example.e_commerce.exception.UserException;
import com.example.e_commerce.mongoRepository.userrepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	userrepository userRepo;

	@Autowired
	private ModelMapper modelMapper;
	
	private BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder(12);

	@Override
	public UserDto getUser(String id) {
		Objects.requireNonNull(id, "Request cannot be null");
		try {
			User User = userRepo.findByid(id);
			UserDto userDto = modelMapper.map(User, UserDto.class);
			return userDto;
		} catch (Exception e) {
			throw new UserException(e.getMessage());
		}

	}

	@Override
	public String addUser(UserDto userDto) {
		Objects.requireNonNull(userDto, "user Object cannot be null");
		try {
			User user = modelMapper.map(userDto, User.class);
			// encoding the password
			user.setPassword(bcryptEncoder.encode(user.getPassword()));
			userRepo.save(user);
			return "User added Succesfully";
		} catch (Exception e) {
			throw new UserException(e.getMessage());
		}
	}

	@Override
	public String updateUser(UserDto userDto) {
		Objects.requireNonNull(userDto, "user Object cannot be null");
		try {
			User user = modelMapper.map(userDto, User.class);
			user.setPassword(bcryptEncoder.encode(user.getPassword()));
			userRepo.save(user);
			return "User added Succesfully";
		} catch (Exception e) {
			throw new UserException(e.getMessage());
		}
	}

	@Override
	public String deleteUser(String id) {
		Objects.requireNonNull(id, "Request cannot be null");
		try {
			
			userRepo.deleteById(id);
			return "User deleted Succesfully";
		} catch (Exception e) {
			throw new UserException(e.getMessage());
		}
	}

}
