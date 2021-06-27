package com.lassi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lassi.model.Receita;

public class ReceitaDAO {
	private Connection conexao;
	private PreparedStatement preparar;
	private String sql;
	private ResultSet rs;
	private List<Receita> lista;

	public ReceitaDAO() throws ClassNotFoundException, SQLException {
		conexao = new Conexao().getConexao();
	}

	public void adicionar(Receita receita) throws SQLException {
		sql = "insert into receita(titulo, data,hora,data_atualizacao,hora_atualizacao "
				+ ", subtitulo, autor, ingredientes) values (?,?,?,?,?,?,?,?)";
		preparar = conexao.prepareStatement(sql);
		preparar.setString(1, receita.getTitulo());
		preparar.setString(2, receita.getData());
		preparar.setString(3, receita.getHora());
		preparar.setString(4, receita.getDataAtualizacao());
		preparar.setString(5, receita.getHoraAtualizacao());
		preparar.setString(6, receita.getSubtitulo());
		preparar.setString(7, receita.getAutor());
		preparar.setString(8, receita.getIngredientes());
		preparar.execute();
		preparar.close();
	}

	public void excluir(Receita receita) throws SQLException {
		sql = "delete from receita where titulo=?";
		preparar = conexao.prepareStatement(sql);
		preparar.setString(1, receita.getTitulo());
		preparar.execute();
		preparar.close();
	}

	public List<Receita> listarReceita() throws SQLException {
		lista = new ArrayList<Receita>();
		sql = "select * from usuario order by titulo";
		preparar = conexao.prepareStatement(sql);
		rs = preparar.executeQuery();
		while (rs.next()) {
			Receita receita = new Receita();
			receita.setTitulo(rs.getString("titulo"));
			receita.setData(rs.getString("data"));
			receita.setHora(rs.getString("hora"));
			receita.setDataAtualizacao(rs.getString("dataAtualizacao"));
			receita.setHoraAtualizacao(rs.getString("horaAtualizacao"));
			receita.setSubtitulo(rs.getString("subtitulo"));
			receita.setAutor(rs.getString("autor"));
			receita.setIngredientes(rs.getString("ingredientes"));
			lista.add(receita);
		}
		return lista;
	}

	public List<Receita> editarReceita(String titulo) throws SQLException {
		lista = new ArrayList<Receita>();
		sql = "SELECT titulo,data,hora,data_atualizacao,hora_atualizacao,subtitulo,autor,ingredientes from receita where titulo='"
				+ titulo + "'";
		preparar = conexao.prepareStatement(sql);
		rs = preparar.executeQuery();
		rs.next();

		Receita receita = new Receita();

		receita.setTitulo(rs.getString("titulo"));
		receita.setData(rs.getString("data"));
		receita.setHora(rs.getString("hora"));
		receita.setDataAtualizacao(rs.getString("data_atualizacao"));
		receita.setHoraAtualizacao(rs.getString("hora_atualizacao"));
		receita.setSubtitulo(rs.getString("subtitulo"));
		receita.setAutor(rs.getString("autor"));
		receita.setIngredientes(rs.getString("ingredientes"));
		lista.add(receita);

		return lista;
	}

	public void alterarReceita(Receita receita) throws SQLException {

		sql = "UPDATE receita SET data_atualizacao=?,hora_atualizacao=?,subtitulo=?,autor=?,ingredientes=? WHERE titulo=?";
		try {
			preparar = conexao.prepareStatement(sql);
			preparar.setString(1, receita.getDataAtualizacao());
			preparar.setString(2, receita.getHoraAtualizacao());
			preparar.setString(3, receita.getSubtitulo());
			preparar.setString(4, receita.getAutor());
			preparar.setString(5, receita.getIngredientes());
			preparar.setString(6, receita.getTitulo());
			
			preparar.executeUpdate();

			preparar.close();
		}

		catch (

		Exception e) {
			System.out.println("Não foi salvo");
			e.printStackTrace();
		}
	}
}
