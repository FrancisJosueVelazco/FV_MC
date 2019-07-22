package com.fvelazco.service;

import com.fvelazco.model.Consulta;
import com.fvelazco.model.ConsultaListaExamenDTO;

public interface ConsultaService extends ICRUD<Consulta>{
	
	Consulta registrarTransaccional(ConsultaListaExamenDTO dto); 

}
