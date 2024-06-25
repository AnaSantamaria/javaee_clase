
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="CerrarSesionServlet">Cerrar sesión</a>
	<center>
		<c:choose>
	
					<c:when test="${not empty sessionScope.carrito }">
					
						<table border="1">
				
							<tr><th>Nombre</th><tr><th>Producto</th><th>Categoria</th>
								<c:forEach var="pr" items="${sessionScope.carrito}">
								
									<tr>
										<td>${pr.nombre}</td>
										<td>${pr.precio}</td>
										<td>${pr.categoria}</td>
										<td><a href="EliminarCarritoServlet?nombre=${pr.nombre}">Eliminar</a></td>
									</tr>
									
								</c:forEach>
					
							 
						 </table>
					</c:when> 
						<c:otherwise>
							<h1>El carrito está vacío</h1>
						</c:otherwise>
			 </c:choose>
	 		<br><br>
	 		
	 <a href="gestorDePedidos">volver</a>
	</center>

</body>
</html>