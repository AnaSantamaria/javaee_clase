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
			ISBN: <input type="text" id="isbn"><br>
			Titulo: <input type="text" id="titulo"><br>
			Autor: <input type="text" id="autor"><br>
			Precio: <input type="text" id="precio"><br>
			Paginas: <input type="text" id="paginas"><br>
			Temática: <select id="tematica">
									<c:forEach var="t" items="${requestScope.temas}">
										<option value="${t.idTema}">${t.nombreTema}</option>
									</c:forEach>	
						</select>
			<imput type="button" value="Alta" id="alta">
			<br><br>
			<a href=FrontController?operation=doInicio">Volver</a>			
		</center>
		<script type="text/javascript">
			$("#alta").click(function(){
				var url= "frontController";
				var params={"operation":"doAltaLibro",
						"isbn":$("#isbn").val(),
						"titulo":$("#titulo").val(),
						"autor":$("#autor").val(),
						"precio":$("#precio").val(),
						"paginas":$("#paginas").val(),
						"idTema":$("#tematica").val()};
				$.get(url,params,function(){
					let mensaje;
					if(data=="true"){
						
						mensaje="libro añadido";
					}else{
						
						mensaje="ISBN duplicado, no seha podido añadir el libro";
					}
					
					alert(mensaje);
				})
		
			})
		
		</script>
</body>
</html>