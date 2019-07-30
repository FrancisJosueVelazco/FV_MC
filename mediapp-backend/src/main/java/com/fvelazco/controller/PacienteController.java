package com.fvelazco.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fvelazco.exception.ModeloNotFoundException;
import com.fvelazco.model.Paciente;
import com.fvelazco.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private PacienteService service;

	
	// LISTAR----------------------------------------------------
	// RESPUESTA STATUS
	@GetMapping(value = "/listar", produces = "application/json")
	public ResponseEntity<List<Paciente>> listar() {
		return new ResponseEntity<List<Paciente>>(service.listar(), HttpStatus.OK);
	}

	
	// LISTAR POR ID----------------------------------------------------
	//		Resoruce --> HATEOAS (HyperMedia)
	@GetMapping(value = "/listarxId/{id}", produces = "application/json")
	public Resource<Paciente> listarxId(@PathVariable("id") Integer id) {

		Paciente p = service.listarxId(id);
		if (p == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		Resource<Paciente> resource = new Resource<Paciente>(p);

		ControllerLinkBuilder linkto = linkTo(methodOn(this.getClass()).listarxId(id));
		resource.add(linkto.withRel("paciente-resource"));

		return resource;
	}

	
	
	// REGISTRAR----------------------------------------------------
	@PostMapping(value = "/registrar", produces = "application/json", consumes = "application/json ")
	public ResponseEntity<Object> registrar(@Valid @RequestBody Paciente t) {
		Paciente paciente = new Paciente();
		paciente = service.registrar(t);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(paciente.getIdPaciente()).toUri();
		return ResponseEntity.created(location).build();
	}

	
	
	// MODIFICAR----------------------------------------------------
	@PutMapping(value = "/modificar", produces = "application/json", consumes = "aplication/json ")
	public ResponseEntity<Object> modificar(@RequestBody Paciente t) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	
	// ELIMINAR----------------------------------------------------
	@DeleteMapping(value = "/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		Paciente paciente = service.listarxId(id);
		if (paciente == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);

		} else {
			service.eliminar(id);

		}
	}

}
