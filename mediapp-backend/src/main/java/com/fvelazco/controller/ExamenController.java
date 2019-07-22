package com.fvelazco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fvelazco.model.Examen;
import com.fvelazco.service.ExamenService;

@RestController
@RequestMapping("/examenes")
public class ExamenController {
	
	@Autowired
	private ExamenService service;
	
	@PostMapping(consumes = "application/json",produces = "application/json",value = "/registrar")
	public Examen registrar(@RequestBody Examen examen) {
		return service.registrar(examen);
	}
	
	@GetMapping(consumes = "application/json")
	public List<Examen>listar(){
		return service.listar();
	}
	
	@GetMapping(consumes = "application/json",produces = "application/json", value = "/listarxId/{id}")
	public Examen listarxId(@PathVariable("id")Integer id) {
		return service.listarxId(id);
	}
	
	@DeleteMapping(value = "eliminar/{id}")
	public void Eliminar(@PathVariable("id")Integer id) {
		service.eliminar(id);
	}

}
