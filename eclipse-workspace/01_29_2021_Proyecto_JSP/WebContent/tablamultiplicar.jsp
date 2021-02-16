<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tabla de multiplicar del 5</title>
</head>
<body>
<%int jNumero = Integer.parseInt(request.getParameter("numero")); %>
<h1>Tabla de multiplicar del <%=jNumero %></h1>
<br/>
<table border="4">
	<%for(int i=1; i<=10; i++){ %>
		<tr>
			<td><%=jNumero %> </td>
			<td> x </td>
			<td> <%=i %></td>
			<td>=</td>
			<td> <%=jNumero*i %> </td>
		</tr>
	<%} %>
</table>

</body>
</html>