package com.fvelazco.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fvelazco.model.Paciente;

public interface IPacienteDAO extends JpaRepository<Paciente, Integer>{

}
