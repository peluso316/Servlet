/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowe.persistencia;

import com.mysql.cj.jdbc.CallableStatement;

import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author XPS
 */
public class Conexion {
    
 protected Connection miConexion;

  public void abrirConexion() throws ClassNotFoundException, SQLException{
   //Indicar el nombre del driver
  // Class.forName("com.mysql.cj.jdbc.Driver");
  // miConexion = (Connection) DriverManager.getConnection
  //("jdbc:mysql://localhost:3306/constructura?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false",
  // "root", "root");
   //System.out.println("Éxito al abrir la conexión");
     //Cargar el driver
    //sql server

    //        
            
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String stringConexion =  "jdbc:sqlserver:/localhost:1433;" +
                       "databaseName=constructura;" +
                       "user=alumno2;" +
                        "password=alumno2;" +
                      "encrypt=false;" +
                     "trustServerCertificate=false;" +
                      "loginTimeout=30;";
        miConexion = (Connection) DriverManager.getConnection(stringConexion);
        System.out.println("Exito al abrir la conexion");
    
  }
  
  
  public void cerrarConexion() throws SQLException, IOException {
  miConexion.close(); 
  }

    CallableStatement prepareCall(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
