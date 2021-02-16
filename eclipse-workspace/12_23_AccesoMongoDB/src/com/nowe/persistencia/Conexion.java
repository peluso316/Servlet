package com.nowe.persistencia;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Conexion {

	protected MongoClient conexion;
	protected DB db;
	protected DBCollection colecccion;
	
	public void abrirConexion()
	{
		//abrir la conexion desde el servidor
		conexion = new MongoClient("localhost",27017);
		System.out.println("Si se pudo conectar");
		
		db=conexion.getDB("video");
		System.out.println("La base de datos es ... " + db.getName());
				
	}
	protected  void crearColeccion()
	{
		colecccion = db.getCollection("productos");
		System.out.println("Obtiene la coleccion " + colecccion.getFullName());
		System.out.println("Registros : "+ colecccion.count());
	}
	protected void cerrarConexion() {
		 conexion.close();
	} 
	protected void inicio() {
		abrirConexion();
		cerrarConexion();
		
	}
	
}
