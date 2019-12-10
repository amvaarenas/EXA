package com.example.demo.service;
//Llamas a repository

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IngredientesRepository;
import com.example.demo.dao.MenuRepository;
import com.example.demo.entities.Ingredientes;
import com.example.demo.entities.Platillo;

@Service
public class MenuService {
	@Autowired
	MenuRepository menuRepository;

	@Autowired
	IngredientesRepository ingredientesRepository;

	public List<Platillo> getPlatillo() {
		return menuRepository.findAll();
	}

	@Transactional
	public Platillo insertPlatillo(Platillo platillo) {
			List<Ingredientes> receta = platillo.getReceta();
			for (Ingredientes ing : receta) {
				Optional<Ingredientes> optional = ingredientesRepository.findById(ing.getId());
				if (!optional.isPresent()) {
					ingredientesRepository.save(ing);
				}
	
			}
		return menuRepository.save(platillo);
	}

	public void delete(int id) {
		menuRepository.deleteById(id);
	}

}
