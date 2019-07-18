package com.fvelazco.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name = "consulta")
@Entity
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConsulta;
	
	private LocalDateTime fecha;
	
	@ManyToOne //Muchos a uno
	@JoinColumn(name = "id_paciente",nullable = false)//,foreignKey = @ForeignKey(name="consulta_paciente"))//La columa que une a ambas tablas(llave foranea)
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name = "id_medico",nullable = false)//,foreignKey = @ForeignKey(name="consulta_medico"))//La columa que une a ambas tablas(llave foranea)
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name = "id_especialidad",nullable = false)//,foreignKey = @ForeignKey(name="consulta_especialidad"))//La columa que une a ambas tablas(llave foranea)
	private Especialidad especialidad;
	
	
	public Integer getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	
	
	
	

}
