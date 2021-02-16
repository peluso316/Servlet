package com.nowe.negocio;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nowe.modelo.Producto;
import com.nowe.persistencia.AccesoTiendaWeb;

public class Carrito implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Atributos
	private List<Producto> contenido = new ArrayList<Producto>();
	private double importe;
	
	public Carrito() {
		// TODO Auto-generated constructor stub
	}
	
	public void addProducto(int id) throws ClassNotFoundException, SQLException {
		//Llamada a la capa acceso a BBDD
		AccesoTiendaWeb atw1 = new AccesoTiendaWeb();
		Producto p = atw1.buscar(id);
		System.out.println("Producto de la BBDD " + p.toString());
		//A�adir a contenido el producto obtenido de la BBD
		contenido.add(p);
		importe += p.getPrecio();
	}

	public List<Producto> getContenido() {
		return contenido;
	}

	public void setContenido(List<Producto> contenido) {
		this.contenido = contenido;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	
	
	

}
