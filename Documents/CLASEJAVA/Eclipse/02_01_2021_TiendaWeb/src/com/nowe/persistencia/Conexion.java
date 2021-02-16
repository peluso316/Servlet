package com.nowe.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	protected Connection miConexion;
	
	public void abrirConexion() throws ClassNotFoundException, SQLException{
		//Indicar el nombre del driver 
		Class.forName("com.mysql.jdbc.Driver");
        miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendaweb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false",
                "root", "root");  
        System.out.println("�xito al abrir la conexi�n");
	}
	public void cerrarConexion() throws SQLException {
		miConexion.close();
	}

}
