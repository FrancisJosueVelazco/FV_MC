package com.fvelazco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fvelazco.dao.PersonaDAO;
import com.fvelazco.model.Persona;

//Estereotipo que define a la clase como SERVICIO (Logica de negocio), ademas de registrarlo en el Contenedor de Beans.
@Service 
public class PersonaServiceImpl implements PersonaService{
	//Consultar al controlador de Bean la inyeccion de dependencias
	@Autowired
	private PersonaDAO dao; 

	@Override
	public Persona crear(Persona per) {
		return dao.save(per);
	}

	@Override
	public Persona modificar(Persona per) {
		return dao.save(per);
	}

	@Override
	public Persona listapoId(Integer id) {
		return  dao.findOne(id);
	}

	@Override
	public List<Persona> listar() {
		return  dao.findAll();
			
	}

	@Override
	public void eliminar(Integer id) {
		 dao.delete(id);
	}
	
	

}
