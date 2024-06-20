<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>el usuario <%=request.getParameter("username") %></h2>
		<h2>con contraseña <%=request.getParameter("password") %></h2>
		<h2>no es valido</h2>
		<a href='login.html'>Volver</a>
	
	</center>

</body>
</html>