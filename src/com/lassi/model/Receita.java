package com.lassi.model;

public class Receita {

	private String hora, horaAtualizacao, titulo, subtitulo, autor, ingredientes, data, dataAtualizacao;

	public Receita() {
	}

	public Receita(String titulo) {
		this.titulo = titulo;
	}

	// editar
	public Receita(String dataAtualizacao, String horaAutalizacao, String subtitulo, String autor,
			String ingredientes) {
		this.dataAtualizacao = dataAtualizacao;
		this.horaAtualizacao = horaAutalizacao;
		this.subtitulo = subtitulo;
		this.autor = autor;
		this.ingredientes = ingredientes;
	}

	// Add
	public Receita(String data, String hora, String titulo, String subtitulo, String autor, String ingredientes) {
		this.titulo = titulo;
		this.data = data;
		this.hora = hora;
		this.subtitulo = subtitulo;
		this.autor = autor;
		this.ingredientes = ingredientes;
	}

	public Receita(String titulo, String data, String hora, String dataAtualizacao, String horaAtualizacao,
			String subtitulo, String autor, String ingredientes) {
		this.data = data;
		this.hora = hora;
		this.dataAtualizacao = dataAtualizacao;
		this.horaAtualizacao = horaAtualizacao;
		this.titulo = titulo;
		this.subtitulo = subtitulo;
		this.autor = autor;
		this.ingredientes = ingredientes;
	}

	public String getData() {
		return data;
	}

	public String setData(String data) {
		return this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(String dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getHoraAtualizacao() {
		return horaAtualizacao;
	}

	public void setHoraAtualizacao(String horaAtualizacao) {
		this.horaAtualizacao = horaAtualizacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

}
