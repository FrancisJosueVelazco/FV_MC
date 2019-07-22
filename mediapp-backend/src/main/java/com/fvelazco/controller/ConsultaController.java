package com.fvelazco.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fvelazco.model.Consulta;
import com.fvelazco.model.ConsultaListaExamenDTO;
import com.fvelazco.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	
	@Autowired
	private ConsultaService service;
	
	
	@PostMapping(value = "/registrar", produces = "application/json", consumes = "application/json ")
	public ResponseEntity<Object> registrar(@RequestBody ConsultaListaExamenDTO consDTO) {
		Consulta consulta = new Consulta();
		consulta= service.registrarTransaccional(consDTO);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(consulta.getIdConsulta()).toUri();
		
		return ResponseEntity.created(location).build();
	}

}
