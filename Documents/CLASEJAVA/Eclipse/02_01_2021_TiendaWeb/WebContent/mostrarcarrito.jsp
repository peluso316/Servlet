<%@page import="com.nowe.negocio.Carrito"%>
<%@page import="com.nowe.modelo.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="Stylesheet" href="estilos/estilos.css"/>
<title>Carrito</title>
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
<h1>Carrito</h1>
<% Carrito c1 = (Carrito) session.getAttribute("carrito");
if(c1 == null){
 %>
 <p>Carrito por el momento vacío</p>
 <%} else{ %>
 <p>El importe de su carrito es <%=c1.getImporte() %>
<table>
	<tr>
		<th>Numero producto </th>
		<th>Nombre</th>
		<th>Precio</th>
		<th>Cantidad en tienda</th>
		<th>Eliminar del carrito</th>
	</tr>
<% for(Producto p : c1.getContenido()) {%>
	<tr>
		<td><%=p.getIdproducto() %> </td>
		<td><%=p.getNombre() %></td>
		<td><%=p.getPrecio() %></td>
		<td><%=p.getCantidadExistencia() %></td>
		<td>
			<!--  <a href="saddcarrito?id=<%=p.getIdproducto()%>">Añadir al carrito
			</a> -->
		</td>	
	</tr>

<%} %>
</table>
<%} %>
<a href="stodosproductos">Continuar su compra</a>
</body>
</html>