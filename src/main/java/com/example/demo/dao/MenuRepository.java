package com.example.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Platillo;

public interface MenuRepository extends JpaRepository<Platillo,Integer>{
	

}
