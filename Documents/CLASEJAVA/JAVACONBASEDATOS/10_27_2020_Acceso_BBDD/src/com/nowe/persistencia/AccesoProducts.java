/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowe.persistencia;

import com.nowe.modelo.Agenda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Programacion
 */
public class AccesoProducts extends Conexion{
    
    
    public String ConsultaAgenda(Agenda ag1) throws ClassNotFoundException, SQLException{
    String texto = null;
    String nombre;
    String email;
    String telefono;
    abrirConexion();
    
    
    PreparedStatement pstmt = miConexion.prepareStatement("SELECT * FROM CONTACTOS WHERE ID=?"); 
    pstmt.setString(1, String.valueOf(ag1.getIdagenda()));
    ResultSet rs = pstmt.executeQuery();
    while (rs.next()) { 
       nombre = rs.getString("NOMBRE");	               
        email = rs.getString("EMAIL");
       telefono = rs.getString("TELEFONO");
       texto="El nombre es:   "+ nombre +"    ,El Email es:  " +email  +"     ,El Telefono es:   " +telefono;
    
    }
    
    rs.close();
    cerrarConexion();
    
    
      
    return texto;
    
    }
    public boolean ModificarAgenda(Agenda ag1) throws ClassNotFoundException, SQLException{
    int reg=0;
    abrirConexion();
    
    PreparedStatement psUpdate = miConexion.prepareStatement("UPDATE CONTACTOS SET NOMBRE=?, EMAIL=?, TELEFONO=? WHERE ID=?"); 
    psUpdate.setString(1, ag1.getNombre());
    psUpdate.setString(2, ag1.getEmail());
    psUpdate.setDouble(3, ag1.getTelefono());
    psUpdate.setInt(4, ag1.getIdagenda());
    
    reg=psUpdate.executeUpdate(); 
    cerrarConexion();
    
    return reg>0;
    }
    public boolean BajaAgenda(Agenda ag1) throws ClassNotFoundException, SQLException{
     int reg=0;
    abrirConexion();
    
    PreparedStatement psDelete = miConexion.prepareStatement("DELETE FROM CONTACTOS WHERE ID=?"); 
    psDelete.setInt(1, ag1.getIdagenda());
    
    reg=psDelete.executeUpdate(); 
    cerrarConexion();
    return reg>0;

    }
    
    public boolean AltaAgenda(Agenda ag1) throws ClassNotFoundException, SQLException{
    int reg=0;
    abrirConexion();
    
    PreparedStatement psInsertar = miConexion.prepareStatement("INSERT INTO CONTACTOS (NOMBRE, EMAIL, TELEFONO) values (?, ?, ?)"); 
    psInsertar.setString(1, ag1.getNombre());
    psInsertar.setString(2, ag1.getEmail());
    psInsertar.setDouble(3, ag1.getTelefono());
    
    reg=psInsertar.executeUpdate(); 
    cerrarConexion();
    return reg>0;
}
    
   
    
}
