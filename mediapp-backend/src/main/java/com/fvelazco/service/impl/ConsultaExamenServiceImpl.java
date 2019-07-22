package com.fvelazco.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fvelazco.dao.IConsultaExamenDAO;
import com.fvelazco.model.ConsultaExamen;
import com.fvelazco.service.ConsultaExamenService;

@Service
public class ConsultaExamenServiceImpl implements ConsultaExamenService{
	
	@Autowired
	private IConsultaExamenDAO dao ;

	@Override
	public ConsultaExamen registrar(ConsultaExamen t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConsultaExamen modificar(ConsultaExamen t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ConsultaExamen> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConsultaExamen listarxId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
