package com.fvelazco.exception;

import java.util.Date;

public class ExceptionResponse {

	private Date timestap;
	private String mensaje;
	private String detalle;

	public ExceptionResponse(Date timestap, String mensaje, String detalle) {
		super();
		this.timestap = timestap;
		this.mensaje = mensaje;
		this.detalle = detalle;
	}

	public Date getTimestap() {
		return timestap;
	}

	public void setTimestap(Date timestap) {
		this.timestap = timestap;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

}
