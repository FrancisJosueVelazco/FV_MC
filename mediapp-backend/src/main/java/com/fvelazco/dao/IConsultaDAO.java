package com.fvelazco.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fvelazco.model.Consulta;

@Repository
public interface IConsultaDAO extends JpaRepository<Consulta, Integer>{

}
