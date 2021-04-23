package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.model.Cliente;
import com.repository.ClienteRepository;

public class ClienteService {
	
	@Autowired
	ClienteRepository repository;
	
	
	public void adicionar(Cliente cliente) {
		repository.save(cliente);
		
	}
	
	public void remover(int id) {
		repository.deleteById(id);
	}
	
	public Cliente findById(int id) {
		return repository.getOne(id);
	}
	
	public List<Cliente> findAll(){
		return repository.findAll();	
		}

}
