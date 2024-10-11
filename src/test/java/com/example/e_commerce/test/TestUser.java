package com.example.e_commerce.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.e_commerce.domain.User;
import com.example.e_commerce.dto.UserDto;
import com.example.e_commerce.mongoRepository.userrepository;
import com.example.e_commerce.services.UserServiceImpl;


public class TestUser {
	
	  @InjectMocks
	    private UserServiceImpl userService;

	    @Mock
	    private userrepository userRepo;

	    @Mock
	    private ModelMapper modelMapper;

	    private User user;
	    private UserDto userDto;

	    @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.openMocks(this);

	        user = new User();
	        user.setId("1");
	        user.setUserName("John Doe");

	        userDto = new UserDto();
	        userDto.setId("1");
	        userDto.setUserName("John Doe");
	    }

	    @Test
	    public void testGetUser_Success() {
	        when(userRepo.findByid("1")).thenReturn(user);
	        when(modelMapper.map(user, UserDto.class)).thenReturn(userDto);

	        UserDto result = userService.getUser("1");

	        assertNotNull(result);
	        assertEquals("1", result.getId());
	        assertEquals("John Doe", result.getUserName());
	        verify(userRepo).findByid("1");
	    }
	    
	    @Test
	    public void testAddUser_Success() {
	        when(modelMapper.map(userDto, User.class)).thenReturn(user);

	        String result = userService.addUser(userDto);

	        assertEquals("User added Succesfully", result);
	        verify(userRepo).save(user);
	    }

}
