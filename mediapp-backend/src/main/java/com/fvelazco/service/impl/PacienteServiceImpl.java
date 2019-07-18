package com.fvelazco.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fvelazco.dao.IPacienteDAO;
import com.fvelazco.model.Paciente;
import com.fvelazco.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService{
	
	@Autowired
	private IPacienteDAO dao;

	@Override
	public Paciente registrar(Paciente t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public Paciente modificar(Paciente t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public void eliminar(Integer id) {
		dao.delete(id);
		// TODO Auto-generated method stub
	}

	@Override
	public List<Paciente> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Paciente listarxId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}

}
