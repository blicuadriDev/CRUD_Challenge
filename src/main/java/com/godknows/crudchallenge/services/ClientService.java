package com.godknows.crudchallenge.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.godknows.crudchallenge.DTOs.ClientDTO;
import com.godknows.crudchallenge.entities.Client;
import com.godknows.crudchallenge.repositories.ClientRepository;



@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepo;
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> result = clientRepo.findById(id);
		Client client = result.get();
		ClientDTO dto = new ClientDTO(client);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll (Pageable pagegable){
		Page<Client> result = clientRepo.findAll(pagegable);
		return result.map(x -> new ClientDTO(x));
	}
	
	@Transactional
	public ClientDTO insert (ClientDTO dto){
		Client entity = new Client();
		copyDtoToEntity(dto, entity);
		entity = clientRepo.save(entity);
		return new ClientDTO(entity);
	}
	
	@Transactional
	public ClientDTO update (Long id, ClientDTO dto) {
		Client entity = clientRepo.getReferenceById(id);
		copyDtoToEntity(dto, entity);
		entity = clientRepo.save(entity);
		return new ClientDTO(entity);
	}
	
	
	
	
	private void copyDtoToEntity(ClientDTO dto, Client entity) {
		entity.setName(dto.getName());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());	
	}

}
