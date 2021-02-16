/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nowe.persistencia;

import com.nowe.modelo.Jobs;
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
public class Acceso_Pubs extends Conexion {

    public double obtenerVentasTienda(String nombreTienda) throws ClassNotFoundException, SQLException {
        //1. Declarar variables
        double resultado = 0;
        Statement cmd;
        ResultSet rs;
        String sql = "SELECT SUM(T.PRICE * sa.qty) AS VENTAS_TIENDA FROM stores AS S "
                + "INNER JOIN SALES AS SA ON S.stor_id = SA.stor_id "
                + "INNER JOIN TITLES AS T ON SA.title_id = T.title_id "
                + "WHERE stor_name = '" + nombreTienda + "';";

        // 2. Abrir conexion
        abrirConexion();
        // 3. Obtener el Statement de la Conexion
        cmd = miConexion.createStatement();
        // 4. Ejecutar el Statement
        rs = cmd.executeQuery(sql);
        // 5. Obtener los datos de ResultSet
        if (rs.next()) {
            resultado = rs.getDouble("VENTAS_TIENDA");
        }
        // 6. Cerrar la conexion
        cerrarConexion();
        // 7. Devolver el valor
        return resultado;
    }

    public List<Jobs> obtenerTodosJobs() throws ClassNotFoundException, SQLException {
        //1. Definición variables
        Statement cmd;
        ResultSet rs;
        List<Jobs> resultado = new ArrayList();
        String sql = "SELECT J.job_id, J.job_desc, J.max_lvl, J.min_lvl FROM JOBS J";
        //2. Abrir la conexion
        abrirConexion();
        //3. Obtener el comando de la conexion
        cmd = miConexion.createStatement();
        //4. Ejecutar el comando
        rs = cmd.executeQuery(sql);
        //5. Obtener los resultados
        while (rs.next()) {
            Jobs j1 = new Jobs(rs.getInt("job_id"),
                    rs.getString("job_desc"),
                    rs.getInt("max_lvl"),
                    rs.getInt("min_lvl"));
            resultado.add(j1);
        }
        //6. Cerrar la conexion
        cerrarConexion();
        //7. Devolver la lista de jobs
        return resultado;
    }
    
    public double obtenerVentasTiendaPreparedStatement(String nombreTienda) throws ClassNotFoundException, SQLException {
        //1. Declarar variables
        double resultado = 0;
        PreparedStatement cmd;
        ResultSet rs;
        String sql = "SELECT SUM(T.PRICE * sa.qty) AS VENTAS_TIENDA FROM stores AS S "
                + "INNER JOIN SALES AS SA ON S.stor_id = SA.stor_id "
                + "INNER JOIN TITLES AS T ON SA.title_id = T.title_id "
                + "WHERE stor_name = ?";

        // 2. Abrir conexion
        abrirConexion();
        // 3. Obtener el Statement de la Conexion
        cmd = miConexion.prepareStatement(sql);
        // 3a. asignarle valor a los parámentros
        cmd.setString(1, nombreTienda);
        // 4. Ejecutar el Statement
        rs = cmd.executeQuery();
        // 5. Obtener los datos de ResultSet
        if (rs.next()) {
            resultado = rs.getDouble("VENTAS_TIENDA");
        }
        // 6. Cerrar la conexion
        cerrarConexion();
        // 7. Devolver el valor
        return resultado;
    }

}
