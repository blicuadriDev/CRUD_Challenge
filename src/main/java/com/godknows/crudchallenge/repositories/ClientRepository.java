package com.godknows.crudchallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godknows.crudchallenge.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
