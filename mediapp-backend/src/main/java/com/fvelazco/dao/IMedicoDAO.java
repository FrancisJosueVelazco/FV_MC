package com.fvelazco.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fvelazco.model.Medico;
@Repository
public interface IMedicoDAO extends JpaRepository<Medico, Integer>{

}
