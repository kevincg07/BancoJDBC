package com.dto;

import java.util.ArrayList;
import java.util.List;

public class ClientePorCuenta {
	
	String nombre;
	String rfc;
	String numeroTelefono;
	List<DescripcionCuenta> des = new ArrayList<DescripcionCuenta>();
	
	public ClientePorCuenta() {}

	public ClientePorCuenta(String nombre, String rfc, String numeroTelefono, List<DescripcionCuenta> des) {
		this.nombre = nombre;
		this.rfc = rfc;
		this.numeroTelefono = numeroTelefono;
		this.des = des;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public List<DescripcionCuenta> getDes() {
		return des;
	}

	public void setDes(List<DescripcionCuenta> des) {
		this.des = des;
	}

	@Override
	public String toString() {
		return "ClientePorCuenta [nombre=" + nombre + ", rfc=" + rfc + ", numeroTelefono=" + numeroTelefono + ", des="
				+ des + "]";
	}
	
	

}
