package com.fvelazco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fvelazco.exception.ModeloNotFoundException;
import com.fvelazco.model.Paciente;
import com.fvelazco.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteService service;
	
	@GetMapping(value = "/listar")
	public List<Paciente> listar(){
		return service.listar();
	}
	
	@GetMapping(value = "/listarxId/{id}")
	public Paciente listarxId(@PathVariable("id")  Integer id) {
		
		Paciente p=service.listarxId(id);
		if (p==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: "+id);
		}
		return p;
	}
	
	@PostMapping(value = "/registrar")
	public Paciente registrar(@RequestBody Paciente t) {
		return service.registrar(t);
	}
	
	@PutMapping(value = "/modificar")
	public Paciente modificar(@RequestBody Paciente t) {
		return service.modificar(t);
	}
	
	@DeleteMapping(value = "/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
	}
	
	

}
