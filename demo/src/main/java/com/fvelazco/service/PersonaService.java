package com.fvelazco.service;

import java.util.List;

import com.fvelazco.model.Persona;

public interface PersonaService {
	
	public Persona crear(Persona per);
	public Persona modificar(Persona per);
	public Persona listapoId(Integer id);
	public List<Persona>listar();
	public void eliminar(Integer id);


}
