package com.fvelazco.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice//detectar cualquier tipo de excepciones -Transversal  
@RestController//manejar todos las excepiones de los servicios rest
public class RespondeExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object>validarErrores(Exception ex,WebRequest request){
		ExceptionResponse response=new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(ModeloNotFoundException.class)//Metodo invocado cuando encuentre anotaciones de tipo "ModeloNotFoundException" 
	public final ResponseEntity<Object>manejarModeloExcepciones(ModeloNotFoundException ex,WebRequest request){
		
		ExceptionResponse response=new ExceptionResponse(new Date(), ex.getMessage(), 
				request.getDescription(false));
		
		return new ResponseEntity(response,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object>handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers,
			HttpStatus status,WebRequest request){
		String errores="";
		for (ObjectError e :ex.getBindingResult().getAllErrors()) {
			errores+=e.getObjectName();
		}
		ExceptionResponse response=new ExceptionResponse(new Date(), "Validación fallida", errores);
		
		return new  ResponseEntity(response,HttpStatus.BAD_REQUEST);
		
	}

}
