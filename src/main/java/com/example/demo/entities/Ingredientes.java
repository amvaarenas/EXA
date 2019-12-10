package com.example.demo.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name= "Ingredientes")
public class Ingredientes {
	@Column
	String nombre;
	
	@Column
	private Integer cantidad;
	
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int idI;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public int getId() {
		return idI;
	}
	public void setId(int id) {
		this.idI = id;
	}
}
