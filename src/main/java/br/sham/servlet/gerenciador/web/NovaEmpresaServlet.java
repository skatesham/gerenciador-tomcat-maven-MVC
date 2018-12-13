package br.sham.servlet.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sham.servlet.gerenciador.dao.EmpresaDAO;

public class NovaEmpresaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter ps = resp.getWriter();
		ps.println("<a href='" + req.getContextPath() + "/'>Home</a>");
		ps.println("<a href='" + req.getContextPath() + "/busca'>Busca</a>");

		String nome = req.getParameter("nome");
		if (nome != null && nome.length() > 3) {
			EmpresaDAO.getInstance().adicionar(nome);
			ps.println("<html><body>Empresa " + nome + " adicionada!</body></html>");
		} else {
			ps.println("<html><body>Você deve inserir um nome para criar uma Empresa! </body></html>");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter ps = resp.getWriter();
		ps.println("<a href='" + req.getContextPath() + "/'>Home</a>");
		ps.println("<a href='" + req.getContextPath() + "/busca'>Busca</a>");

		String nome = req.getParameter("nome");
		if (nome != null && nome.length() > 3) {
			EmpresaDAO.getInstance().adicionar(nome);
			ps.println("<html><body>Empresa " + nome + " adicionada!</body></html>");
		} else {
			ps.println("<html><body>Você deve inserir um nome para criar uma Empresa! </body></html>");
		}
	}

}
