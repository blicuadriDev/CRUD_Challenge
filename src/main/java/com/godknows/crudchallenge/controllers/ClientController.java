package com.godknows.crudchallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<ClientDTO> findById (@PathVariable Long id) {
		ClientDTO dto =  clientServ.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping
	public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable){
		Page<ClientDTO> result = clientServ.findAll(pageable);
		return ResponseEntity.ok(result);
	}

}
