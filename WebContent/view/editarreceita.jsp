<%@page import="com.lassi.model.Receita"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar receita</title>
<link
	href="${pageContext.servletContext.contextPath}/view/styles/editar.css"
	rel="stylesheet">
</head>
<body>
	<%
		Receita receita = (Receita) request.getAttribute("receita");
	%>
	<div class="home">
		<a href="index.jsp">
			<span> Início </span>
		</a>
	</div>
	<div class="container">
		<form action="ServletReceita">
			<h1>EDITAR RECEITA</h1>
			<hr>

			<div class="dataHora">
				<h3 for="data">Data: <%=receita.getData()%></h3>
				<input type="hidden" name="data" id="data"
					value="<%=receita.getData()%>">

				<h3 for="hora">Hora: <%=receita.getHora()%> </h3>
				<input type="hidden" name="hora" id="hora"
					pattern="([01][0-9]|2[0-3]):[0-5][0-9]"
					value="<%=receita.getHora()%>">
			</div>
			<div class="dataHoraAtt">
				<label for="dataAtualizacao">Data da atualização</label>
				<input type="date" name="data_atualizacao" id="data_atualizacao"
					value="<%=receita.getDataAtualizacao()%>">

				<label for="horaAtualizacao">Hora da atualização</label>
				<input type="text" name="hora_atualizacao" id="hora_atualizacao"
					pattern="([01][0-9]|2[0-3]):[0-5][0-9]"
					value="<%=receita.getHoraAtualizacao()%>">
			</div>
			<div class="titulo">
				<h3>Nome da receita: <%=receita.getTitulo()%></h3>

				<input type="hidden" name="titulo" id="titulo"
					value="<%=receita.getTitulo()%>">
			</div>
			<div class="sub">
				<label for="subTitulo">Subtítulo</label>
				<input type="text" name="subtitulo" id="subtitulo"
					value="<%=receita.getSubtitulo()%>">
			</div>
			<div class="autor">
				<h3>Autor: <%=receita.getAutor()%></h3>
				<input type="hidden" name="autor" id="autor"
					value="<%=receita.getAutor()%>">
			</div>
			<div class="receita">
				<label for="ingredientes">Ingredientes</label>
			</div>
			<div class=receitaText>
				<textarea name="ingredientes" id="ingredientes"
					value=""><%=receita.getIngredientes()%></textarea>
			</div>
			<div class="buttons">
				<input type="submit" id="atualizar" name="opcao" value="Atualizar">
			</div>
		</form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/view/scripts/jquery.mask.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/view/scripts/masks.js"
		type="text/javascript"></script>
</body>
</html>