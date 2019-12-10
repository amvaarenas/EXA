package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dao.IngredientesRepository;
import com.example.demo.entities.Ingredientes;

@Service
public class IngredientesService {
	@Autowired
	 IngredientesRepository ingredientesRepository;

	public List<Ingredientes> getIngredientes() {

		return ingredientesRepository.findAll();
	}
	
	@Transactional
	public Ingredientes insertIngredientes(Ingredientes ingredientes) {
		return ingredientesRepository.save(ingredientes);
	}

	public Optional<Ingredientes> getIngredienteById(int id) {
		return ingredientesRepository.findById(id);
	}

	public void insertListIngredientes(List<Ingredientes> ingredientes) {
		for(Ingredientes ing:ingredientes)
			ingredientesRepository.save(ing);
	}

}
