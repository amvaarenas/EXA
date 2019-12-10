package com.example.demo.entities;

import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Platillo")
public class Platillo {
	@Column
	String nombre;

	@Column
	String estilo;

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idP;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Platillo_ingredientes", joinColumns = {
			@JoinColumn(name = "idP") }, inverseJoinColumns = { @JoinColumn(name = "idI") })
	private List<Ingredientes>receta;

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return idP;
	}

	public void setId(int id) {
		this.idP = id;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public List<Ingredientes> getReceta() {
		return receta;
	}

	public void setReceta(List<Ingredientes> receta) {
		this.receta = receta;
	}


}
