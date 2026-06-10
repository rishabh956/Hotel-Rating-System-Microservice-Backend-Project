package com.Icwd.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Icwd.user.service.entities.User;

public interface UserServiceRepo extends JpaRepository<User,String> {
	
	// write custom query methods

}
