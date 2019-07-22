package com.fvelazco.model;

import java.util.List;

public class ConsultaListaExamenDTO {

	private Consulta consulta;
	
	List<Examen> lstExamen;
	
	
	//SET - GET 

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public List<Examen> getLstExamen() {
		return lstExamen;
	}

	public void setLstExamen(List<Examen> lstExamen) {
		this.lstExamen = lstExamen;
	}

}
