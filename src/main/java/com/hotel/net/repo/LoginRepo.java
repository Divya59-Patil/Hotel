package com.hotel.net.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.net.entities.Login;

public interface LoginRepo extends JpaRepository<Login, Integer>{

	Login findByUsername(String username);
    
}
