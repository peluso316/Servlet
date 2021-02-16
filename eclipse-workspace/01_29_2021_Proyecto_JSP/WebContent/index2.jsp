<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Indice </h1>
<ol>
	<li><a href="datos.html">Tablas de multiplicar con JSP</a></li>
	<li><a href="formulario1.html">Formulario con resultado en JSP</a></li>
</ol>
<br/>
<br/>
<h2>Codigo java </h2>
<%for(int i=0; i<10; i++){ %>
	Saludos <%=i%>
	<br/>
	<%} %>

</body>
</html>