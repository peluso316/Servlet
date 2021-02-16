package com.nowe.modelo;

public class Producto {
private String id;
private String nombreProducto;
private int cantidadExistencial;


public Producto() {	
}

public Producto(String id, String nombreProducto, int cantidadExistencial) {
	super();
	this.id = id;
	this.nombreProducto = nombreProducto;
	this.cantidadExistencial = cantidadExistencial;
}


@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}


public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getNombreProducto() {
	return nombreProducto;
}


public void setNombreProducto(String nombreProducto) {
	this.nombreProducto = nombreProducto;
}


public int getCantidadExistencial() {
	return cantidadExistencial;
}


public void setCantidadExistencial(int cantidadExistencial) {
	this.cantidadExistencial = cantidadExistencial;
}




}
