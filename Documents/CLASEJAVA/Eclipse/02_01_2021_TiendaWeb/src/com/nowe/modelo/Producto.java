package com.nowe.modelo;

public class Producto {
	
	//Atributos
	private int idproducto;
	private String nombre;
	private double precio;
	private int cantidadExistencia;
	private String rutaImagen;
	
	
	//Métodos
	
	
	//Constructores
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Producto [idproducto=" + idproducto + ", nombre=" + nombre + ", precio=" + precio
				+ ", cantidadExistencia=" + cantidadExistencia + ", rutaImagen=" + rutaImagen + "]";
	}

	public Producto(int idproducto, String nombre, double precio, int cantidadExistencia) {
		super();
		this.idproducto = idproducto;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidadExistencia = cantidadExistencia;
	}
	
	

	public Producto(int idproducto, String nombre, double precio, int cantidadExistencia, String rutaImagen) {
		super();
		this.idproducto = idproducto;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidadExistencia = cantidadExistencia;
		this.rutaImagen = rutaImagen;
	}

	//Setters y Getters
	
	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidadExistencia() {
		return cantidadExistencia;
	}

	public void setCantidadExistencia(int cantidadExistencia) {
		this.cantidadExistencia = cantidadExistencia;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	
	
	
	
	
	

}
