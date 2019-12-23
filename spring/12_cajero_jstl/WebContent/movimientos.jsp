<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Cuenta, model.Movimiento, java.util.List"%>
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
		<br/><br/>
		<%--<p>Saldo de la cuenta: <%=(double)request.getAttribute("getSaldo")%></p>--%>
		<p>Saldo de la cuenta: ${sessionScope.getSaldo}</p><!-- Esto es una expresion -->
		<c:set var="movimientos" value="${requestScope.getMovimientos}"/>
		<!-- Comprobamos si hay elementos en movimientos y si no hay no lo muestra -->
		<%--<c:if test="${!empty movimientos}">--%>
		<!--  Si queremos que dependiendo de la condicion hace una cosa u otra, usamos un choose,
		si no se da ninguna de las condiciones se pone otherwise para la ultima -->
		<c:choose>
		<c:when test="${!empty movimientos}">
		<table border=1>
			<tr><th>IDMovimiento</th><th>Tipo operacion</th><th>Fecha</th><th>Cantidad</th></tr>
			<%--<%List<Movimiento> movimientos=(List<Movimiento>)request.getAttribute("getMovimientos");
			for(Movimiento m: movimientos){--%>
			<!-- Etiqueta jstl. set es para crear variables -->
			<c:forEach var="m" items="${movimientos}">
				<tr>
				<!-- Se ponen directament elos atributos de un java bean -->
					<td>${m.cuenta.numeroCuenta}</td>
					<td>${m.operacion}</td>
					<td>${m.fecha}</td>
					<td>${m.cantidad}</td>
				</tr> 
			</c:forEach>
			<%-- <tr>
				<td><%=m.getCuenta().getNumeroCuenta()%></td>
				<td><%=m.getOperacion() %></td>
				<td><%=m.getFecha() %></td>
				<td><%=m.getCantidad() %></td>
			</tr> 
			<%} %>--%>
		</table>
		<%--</c:if>--%>
		</c:when>
		<%-- Ponemos el else --%>
		<c:otherwise>
			<p>Esta cuenta no tiene movimientos todavía.</p>
		</c:otherwise>
		</c:choose>
		<br/><br/>
		<a href="toMenu">Volver</a><br/><br/>
	</div>
</body>
</html>