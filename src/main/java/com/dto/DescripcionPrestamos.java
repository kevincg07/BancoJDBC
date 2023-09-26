package com.dto;

import java.sql.Date;

public class DescripcionPrestamos {

	int monto;
	Date fecha;
	
	public DescripcionPrestamos() {}
	
	public DescripcionPrestamos(int monto, Date fecha) {
		this.monto = monto;
		this.fecha = fecha;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "DescripcionPrestamos [monto=" + monto + ", fecha=" + fecha + "]";
	}
	
	
	
}
