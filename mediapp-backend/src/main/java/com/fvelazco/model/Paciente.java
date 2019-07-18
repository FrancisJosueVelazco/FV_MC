package com.fvelazco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Informacion del paciente")
@Entity
@Table(name = "paciente")
public class Paciente {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //Auto Increment / Identity
	private Integer idPaciente;
	
	@ApiModelProperty(notes = "El valor nombre tiene que ser mayor a 5 carácteres")
	@Size(min = 5,max = 200,message = "El valor nombre tiene que ser mayor a 5 carácteres")
	@Column(name = "nombres",length = 70, nullable = false)//No acepta nulos
	private String nombres;
	
	@ApiModelProperty(notes = "El valor apellidos tiene que ser mayor a 5 carácteres")
	@Size(min = 5,max = 200,message = "El valor apellidos tiene que ser mayor a 5 carácteres")
	@Column(name = "apellidos",length = 70, nullable = false)
	private String apellidos;
	
	@ApiModelProperty(notes = "El valor dni tiene que ser de 8 carácteres")
	@Size(min = 8,max = 8,message = "El valor dni tiene que ser de 8 carácteres")
	@Column(name = "dni",length = 8, nullable = false)
	private String dni;
	
	@ApiModelProperty(notes = "El valor dirección tiene que ser mayor a 10 carácteres")
	@Size(min = 10,max = 200,message = "El valor dirección tiene que ser mayor a 10 carácteres")
	@Column(name = "direccion",length = 150, nullable = false)
	private String direccion;
	
	@ApiModelProperty(notes = "El valor telefono tiene que ser entre 7 y 9 carácteres")
	@Size(min = 7,max = 9,message = "El valor telefono tiene que ser entre 7 y 9 carácteres")
	@Column(name = "telefono",length = 9, nullable = false)
	private String telefono;
	
	//@Email
	@ApiModelProperty(notes = "Con extensión de correo")
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
