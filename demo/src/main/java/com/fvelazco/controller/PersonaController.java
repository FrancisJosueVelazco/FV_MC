package com.fvelazco.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Persona;

@RestController
@RequestMapping("/personas")
public class PersonaController {
	
	@GetMapping
	public Persona Saludar() {
		
		Persona per=new Persona();
		per.setId(1);
		per.setNombre("Hola");
		
		return per;
	}

}
