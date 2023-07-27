package com.godknows.crudchallenge.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godknows.crudchallenge.DTOs.ClientDTO;
import com.godknows.crudchallenge.entities.Client;
import com.godknows.crudchallenge.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepo;
	
	public ClientDTO findById(Long id) {
		Optional<Client> result = clientRepo.findById(id);
		Client client = result.get();
		ClientDTO dto = new ClientDTO(client);
		return dto;
	}

}
