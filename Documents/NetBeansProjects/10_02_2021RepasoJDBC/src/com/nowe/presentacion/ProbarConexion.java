/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowe.presentacion;

import com.nowe.persistencia.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author XPS
 */
public class ProbarConexion {
    
        public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Conexion c1 = new Conexion();
            try {
                c1.abrirConexion();
            } catch (ClassNotFoundException ex) {
              System.out.println(ex.toString());
            }
            
         System.out.println("Exito al abrir la conexion");  
        
    }
        
}
