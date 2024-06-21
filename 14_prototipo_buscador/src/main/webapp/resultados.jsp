<%@page import="model.Resultado"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%  List<Resultado> resultados=(List<Resultados>)request.getAttribute("paginas"); 
		if(resultados!=null&&resultados.size()>0){
			for(Resultado r:resultados){%>
				<h2><a href="<%=r.getUrl()%>"><%=r.getUrl()%></a></h2>
				<h4><%=r.getDescripcion() %></h4>
			<hr>
		<%}%>
	<%} %>
	<br>
	<a href="buscar.html">Volver</a>
	
</body>
</html>