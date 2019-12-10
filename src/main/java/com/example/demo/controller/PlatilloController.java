package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Ingredientes;
import com.example.demo.service.IngredientesService;
import com.example.demo.service.PlatilloService;


@RestController
public class PlatilloController {
	@Autowired
	PlatilloService platilloService;
	@Autowired
	IngredientesService ingredientesService;

	@GetMapping("/platillo/{id}/ingredientes")
	public ResponseEntity<List<Ingredientes>> getIngredientes(@PathVariable int id_platillo ) {
		
		return new ResponseEntity<List<Ingredientes>>(platilloService.getIngredientes(), HttpStatus.OK);
	}

	
	
}
