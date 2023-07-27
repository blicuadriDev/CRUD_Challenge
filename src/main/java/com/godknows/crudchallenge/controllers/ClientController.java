package com.godknows.crudchallenge.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godknows.crudchallenge.entities.Client;
import com.godknows.crudchallenge.repositories.ClientRepository;

@RestController
@RequestMapping(value="/clients")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepo;
	
	@GetMapping
	public String test(){
		Optional<Client> result = clientRepo.findById(1L);
		Client client = result.get();
		return client.getName();
	}

}
