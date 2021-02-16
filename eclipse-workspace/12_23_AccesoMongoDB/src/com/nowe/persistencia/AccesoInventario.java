package com.nowe.persistencia;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.nowe.modelo.Producto;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;


public class AccesoInventario extends Conexion {

public List<Producto> consultarTodos() throws UnknownHostException{
// 1. Declarar variables
List<Producto> lista = new ArrayList<Producto>();
// 2. Abrir conexion y obtener la coleccion
inicio();
// 3. Obtener los documentos con el método find
DBCursor rs = colecccion.find();
// 4. Recorrer el cursor
while (rs.hasNext()) {
	BasicDBObject bson = (BasicDBObject) rs.next();
    Producto p1 = new Producto(bson.getString("_id"),
   bson.getString("nombreProducto"),
   bson.getInt("cantidadExistencia"));
   lista.add(p1);
}
cerrarConexion();
return lista;

}

public void insertar(Producto nuevo) throws UnknownHostException {
	// 1. Declarar variables
	BasicDBObjectBuilder documento = BasicDBObjectBuilder.start();
	documento.append("_id", nuevo.getId());
	documento.append("nombreProducto", nuevo.getNombreProducto());
	documento.append("cantidadExistencia", nuevo.getCantidadExistencial());

	DBObject documentoMongo = documento.get();

	// 2. Abrir conexion y crear coleccion
	inicio();

	// 3. insertarlo
	colecccion.insert(documentoMongo);

	cerrarConexion();

 }

public void insertarArrayDocumentoEmbebido(Producto nuevo) throws UnknownHostException {
inicio();
BasicDBObject docSimple = new BasicDBObject();
//Usando el método put
docSimple.put("_id", nuevo.getId());
docSimple.put("nombre", nuevo.getNombreProducto());
docSimple.put("cantidad", nuevo.getCantidadExistencial());
colecccion.insert(docSimple);

//Instanciar un documento con un Array para insertarlo a la colección
BasicDBObject docArray = new BasicDBObject();
docArray.put("_id", nuevo.getId()+1);
docArray.put("nombre", nuevo.getNombreProducto());
docArray.put("cantidad", nuevo.getCantidadExistencial());
docArray.put("precios", Arrays.asList(15,16,17));
colecccion.insert(docArray);


//Instanciar un documento con un documento embebido
BasicDBObject docEmbebido = new BasicDBObject();
docEmbebido.put("_id", nuevo.getId()+2);
docEmbebido.put("nombre", nuevo.getNombreProducto());
docEmbebido.put("cantidad", nuevo.getCantidadExistencial());
docEmbebido.put("precios", Arrays.asList(15,16,17));
docEmbebido.put("almacenes", new BasicDBObject("calle","Calle real").append("numero",35)
.append("poblacion", "Madrid"));
colecccion.insert(docEmbebido);

//cerrar conexion
cerrarConexion();
}

}