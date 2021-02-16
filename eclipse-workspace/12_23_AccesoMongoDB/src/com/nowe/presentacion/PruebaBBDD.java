package com.nowe.presentacion;

import java.net.UnknownHostException;

import com.nowe.modelo.Producto;
import com.nowe.persistencia.*;
import com.nowe.persistencia.Conexion;


public class PruebaBBDD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Conexion c1 = new Conexion();
		//c1.abrirConexion();
		
		/*AccesoInventario ai1 = new AccesoInventario();
		try {
			ai1.consultarTodos();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		// Crear un producto
		Producto p1 = new Producto("1", "Prueba desde java", 1);
		AccesoInventario ai1 = new AccesoInventario();
		try {
		ai1.insertar(p1);
		} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		System.out.println(e.toString());}
  }
}