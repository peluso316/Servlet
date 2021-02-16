/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowe.presentacion;

import com.nowe.persistencia.Acceso_Pubs;
import java.sql.SQLException;


/**
 *
 * @author Programacion
 */
public class Main_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instanciar la clase Acceso_Pubs
        Acceso_Pubs ap1 = new Acceso_Pubs();
        try {
            System.out.println("Ventas -> " + ap1.obtenerVentasTienda("Bookbeat"));
            System.out.println("Ventas -> " + ap1.obtenerVentasTiendaPreparedStatement("Bookbeat"));
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
}
