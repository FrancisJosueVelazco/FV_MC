package com.fvelazco.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fvelazco.model.Persona;
import com.fvelazco.service.PersonaService;

//Estereotipo que define a la clase como CONTROLADOR, ademas de registrarlo en el Contenedor de Beans 
@RestController
@RequestMapping("/personas")
public class PersonaController {
	
	//Consultar al controlador de Bean la inyeccion de dependencias
	@Autowired
	private PersonaService service;
	
	
	@RequestMapping("/listar")
	@GetMapping
	public List<Persona> listar(){
		return service.listar();
	}
	
	@RequestMapping("/registrar")
	@PostMapping
	//	@RequestBody-->Deserealizar el objeto json(Entrada) a un objecto java (Persona-Salida)
	public Persona registrar(@RequestBody Persona per) {
		return service.crear(per); 
	}
	
	@GetMapping(value = "/listarxId/{id}")
	public Persona listarxId(@PathVariable("id") Integer id){
		return service.listapoId(id);
	}
	
	@DeleteMapping(value = "/eliminar/{id}")
	public void eliminar( @PathVariable("id") Integer id) {
		service.eliminar(id);
	}
	
}
