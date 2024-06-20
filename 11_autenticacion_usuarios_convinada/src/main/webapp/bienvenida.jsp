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
		<h2>Bienvenido a mi pagina!</h2>
			<%=request.getParameter("username")%>
			<a href="login.html"></a>
	</center>
</body>
</html>