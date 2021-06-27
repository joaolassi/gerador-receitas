<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crie suas Receitas!</title>
<link href="styles/style.css" rel="stylesheet">

</head>
<body>
	<div class="home">
		<a href="../index.jsp">
			<span> Início </span>
		</a>
	</div>
	<div class="container">
		<form action="../ServletReceita">
			<h1>GERADOR DE RECEITAS</h1>
			<hr>
			<div class="dataHora">

				<label for="data">Data</label>
				<input type="date" name="data" id="data" placeholder="Data">
				<label for="hora">Hora</label>

				<input type="text" name="hora" id="hora"
					pattern="([01][0-9]|2[0-3]):[0-5][0-9]" placeholder="00:00">

			</div>

			<div class="dataHoraAtt">

				<label for="dataAtualizacao">Data da atualização</label>
				<input type="date" name="hora_atualizacao" id="data_atualizacao"
					placeholder="Data da Atualização" disabled>
				<label for="horaAtualizacao">Hora da atualização</label>
				<input type="text" name="hora_atualizacao" id="hora_atualizacao"
					placeholder="00:00" disabled>
			</div>

			<div class="titulo">

				<label for="titulo">Título</label>
				<input type="text" name="titulo" id="titulo" placeholder="Título">
			</div>

			<div class="sub">

				<label for="subTitulo">Subtítulo</label>
				<input type="text" name="subtitulo" id="subtitulo"
					placeholder="Subtítulo">
			</div>

			<div class="autor">

				<label for="autor">Autor</label>
				<input type="text" name="autor" id="autor" placeholder="Autor">
			</div>

			<div class="receita">
				<label for="ingredientes">Ingredientes</label>

			</div>
			<div class=receitaText>

				<textarea name="ingredientes" id="ingredientes"
					placeholder="Ingredientes"></textarea>
			</div>

			<div class="buttons">

				<input type="submit" value="Adicionar" name="opcao" id="opcao"
					onClick="validar()">
				<input type="Reset" value="Limpar">
			</div>

		</form>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="scripts/jquery.mask.js"></script>
	<script src="scripts/masks.js" type="text/javascript"></script>
</body>
</html>