package br.sham.servlet.gerenciador.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sham.servlet.gerenciador.dao.EmpresaDAO;
import br.sham.servlet.gerenciador.model.Empresa;

public class BuscaEmpresaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public BuscaEmpresaServlet() {
		System.out.println("Instanciando uma Servlet do tipo BuscaEmpresa " + this);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String filtro = req.getParameter("filtro");
		filtro = filtro == null ? "" : filtro;
		Collection<Empresa> selecionadas = EmpresaDAO.getInstance().buscaPorSimilaridade(filtro);

		/*
		 * Atrasando o service da servlet em 10 seg try { Thread.sleep(10000); } catch
		 * (InterruptedException e) { e.printStackTrace(); }
		 */

		req.setAttribute("empresas", selecionadas);
		req.getRequestDispatcher("/WEB-INF/paginas/buscaEmpresa.jsp").forward(req, resp);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Inicializando a Servlet " + this);
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Destruindo a Servlet " + this);
	}

}
