package com.fvelazco.service;

import java.util.List;

public interface ICRUD<T> {
	
	T registrar(T t);
	T modificar(T t);
	void eliminar(Integer id);
	List<T>listar();
	T listarxId(Integer id);
}
