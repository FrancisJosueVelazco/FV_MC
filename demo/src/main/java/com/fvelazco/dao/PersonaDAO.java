package com.fvelazco.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fvelazco.model.Persona;

public interface PersonaDAO extends JpaRepository<Persona, Integer> {

}
