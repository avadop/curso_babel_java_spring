<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import=" model.Cliente, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<style>
th{
	padding: 5px;
	font-size: 20px;
}
td{
	padding: 7px;	
	text-align: center;
}
a{
	font-size: 22px;
}
p{
	font-size: 22px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Movimientos</h1>
		<br/>
		<p>Numero de la cuenta: <%=(int)session.getAttribute("getNumCuenta")%></p>
		<table border=1>
			<tr><th>Nombre</th><th>DNI</th><th>Teléfono</th></tr>
			<%List<Cliente> clientes=(List<Cliente>)request.getAttribute("getTitulares");
			for(Cliente c: clientes){%>
			<tr>
				<td><%=c.getNombre()%></td>
				<td><%=c.getDni() %></td>
				<td><%=c.getTelefono() %></td>
			</tr> 
			<%} %>
		</table>
		<br/><br/>
		<a href="toMenu">Volver</a><br/><br/>
	</div>
</body>
</html>