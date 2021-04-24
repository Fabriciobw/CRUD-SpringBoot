package com.aplication.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/listarClientes")
	public ModelAndView listar() {
		
		ModelAndView mv = new ModelAndView("lista");
		List<Cliente> clientes = repository.findAll();
		mv.addObject("clientes", clientes);
		return mv;
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id) {
	    Cliente cliente = repository.findById(id);
	 
	    repository.remover(cliente.getId());
	    return "redirect:/listarClientes";
	}
	
	
	@RequestMapping(path = {"/edit/{id}"})
    public String editEmployeeById(Model model, @PathVariable("id") int id) 
                          
    {
        
            Cliente cliente = repository.findById(id);
            model.addAttribute("clienteOb", cliente);
       
        return "formularioUpdate";
    }
     
	

}
