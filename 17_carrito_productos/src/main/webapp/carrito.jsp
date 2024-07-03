<%@page import="model.Producto,java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="CerrarSesionServlet">Cerrar sesión</a>
	<center></center>
		<%List<Producto> carrito=(List<Producto>)session.getAttribute("carrito");
		if(carrito!=null){%>
			
			<table border="1">
		
				<tr><th>Nombre</th><tr><th>Producto</th><th>Categoria</th>
					<%for(Producto pr:carrito) %>
					<tr>
						<td><%=pr.getNombre() %></td>
						<td><%=pr.getProducto() %></td>
						<td><%=pr.getCategoria() %></td>
						<td><a href="EliminarCarritoServlet?nombre=<%=pr.getNombre()%>">Eliminar</a></td>
						
						
					</tr>
			
		 	<% }%>
		 </table>
		 <% }%>
		 <br><br>
	 <a href="gestorDePedidos.html">volver</a>

</body>
</html>