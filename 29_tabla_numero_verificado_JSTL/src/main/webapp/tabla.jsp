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
<center>

	<h1>Tabla del{param.numero}</h1>
		<table border="1">
		<% for(int i=1;i<=10;i++) {%>
			<tr>
				<%for(int k=1;k<=10;k++) { %>
					<td><%=i*k %></td>
				<%}%>
			<tr>	
			<%}%>
		</table>
	</center>

</body>
</html>