package com.Icwd.user.service.services;

import java.util.List;

import com.Icwd.user.service.entities.User;

public interface UserService {
	
	public User saveUser(User user) ;
	public List<User> getAllUsers() ;
	public User getUserById(String userId);

}
