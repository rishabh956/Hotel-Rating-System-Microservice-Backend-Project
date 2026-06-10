package com.Icwd.user.service.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Icwd.user.service.entities.User;
import com.Icwd.user.service.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService ;
	//create user
	
	@PostMapping()
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User user1 = userService.saveUser(user);
		return ResponseEntity.ok(user1);
	}
	
	//get specific user
	@GetMapping("/{userId}")
	public ResponseEntity<User> getOneUser(@PathVariable String userId)
	{
		User user1 = this.userService.getUserById(userId);
		return ResponseEntity.status(HttpStatus.OK).body(user1);
	}
	
	//get all users
	@GetMapping()
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User> userList = userService.getAllUsers();
		return ResponseEntity.ok(userList);
	}

}
