/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowe.modelo;

/**
 *
 * @author XPS
 */
public class Agenda {
    //atributos (base datos de la tabla agenda)
    private int idagenda;
    private String nombre;

    public Agenda(int idagenda) {
        this.idagenda = idagenda;
    }
    private String email;
    private double telefono;
    
    public Agenda() {
    }

    public Agenda(int idagenda, String nombre, String email, double telefono) {
        this.idagenda = idagenda;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public Agenda(String nombre, String email, double telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Agenda{" + "idagenda=" + idagenda + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + '}';
    }

    public int getIdagenda() {
        return idagenda;
    }

    public void setIdagenda(int idagenda) {
        this.idagenda = idagenda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getTelefono() {
        return telefono;
    }

    public void setTelefono(double telefono) {
        this.telefono = telefono;
    }
    
    
    
}
