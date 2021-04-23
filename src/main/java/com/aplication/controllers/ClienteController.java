package com.aplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aplication.model.Cliente;
import com.aplication.service.ClienteService;

@Controller
public class ClienteController {
	

	@Autowired
	ClienteService repository;
	


	@RequestMapping(value = "/cadastrarCliente", method=RequestMethod.GET)
	public String form() {
		
		
		return "formulario";
		
	}
	
	@RequestMapping(value = "/cadastrarCliente", method=RequestMethod.POST)
	public String form(Cliente cliente) {
		
		repository.adicionar(cliente);
		return "redirect:/cadastrarCliente";
	}
	

}
