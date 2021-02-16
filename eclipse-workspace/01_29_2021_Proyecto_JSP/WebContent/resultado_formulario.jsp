<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar datos del formulario</title>
</head>
<body>
<%String nombre, email, ciudad, genero;
String[] aficiones;
nombre=request.getParameter("nombre");
email=request.getParameter("email");
ciudad=request.getParameter("ciudad");
genero=request.getParameter("genero");
aficiones = request.getParameterValues("aficiones");
%>
<h1>Los datos proporcionados son :</h1>
Nombre : <%=nombre %> <br/>
Email : <%=email %> <br/>
Ciudad : <%=ciudad %> <br/>
Genero : <%= genero %> <br>
Aficiones
<% for(String elemento : aficiones){ %>
	<%=elemento %> , 
<%} %>

</body>
</html>