package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Ingredientes;
import com.example.demo.entities.Platillo;
import com.example.demo.service.MenuService;

@RestController
public class MenuController {
	@Autowired
	MenuService menuService;
	
	@GetMapping("/platillo")
	public ResponseEntity<List<Platillo>> getPlatillo() {
		return new ResponseEntity<List<Platillo>>(menuService.getPlatillo(), HttpStatus.OK);
	}
	@PostMapping("/platillo")
	public ResponseEntity<Integer> insertClient(@RequestBody Platillo platillo) {
		System.out.println("////////////////////////////////////////////////");
		return new ResponseEntity<Integer>(menuService.insertPlatillo(platillo).getId(), HttpStatus.OK);
	}
//	@DeleteMapping("/platillo/{id}")
//	public void deletePlatillos(@PathVariable int id){
//		menuService.delete(id);
//	}
	
	
}
