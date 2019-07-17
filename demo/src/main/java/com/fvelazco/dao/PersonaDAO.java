package com.fvelazco.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.fvelazco.model.Persona;

//Estereotipo que define a la clase como REPOSITORY(Acceso a datos-sin logica), ademas de registrarlo en el Contenedor de Beans
@Repository
public interface PersonaDAO extends JpaRepository<Persona, Integer> {

}
