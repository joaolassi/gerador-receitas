<%@page import="java.util.List"%>
<%@page import="com.lassi.model.Receita"%>
<%@page import="com.lassi.dao.ReceitaDAO"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem de Receitas</title>
<link href="styles/listagem.css" rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

</head>
<body>
	<!--  configurar com JSTL a conexao com BD -->
	<sql:setDataSource var="receita" driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/gerador_receita?serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true"
		user="root" password="root" />

	<!-- determinar uma query com JSTL para select -->
	<sql:query var="resultado" dataSource="${receita}">
    SELECT titulo,data,hora,data_atualizacao,hora_atualizacao,subtitulo,autor,ingredientes from receita order by autor;
  </sql:query>
	<div class="home">
		<a href="../index.jsp">
			<span> Início </span>
		</a>
	</div>

	<div class="cointainerListagem">
		<div class="container">
			<div class="row">
				<c:forEach var="row" items="${resultado.rows}">

					<div class="col-3">
						<div class="card artes" style="width: 15rem;">
							<div class="card-body">
								<div class="back-nome">
									<h5 class="nome">${row.titulo}</h5>
								</div>
								<div>
									<h6>${row.subtitulo}</h6>
									<p class="card-text">${row.ingredientes}</p>
									<hr />
									<div>
										<label>Autor:</label> <span>${row.autor}</span>
									</div>
									<div>
										<label>Data:</label> <span>${row.data}</span>
									</div>
									<div>
										<label>Hora:</label> <span>${row.hora}</span>
									</div>
									<div>
										<label>Data atualização:</label> <span>${row.data_atualizacao}</span>
									</div>
									<div>
										<label>Hora atualização:</label> <span>${row.hora_atualizacao}</span>
									</div>
								</div>
								<hr>
								<div class="buttons">
									<a href="../ServletReceita?titulo=${row.titulo}&opcao=Excluir">Excluir</a>
									<a href="../ServletReceita?titulo=${row.titulo}&opcao=Editar">Editar</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous">
		
	</script>
</body>
</html>