/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowe.presentación;

/**
 *
 * @author Programacion
 */
public class Main_printf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declaración de variables
        
        String nombre = "Juan Perez";
        float nota = 3.5f;
        System.out.printf("Nombre del alumno \t nota %n");
        System.out.printf(" %20s \t %.2f", nombre, nota);
        
    }
    
}
