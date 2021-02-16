<%@page import="com.nowe.modelo.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="Stylesheet" href="estilos/estilos.css"/>
<title>Productos</title>
</head>
<body>
<header>
<img class="redondo" src="imagenes/fondo.jpg" alt="batman"/>
<h1>Tienda online</h1>
<div class="topnav">
  <a href="stodosproductos">Mostrar todos los productos</a>
  <a href="mostrarcarrito.jsp">Mostrar carrito</a>
  <a href="#">Link</a>
</div>
</header>
<h1>Productos diponibles</h1>
<% List<Producto> productos = (List<Producto>) request.getAttribute("jspProductos"); %>
<table>
	<tr>
		<th>Imagen</th>
		<th>Numero producto </th>
		<th>Nombre</th>
		<th>Precio</th>
		<th>Cantidad en tienda</th>
		<th>Añadir al carrito</th>
	</tr>
<% for(Producto p : productos) {%>
	<tr>
		<td>
		
			<img class="imagenProductos"  src="imagenes/<%=p.getRutaImagen()%>" />
		</td>
		<td><%=p.getIdproducto() %> </td>
		<td><%=p.getNombre() %></td>
		<td><%=p.getPrecio() %></td>
		<td><%=p.getCantidadExistencia() %></td>
		<td>
			<a href="saddcarrito?id=<%=p.getIdproducto()%>">Añadir al carrito
			</a>
		</td>	
	</tr>

<%} %>
</table>

</body>
</html>