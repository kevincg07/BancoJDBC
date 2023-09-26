package com.dto;

public class DescripcionCuenta {

	int numCuenta;
	String tipoCuenta;
	int saldoMax;
	int saldoMin;
	
	public DescripcionCuenta() {}

	public DescripcionCuenta(int numCuenta, String tipoCuenta, int saldoMax, int saldoMin) {
		this.numCuenta = numCuenta;
		this.tipoCuenta = tipoCuenta;
		this.saldoMax = saldoMax;
		this.saldoMin = saldoMin;
	}

	public int getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public int getSaldoMax() {
		return saldoMax;
	}

	public void setSaldoMax(int saldoMax) {
		this.saldoMax = saldoMax;
	}

	public int getSaldoMin() {
		return saldoMin;
	}

	public void setSaldoMin(int saldoMin) {
		this.saldoMin = saldoMin;
	}

	@Override
	public String toString() {
		return "DescripcionCuenta [numCuenta=" + numCuenta + ", tipoCuenta=" + tipoCuenta + ", saldoMax=" + saldoMax
				+ ", saldoMin=" + saldoMin + "]";
	}
	
	
	
	
}
