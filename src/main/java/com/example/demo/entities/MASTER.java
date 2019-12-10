package com.example.demo.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Table(name="master")
public class MASTER extends User {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
	
	@Column(name = "email")
    private String email;
	
    @Column(name = "password")
    private String password;
    
    @Column(name = "name")
    @NotEmpty(message = "*Please provide your name")
    private String name;
    
    @Column(name = "last_name")
    @NotEmpty(message = "*Please provide your last name")
    private String lastName;
    
    @Column(name = "active")
    private int active;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    
    
    public Set<Role> getRoles() {
		return roles;
	}
	public int getUser_id() {
		return user_id;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastName;
	}
	public int getActive() {
		return active;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
