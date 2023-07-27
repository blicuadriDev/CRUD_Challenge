package com.godknows.crudchallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godknows.crudchallenge.DTOs.ClientDTO;
import com.godknows.crudchallenge.services.ClientService;

@RestController
@RequestMapping(value="/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientServ;
	
	@GetMapping(value="/{id}")
	public ClientDTO dto (@PathVariable Long id) {
		ClientDTO dto =  clientServ.findById(id);
		return dto;
	}

}
