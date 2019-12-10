package com.example.demo.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.service.UserService;

@RestController
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@RequestMapping(value = "/registro", method = RequestMethod.POST)
	public ResponseEntity<Integer> createNewUser(@RequestBody User user) {
		User optional = userService.findUserByEmail(user.getEmail());
		if (optional==null) {
			userService.saveUser(user);
			return new ResponseEntity<Integer>(user.getId(), HttpStatus.OK);
		} else
			return new ResponseEntity<Integer>(0, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
	}
	@RequestMapping(value = "/cambioRoleAdm/{id}", method = RequestMethod.POST)
	public ResponseEntity<Integer> cambioRoleAdm(@PathVariable int id) {
		Optional<User> optional = userRepository.findById(id);
		System.out.println(optional.isPresent());
		if (optional.isPresent()) {
			 Role userRole = roleRepository.findByRole("ADMIN");
		        optional.get().setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		      userRepository.save(optional.get());
			return new ResponseEntity<Integer>(optional.get().getId(), HttpStatus.OK);
		} else
			return new ResponseEntity<Integer>(0, HttpStatus.NOT_ACCEPTABLE);
	}
	@RequestMapping(value = "/cambioRoleUsuario/{id}", method = RequestMethod.POST)
	public ResponseEntity<Integer> cambioRoleUsuario(@PathVariable int id) {
		Optional<User> optional = userRepository.findById(id);
		System.out.println(optional.isPresent());
		if (optional.isPresent()) {
			 Role userRole = roleRepository.findByRole("USER");
		        optional.get().setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		        userRepository.save(optional.get());
			return new ResponseEntity<Integer>(optional.get().getId(), HttpStatus.OK);
		} else
			return new ResponseEntity<Integer>(0, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public List<User> cambioRoleAdm() {
			return userRepository.findAll();
	}
	

}
