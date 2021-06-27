package com.lassi.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lassi.dao.ReceitaDAO;
import com.lassi.model.Receita;

@WebServlet("/ServletReceita")
public class ServletReceita extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletReceita() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String data, dataAtualizacao, hora, horaAtualizacao, titulo, subtitulo, autor, ingredientes, opcao;

		opcao = request.getParameter("opcao");
		titulo = request.getParameter("titulo");
		data = request.getParameter("data");
		hora = request.getParameter("hora");
		horaAtualizacao = request.getParameter("hora_atualizacao");
		dataAtualizacao = request.getParameter("data_atualizacao");
		subtitulo = request.getParameter("subtitulo");
		autor = request.getParameter("autor");
		ingredientes = request.getParameter("ingredientes");

		if (opcao.equals("Adicionar")) {

			Receita receita = new Receita(data, hora, titulo, subtitulo, autor, ingredientes);
			try {
				ReceitaDAO dao = new ReceitaDAO();
				dao.adicionar(receita);
				response.getWriter().append("Receita gravada com sucesso").append(request.getContextPath());

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			RequestDispatcher r = request.getRequestDispatcher("index.jsp");
			r.forward(request, response);

		} else if (opcao.equals("Excluir")) {

			Receita receita = new Receita(titulo);
			receita.setTitulo(titulo);

			try {
				ReceitaDAO dao = new ReceitaDAO();
				dao.excluir(receita);

				RequestDispatcher r = request.getRequestDispatcher("view/certo.jsp");
				r.forward(request, response);
				response.getWriter().append("Receita excluida com sucesso!").append(request.getContextPath());

			} catch (ClassNotFoundException | SQLException e) {
				RequestDispatcher r = request.getRequestDispatcher("view/errado.jsp");
				r.forward(request, response);
				response.getWriter().append("Receita não foi excluida").append(request.getContextPath());

			}

		} else if (opcao.equals("Editar")) {

			try {
				ReceitaDAO dao = new ReceitaDAO();
				List<Receita> lista = new ArrayList<Receita>();
				lista = dao.editarReceita(titulo);
				// Zero pois, estamos mandando apenas 1 usuário
				String eTitulo = lista.get(0).getTitulo();
				String eData = lista.get(0).getData();
				String eHora = lista.get(0).getHora();
				String eDataAtt = lista.get(0).getDataAtualizacao();
				String eHoraAtt = lista.get(0).getHoraAtualizacao();
				String eSubtitulo = lista.get(0).getSubtitulo();
				String eAutor = lista.get(0).getAutor();
				String eIngredientes = lista.get(0).getIngredientes();

				System.out.println(eTitulo);
				Receita receita = new Receita(eTitulo, eData, eHora, eDataAtt, eHoraAtt, eSubtitulo, eAutor,
						eIngredientes);
				request.setAttribute("receita", receita);

				RequestDispatcher dispatcher = request.getRequestDispatcher("view/editarreceita.jsp");
				dispatcher.forward(request, response);

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else if (opcao.equals("Atualizar")) {

			try {

				ReceitaDAO dao = new ReceitaDAO();

				Receita receita = new Receita(titulo, data, hora, dataAtualizacao, horaAtualizacao, subtitulo, autor,
						ingredientes);
				dao.alterarReceita(receita);
				RequestDispatcher r = request.getRequestDispatcher("view/certo.jsp");
				r.forward(request, response);
				response.getWriter().append("Alterado com sucesso!!").append(request.getContextPath());
			} catch (ClassNotFoundException | SQLException e) {
				RequestDispatcher r = request.getRequestDispatcher("view/errado.jsp");
				r.forward(request, response);
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
