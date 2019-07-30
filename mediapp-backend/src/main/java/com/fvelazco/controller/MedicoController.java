package com.fvelazco.controller;

import java.net.URI;
import java.util.List;

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
import com.fvelazco.model.Medico;
import com.fvelazco.service.MedicoService;

@RestController
@RequestMapping(value = "medicos")
public class MedicoController {

	@Autowired
	private MedicoService service;

	
	
	
	@GetMapping(value = "/listar", produces = "application/json")
	public ResponseEntity<List<Medico>> listar() {
		return new ResponseEntity<List<Medico>>(service.listar(), HttpStatus.OK);
	}

	
	
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public Resource<Medico> listarxId(@PathVariable("id") Integer id) {
		Medico m = service.listarxId(id);
		if (m == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		Resource<Medico> resource = new Resource<Medico>(m);

		ControllerLinkBuilder linkto = linkTo(methodOn(this.getClass()).listarxId(id));
		resource.add(linkto.withRel("medico-resource"));

		return resource;
	}

	
	
	
	@PostMapping(value = "/registrar", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> registrar(@RequestBody Medico t) {
		Medico m=service.registrar(t);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(m.getIdMedico()).toUri();
		return ResponseEntity.created(location).build();
	}

	
	
	
	@PutMapping(value = "/modificar", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> modificar(Medico t) {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	
	
	
	@DeleteMapping(value = "/eliminar/{id}", produces = "application/json", consumes = "application/json")
	public void eliminar(@PathVariable("id") Integer id) {
		Medico m = service.listarxId(id);

		if (m == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
	}

}
