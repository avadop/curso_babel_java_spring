<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Pais"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Paises</h1>
		<c:set var="paises" value="${requestScope.getPaises}"/>
		<form action="clickPais" method="POST">
			<select name="nombre">
				<c:forEach var="p" items="${paises}">
					<option>${p.nombre}</option>
				</c:forEach>
			</select>
			<br><br>
			<input type="submit" value="DATOS">
		</form><br/><br/>
	</div>
</body>
</html>