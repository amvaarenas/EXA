package com.example.demo.entities;

import java.util.List;

public class Menu {
	String restaurant;
	private List<Platillo> platos;
	

	public List<Platillo> getPlatos() {
		return platos;
	}

	public void setPlatos(Platillo platos) {
		this.platos.add(platos);
	}
	
}
