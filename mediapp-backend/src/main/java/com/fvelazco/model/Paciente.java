package com.fvelazco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //Auto Increment / Identity
	private Integer idPaciente;
	@Column(name = "nombres",length = 70, nullable = false)//No acepta nulos
	private String nombres;
	@Column(name = "apellidos",length = 70, nullable = false)
	private String apellidos;
	@Column(name = "dni",length = 8, nullable = false)
	private String dni;
	@Column(name = "direccion",length = 150, nullable = false)
	private String direccion;
	@Column(name = "telefono",length = 9, nullable = false)
	private String telefono;
	@Column(name = "email",length = 50, nullable = true)
	private String email;
	
	
	public Integer getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
