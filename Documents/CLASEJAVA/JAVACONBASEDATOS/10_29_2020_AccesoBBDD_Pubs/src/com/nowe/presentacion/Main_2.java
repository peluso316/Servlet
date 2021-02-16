/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowe.presentacion;

import com.nowe.persistencia.Acceso_Pubs;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Programacion
 */
public class Main_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Instanciar la clase Acceso_Pubs para ejecutar el método de obtener todos jobs
        
        Acceso_Pubs ap1 = new Acceso_Pubs();
        try {
            System.out.println(ap1.obtenerTodosJobs());
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
}
