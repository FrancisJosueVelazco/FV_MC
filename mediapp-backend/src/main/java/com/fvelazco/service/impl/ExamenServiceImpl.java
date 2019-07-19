package com.fvelazco.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fvelazco.dao.IExamenDAO;
import com.fvelazco.model.Examen;
import com.fvelazco.service.ExamenService;

@Service
public class ExamenServiceImpl implements ExamenService {

	@Autowired
	private IExamenDAO dao;

	@Override
	public Examen registrar(Examen t) {
		return dao.save(t);
	}

	@Override
	public Examen modificar(Examen t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(Integer id) {
		dao.delete(id);

	}

	@Override
	public List<Examen> listar() {
		return dao.findAll();
	}

	@Override
	public Examen listarxId(Integer id) {
		return dao.findOne(id);
	}

}
