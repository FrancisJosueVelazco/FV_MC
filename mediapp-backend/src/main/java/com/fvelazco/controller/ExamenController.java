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
import com.fvelazco.model.Examen;
import com.fvelazco.service.ExamenService;

@RestController
@RequestMapping("/examenes")
public class ExamenController {

	@Autowired
	private ExamenService service;

	@GetMapping(value = "/listar", produces = "application/json")
	public ResponseEntity<List<Examen>> listar() {
		return new ResponseEntity<List<Examen>>(service.listar(), HttpStatus.OK);
	}

	@GetMapping(consumes = "application/json", produces = "application/json", value = "/listarxId/{id}")
	public Resource<Examen> listarxId(@PathVariable("id") Integer id) {

		Examen e = service.listarxId(id);
		if (e == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		
		//HATEOAS --> HYPEMEDIA
		Resource<Examen> resource = new Resource<Examen>(e);
		ControllerLinkBuilder linkto = linkTo(methodOn(this.getClass()).listarxId(id));
		resource.add(linkto.withRel("examen-resource"));
		return resource;
	}

	@PostMapping(consumes = "application/json", produces = "application/json", value = "/registrar")
	public ResponseEntity<Object> registrar(@Valid @RequestBody Examen examen) {
		Examen e = service.registrar(examen);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(e.getIdExamen())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping(value = "/modificar", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> modificar(@RequestBody Examen e) {
		service.modificar(e);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping(value = "eliminar/{id}")
	public void Eliminar(@PathVariable("id") Integer id) {
		Examen e = service.listarxId(id);
		if (e == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}

	}

}
