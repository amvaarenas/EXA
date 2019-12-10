package com.example.demo.dao;

import com.example.demo.entities.Ingredientes;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PlatilloRepository extends JpaRepository<Ingredientes,Integer>{

}
