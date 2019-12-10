package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Ingredientes;

public interface IngredientesRepository extends JpaRepository<Ingredientes,Integer>  {

}
