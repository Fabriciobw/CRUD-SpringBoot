package com.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
	
	
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

}