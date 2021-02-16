/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowe.presentación;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Programacion
 */
public class MainLecturaTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Leer el fichero de notas (separado por el caracter |) y obtener el promedio
        //1. Definir variables
        FileReader fEntrada;
        BufferedReader b;
        double promedio, notas, suma=0;
        int contadorNotas=0;
        String linea;
              
        try {
            //2. Instanciar los objetos para leer el fichero
            fEntrada = new FileReader("notas.txt");
            b = new BufferedReader(fEntrada);
            
            
            
            //3. Bucle para leer el fichero
            while ((linea = b.readLine())!=null) {
                String[] partes = linea.split("\\|");
                for (int i = 0; i < partes.length; i++) {
                    System.out.println("parte ->" + partes[i]);
                      suma += Double.parseDouble(partes[i]);
                      contadorNotas++;                     
                }
            }
           
            //4. Cerrar el fichero
            b.close();
            fEntrada.close();
            
            //5. Mostrar el promedio
            promedio = suma / contadorNotas;
            System.out.printf("El promedio de las notas es %.2f", promedio);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
    
}
