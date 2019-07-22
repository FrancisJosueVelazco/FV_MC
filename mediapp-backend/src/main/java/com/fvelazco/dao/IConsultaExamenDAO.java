package com.fvelazco.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fvelazco.model.ConsultaExamen;
@Repository
public interface IConsultaExamenDAO extends JpaRepository<ConsultaExamen, Integer>{
	
	@Query(value = "INSERT INTO consulta_examen(id_consulta,id_examen)VALUES(:idConsulta,:idExamen)",nativeQuery = true)
	Integer registrar(@Param ("idConsulta")Integer idConsulta,@Param("idExamen")Integer idExamen);
 
}
