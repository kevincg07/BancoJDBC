package com.entity;

public class Clientes {
//	
//	ID_COSTUMER     NOT NULL NUMBER        
//	NOMBRE                   NVARCHAR2(30) 
//	DIRECCION                NVARCHAR2(40) 
//	NUMERO_TELEFONO          NUMBER(10)    
//	RFC                      NVARCHAR2(15)
	
	private int idCostumer;
	private String nombre;
	private String direccion;
	private String rfc;
	private String numeroTelefono;
	
	public Clientes() {}
	
	public Clientes(int idCostumer, String nombre, String direccion, 
			String rfc, String numeroTelefono) {
		this.idCostumer = idCostumer;
		this.nombre = nombre;
		this.direccion = direccion;
		this.rfc = rfc;
		this.numeroTelefono = numeroTelefono;
	}

	public int getIdCostumer() {
		return idCostumer;
	}

	public void setIdCostumer(int idCostumer) {
		this.idCostumer = idCostumer;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	@Override
	public String toString() {
		return "Clientes [idCostumer=" + idCostumer + ", nombre=" + nombre + ", direccion=" + direccion + ", rfc=" + rfc
				+ ", numeroTelefono=" + numeroTelefono + "]";
	}

	
	
	

}
