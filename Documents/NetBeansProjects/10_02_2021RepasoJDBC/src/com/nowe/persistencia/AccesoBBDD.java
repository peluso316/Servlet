/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowe.persistencia;

import com.mysql.cj.jdbc.CallableStatement;
import com.nowe.modelo.Material;
import java.io.IOException;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author XPS
 */
public class AccesoBBDD extends Conexion{
  
  Conexion miConexion= new Conexion();

    
    
 public boolean altaMaterial(Material m1) throws ClassNotFoundException, SQLException{

// 1. Declarar variables
int reg = 0;
String sql = "EXEC alta_material ?,?,?";
CallableStatement query;

//2. Abrir la conexion
abrirConexion();

//3. Recobrar el statement de la conexion
query = miConexion.prepareCall(sql);
//3a. Darle valor a los parámetros
query.setString(1, m1.getNombre());
query.setString(2, m1.getDescripcion());
query.setDouble(3, m1.getVolumen());

//4 Ejecutar la query
reg = query.executeUpdate();
//5. Cerrar
query.close();
     try {
         cerrarConexion();
     } catch (IOException ex) {
          System.out.println(ex.toString());
     }
//6. devolver el resultado
return reg>0;
}

public boolean ModificaMaterial(Material m1) throws ClassNotFoundException, SQLException{

// 1. Declarar variables
int reg = 0;
String sql = "EXEC modifica_material ?,?,?,?";
CallableStatement query;

//2. Abrir la conexion
abrirConexion();

//3. Recobrar el statement de la conexion
query = miConexion.prepareCall(sql);
//3a. Darle valor a los parámetros
query.setInt(1,m1.getIdmaterial());
query.setString(1, m1.getNombre());
query.setString(2, m1.getDescripcion());
query.setDouble(3, m1.getVolumen());

//4 Ejecutar la query
reg = query.executeUpdate();
//5. Cerrar
query.close();
     try {
         cerrarConexion();
     } catch (IOException ex) {
          System.out.println(ex.toString());
     }
//6. devolver el resultado
return reg>0;
}

public boolean EliminaMaterial(Material m1) throws ClassNotFoundException, SQLException{

// 1. Declarar variables
int reg = 0;
String sql = "EXEC elimina_material ?";
CallableStatement query;

//2. Abrir la conexion
abrirConexion();

//3. Recobrar el statement de la conexion
query = miConexion.prepareCall(sql);
//3a. Darle valor a los parámetros
query.setInt(1,m1.getIdmaterial());

//4 Ejecutar la query
reg = query.executeUpdate();
//5. Cerrar
query.close();
     try {
         cerrarConexion();
     } catch (IOException ex) {
          System.out.println(ex.toString());
     }
//6. devolver el resultado
return reg>0;
}

}
