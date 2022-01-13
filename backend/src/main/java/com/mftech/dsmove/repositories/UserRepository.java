package com.mftech.dsmove.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mftech.dsmove.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
}
