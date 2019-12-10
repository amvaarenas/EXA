package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PlatilloRepository;
import com.example.demo.entities.Ingredientes;

@Service
public class PlatilloService {
	@Autowired
	PlatilloRepository platilloRepository;

	public List<Ingredientes> getIngredientes() {
		return platilloRepository.findAll();
	}
	

}
