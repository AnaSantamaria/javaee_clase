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
		<%int numero=Integer.parseInt(request.getParameter("numero")); %>
		<table border="1">
			<% for(int i=1;i<=10;i++) {%>
				<tr>
				
					<td><%=numero%>x<%=i%></td>
					<td><%=numero*i %></td>
				</tr>		
			<%}%>
		</table>
		<br>
		<a href="numero.html">Volver</a>
	</center>
</body>
</html>