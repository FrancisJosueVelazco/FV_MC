package com.fvelazco.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fvelazco.dao.IConsultaDAO;
import com.fvelazco.model.Consulta;
import com.fvelazco.service.ConsultaService;

@Service
public class ConsultaServiceImpl implements ConsultaService{
	
	@Autowired
	private IConsultaDAO dao;

	@Override
	public Consulta registrar(Consulta consulta) {
		consulta.getDetalleConsulta().forEach(det->det.setConsulta(consulta));
		return dao.save(consulta);
	}

	@Override
	public Consulta modificar(Consulta t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Consulta> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Consulta listarxId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
