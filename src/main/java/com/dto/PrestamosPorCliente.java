package com.dto;

import java.util.ArrayList;
import java.util.List;

public class PrestamosPorCliente {
	
	String nombre;
	List<DescripcionPrestamos> prestamos = new ArrayList<DescripcionPrestamos>();
	
	public PrestamosPorCliente() {}

	public PrestamosPorCliente(String nombre, List<DescripcionPrestamos> des) {
		this.nombre = nombre;
		this.prestamos = des;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<DescripcionPrestamos> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<DescripcionPrestamos> des) {
		this.prestamos = des;
	}

	@Override
	public String toString() {
		return "PrestamosPorCliente [nombre=" + nombre + ", des=" + prestamos + "]";
	}
	
	

}
