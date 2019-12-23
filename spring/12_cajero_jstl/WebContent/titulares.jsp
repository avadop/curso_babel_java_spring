<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import=" model.Cliente, java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<c:set var="clientes" value="${requestScope.getTitulares}"/>
		<c:choose>
		<c:when test="${!empty clientes}">
		<table border=1>
			<tr><th>Nombre</th><th>DNI</th><th>Teléfono</th></tr>
			<c:set var="clientes" value="${requestScope.getTitulares}"/>
			<c:forEach var="c" items="${clientes}">
			<tr>
				<td>${c.nombre}</td>
				<td>${c.dni}</td>
				<td>${c.telefono}</td>
			</tr> 
			
			</c:forEach>
			<%--<%List<Cliente> clientes=(List<Cliente>)request.getAttribute("getTitulares");
			for(Cliente c: clientes){
			<tr>
				<td><%=c.getNombre()%></td>
				<td><%=c.getDni() %></td>
				<td><%=c.getTelefono() %></td>
			</tr> 
			<%} %>--%>
		</table>
		</c:when>
		<c:otherwise>
			<p>No tiene ningun titular esta cuenta</p>
		</c:otherwise>
		</c:choose>
		<br/><br/>
		<a href="toMenu">Volver</a><br/><br/>
	</div>
</body>
</html>