package com.fvelazco.controller;

import java.net.URI;
import java.util.ArrayList;
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
import com.fvelazco.model.Consulta;
import com.fvelazco.model.ConsultaDTO;
import com.fvelazco.model.ConsultaListaExamenDTO;
import com.fvelazco.model.Examen;
import com.fvelazco.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private ConsultaService service;

	
	
	@GetMapping(value = "/listar", produces = "application/json")
	public ResponseEntity<List<Consulta>> listar() {
		return new ResponseEntity<List<Consulta>>(service.listar(), HttpStatus.OK);
	}

	
	
	@GetMapping(value = "listarxId/{id}", produces = "application/json")
	public Resource<Consulta> listarxId(@PathVariable("id") Integer id) {

		Consulta c = service.listarxId(id);
		if (c == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		
		//HATEOAS --> HYPEMEDIA
		Resource<Consulta> resource = new Resource<Consulta>(c);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarxId(id));
		resource.add(linkTo.withRel("consulta-resource"));
		return resource;
	}

	
	
	@GetMapping(value = "/listarxHateoas", produces = "application/json")
	public List<ConsultaDTO> listarHateoas() {
		List<Consulta> consultas = new ArrayList<>();
		List<ConsultaDTO> consultaDTO = new ArrayList<>();
		consultas = service.listar();

		for (Consulta c : consultas) {
			ConsultaDTO d = new ConsultaDTO();
			d.setIdConsulta(c.getIdConsulta());
			d.setMedico(c.getMedico());
			d.setPaciente(c.getPaciente());

			ControllerLinkBuilder linkto = linkTo(methodOn(ConsultaController.class).listarxId(c.getIdConsulta()));
			d.add(linkto.withSelfRel());
			consultaDTO.add(d);

			ControllerLinkBuilder linkto1 = linkTo(methodOn(PacienteController.class).listarxId(c.getPaciente().getIdPaciente()));
			d.add(linkto1.withSelfRel());
			consultaDTO.add(d);

			ControllerLinkBuilder linkto2 = linkTo(methodOn(MedicoController.class).listarxId(c.getMedico().getIdMedico()));
			d.add(linkto2.withSelfRel());
			consultaDTO.add(d);

		}
		return consultaDTO;
	}

	
	
	@PostMapping(value = "/registrar", produces = "application/json", consumes = "application/json ")
	public ResponseEntity<Object> registrar(@Valid @RequestBody ConsultaListaExamenDTO consDTO) {
		Consulta consulta = new Consulta();
		consulta = service.registrarTransaccional(consDTO);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(consulta.getIdConsulta()).toUri();

		return ResponseEntity.created(location).build();
	}

	
	
	@PutMapping(value = "/modificar", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Consulta> modificar(@RequestBody Consulta e) {
		service.modificar(e);
		return new ResponseEntity<Consulta>(HttpStatus.OK);
	}

	
	
	@DeleteMapping(value = "/eliminar", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Consulta c = service.listarxId(id);
		if (c == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
