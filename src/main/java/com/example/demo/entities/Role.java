package com.example.demo.entities;
import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int id;
    @Column(name = "role")
    private String role;
    
	public int getId() {
		return id;
	}
	public String getRole() {
		return role;
	}
	
    
}  