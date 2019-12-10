package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Ingredientes;
import com.example.demo.service.IngredientesService;

@RestController
public class IngredientesController {

	@Autowired
	IngredientesService ingredientesService;
	@GetMapping("/ingredientes")
	public ResponseEntity<List<Ingredientes>> getIngredientes() {
		
		return new ResponseEntity<List<Ingredientes>>(ingredientesService.getIngredientes(), HttpStatus.OK);
	}
	
	@GetMapping("/ingredientes/{id}")
	public Optional<Ingredientes> getIngredientes(@PathVariable int id) {
		return ingredientesService.getIngredienteById(id);
	}
	
}
