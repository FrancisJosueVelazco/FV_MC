package com.fvelazco.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fvelazco.model.Persona;
import com.fvelazco.service.PersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {
	
	private PersonaService service;
	
	@GetMapping
	public List<Persona> listar(){
		return service.listar();
	}
	
	@PostMapping
	public Persona registrar(Persona per) {
		return service.crear(per); 
	}
	
}
