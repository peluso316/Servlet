package com.nowe.persistencia;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nowe.modelo.Producto;
import com.nowe.modelo.Usuario;

public class AccesoTiendaWeb extends Conexion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Usuario obtenerPassword(String usuario) throws ClassNotFoundException, SQLException {
		//1. Declaración de variables
		Usuario u1 = null;
		CallableStatement st;
		ResultSet rs;
		//2. abrir la conexion
		abrirConexion();
		//3. Obtener statement de la conexión
		st = miConexion.prepareCall("call tienda_web.verificar_usuario(?);");
		st.setString(1, usuario);
		
		//4. Ejecutar el statement
		rs = st.executeQuery();
		//5. Obtener el resultado
		if (rs.next()) {
			String password = rs.getString("password");
			String nombre = rs.getString("nombre");
			u1 = new Usuario(password, nombre);
		}
		rs.close();
		st.close();
		cerrarConexion();
		return u1;
	}
	
	public List<Producto> obtenerTodos() throws ClassNotFoundException, SQLException{
		//1. Definir variables
		//1a. Variables
		List<Producto> productos = new ArrayList<Producto>();
		String sql = "Select idproducto, nombre, precio, cantidadExistencia, rutaImagen from productos";
		//1b. Variables de acceso a BBDD
		Statement query;
		ResultSet rs;
		//2. Abrir conexion
		abrirConexion();
		//3. Obtener el statement de la conexion
		query = miConexion.createStatement();
		//4. Ejecutar el statement (Query)
		rs = query.executeQuery(sql);
		//5. Recorrer el resulset para generar la colección de productos
		while (rs.next()) {
			//Recoger los datos del ResultSet
			int idproducto = rs.getInt("idproducto");
			String nombre = rs.getString("nombre");
			double precio = rs.getDouble("precio");
			int cExistencia = rs.getInt("cantidadExistencia");
			String rImagen = rs.getString("rutaImagen");
			// Instanciar un producto
			Producto p1 = new Producto(idproducto, nombre, precio, cExistencia, rImagen);
			//Añadir a la colección
			productos.add(p1);
		}
		//6. Cerrar resultset, statement, conexion
		rs.close();
		query.close();
		cerrarConexion();
		//7. Devolver la colección de productos
		return productos;
	}
	
	public Producto buscar(int id) throws ClassNotFoundException, SQLException {
		//1. Declarar variables
		Producto p1 = null;
		String sql = "select nombre, precio, cantidadExistencia from productos where idproducto = ?";
		// 1b. variables de acceso a BBDD
		PreparedStatement query;
		ResultSet rs;
		// 2. abrir conexion
		abrirConexion();
		// 3. Obtener el statement de la conexion
		query = miConexion.prepareStatement(sql);
		
		// 3a. Asignar valor a los parámetros
		query.setInt(1, id);
		// 4. Ejecutar la stament
		rs = query.executeQuery();
		// 5. Obtener los datos del resultset para crear la instancia de producto
		if (rs.next()) {
			//Recoger los datos de la BBDD
			String nombre = rs.getString("nombre");
			double precio = rs.getDouble("precio");
			int cExistencia = rs.getInt("cantidadExistencia");
			p1 = new Producto(id, nombre, precio, cExistencia);
		}
		// 6. Cerrar 
		rs.close();
		query.close();
		cerrarConexion();
		// 7. Devolver el producto ya con sus datos
		return p1;
	}
}
