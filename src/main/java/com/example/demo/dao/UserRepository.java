package com.example.demo.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
   User findByEmail(String email);
}