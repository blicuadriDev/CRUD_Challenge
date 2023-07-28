package com.godknows.crudchallenge.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<ClientDTO> insert (@RequestBody ClientDTO dto){
		dto = clientServ.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getClass()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ClientDTO> update (@PathVariable Long id, @RequestBody ClientDTO dto){
		dto = clientServ.update(id, dto);
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		clientServ.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}
