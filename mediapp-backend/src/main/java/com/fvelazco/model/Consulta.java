package com.fvelazco.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;


@Table(name = "consulta")
@Entity
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConsulta;
	
	
	
	@ManyToOne //Muchos a uno
	@JoinColumn(name = "id_paciente",nullable = false)//,foreignKey = @ForeignKey(name="consulta_paciente"))//La columa que une a ambas tablas(llave foranea)
	private Paciente paciente;
	
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_medico",nullable = false)//,foreignKey = @ForeignKey(name="consulta_medico"))//La columa que une a ambas tablas(llave foranea)
	private Medico medico;
	
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_especialidad",nullable = false)//,foreignKey = @ForeignKey(name="consulta_especialidad"))//La columa que une a ambas tablas(llave foranea)
	private Especialidad especialidad;
	
	

	//ISODate  ->  2019-10-01T05:00:00:0000
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fecha;
	
	
	
	
	
	//                        Mapeado -  En cascada (Permisos (REGISTRAR;LISTAR;ELIMINAR) - ALCANCE DE LA LISTA, LAZY=RENDIMIENTO EAGER=DATA MENOR  -  REMOVER ELEMENTOS )
	@OneToMany(mappedBy = "consulta",  cascade = {CascadeType.PERSIST,CascadeType.REMOVE,
			   CascadeType.MERGE},  fetch = FetchType.LAZY,  orphanRemoval = true)
	private List<DetalleConsulta> detalleConsulta;


	
	
	
	
	
	
	
	public List<DetalleConsulta> getDetalleConsulta() {
		return detalleConsulta;
	}
	public void setDetalleConsulta(List<DetalleConsulta> detalleConsulta) {
		this.detalleConsulta = detalleConsulta;
	}
	
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idConsulta == null) ? 0 : idConsulta.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		if (idConsulta == null) {
			if (other.idConsulta != null)
				return false;
		} else if (!idConsulta.equals(other.idConsulta))
			return false;
		return true;
	}
	
	
	
	

}
