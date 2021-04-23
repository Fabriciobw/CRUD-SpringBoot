package com.aplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplication.model.Cliente;
import com.aplication.repository.ClienteRepository;

@Service
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


