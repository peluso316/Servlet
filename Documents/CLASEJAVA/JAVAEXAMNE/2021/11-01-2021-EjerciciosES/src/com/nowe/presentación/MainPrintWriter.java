/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowe.presentación;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Programacion
 */
public class MainPrintWriter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Leer por pantalla en un bucle numeros que representan las notas y escribirlas en un fichero
        // hay que separarlas con el caracter | . El nombre del fichero se pide por consola también
        
        //Mejora 1 -> Cada 5 notas hay que hacer un salto de línea
        
        // 1. Declaración de variables

        Scanner s1 = new Scanner(System.in);
        String nFichero = null, respuesta;
        PrintWriter fSalida;
        double nota;
        int i = 0;

        // 2. Solicitar el nombre del fichero
        System.out.println("Escriba el nombre del fichero para guardar las notas --> ");
       
        nFichero = s1.nextLine();
        try {
            fSalida = new PrintWriter(nFichero);
            do {
                nota = leerNumero();
                fSalida.print(nota);
                fSalida.print("|");   
                
                i++;
                if (i==5) {
                    fSalida.print("\n");
                    i=0;
                }
                System.out.println("Desea continuar grabando notas (S/N) ? -->");
                respuesta = s1.nextLine();      
            } while (respuesta.equalsIgnoreCase("s"));
            
           
            fSalida.close();
            
            
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        }

    }

    public static double leerNumero() {
        double numero;
        Scanner teclado = new Scanner(System.in);

        while (true) {
            System.out.print("Escriba un número --> ");
            try {
                numero = teclado.nextDouble();
            } catch (InputMismatchException x) {
                System.out.println(x.toString());
                System.out.println("Intentelo otra vez");
                teclado.next();
                continue;
            }
            break;
        }
        return numero;

    }

}
