/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowe.presentación;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Programacion
 */
public class MainPrintWriterPrintf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Leer por pantalla en un bucle 
        El dni del alumno, el nombre y la nota
         */

        // 1. Declaración de variables
        Scanner s1 = new Scanner(System.in);
        String nFichero = null, respuesta, numDNI, nombre;
        PrintWriter fSalida;
        double nota;
       

        // 2. Solicitar el nombre del fichero
        System.out.println("Escriba el nombre del fichero para guardar las notas --> ");    
        nFichero = s1.nextLine();
        try {
            // Instanciar el objeto PrintWriter para escribir el fichero
            fSalida = new PrintWriter(nFichero);
            // Mandar llamar a la rutina del cabecero
            cabecero(fSalida);
            do {
                System.out.println("Escribir el DNI del alumno -->");
                numDNI = s1.nextLine();
                System.out.println("Escribir el nombre del alumno --> ");
                nombre = s1.nextLine();
                nota = leerNumero();
                fSalida.printf("%-10s %-25s \t %.2f%n", numDNI, nombre, nota);
                
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

    public static void cabecero(PrintWriter fS) {
        for (int i = 0; i < 55; i++) {
            fS.printf("-");
        }
        fS.printf("%n");
        fS.printf("DNI \t  Nombre \t \t Nota");
        fS.printf("%n");
        for (int i = 0; i < 55; i++) {
            fS.write("-");
        }
        fS.printf("%n");
    }
}
