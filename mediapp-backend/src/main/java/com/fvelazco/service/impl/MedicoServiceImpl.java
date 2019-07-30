package com.fvelazco.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fvelazco.dao.IMedicoDAO;
import com.fvelazco.model.Medico;
import com.fvelazco.service.MedicoService;
@Service
public class MedicoServiceImpl implements MedicoService{

	@Autowired
	private IMedicoDAO dao; ;
	
	@Override
	public Medico registrar(Medico t) {
		return dao.save(t);
	}

	@Override
	public Medico modificar(Medico t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(Integer id) {
		dao.delete(id);
		
	}

	@Override
	public List<Medico> listar() {
		return dao.findAll();
	}

	@Override
	public Medico listarxId(Integer id) {
		return dao.findOne(id);
	}

}
