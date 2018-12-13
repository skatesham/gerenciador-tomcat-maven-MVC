package br.sham.servlet.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sham.servlet.gerenciador.dao.EmpresaDAO;
import br.sham.servlet.gerenciador.model.Tarefa;

public class NovaEmpresa implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {

		String nome = request.getParameter("nome");
		
		request.setAttribute("nome", nome);
		
		EmpresaDAO.getInstance().adicionar(nome);
		
		return "/WEB-INF/paginas/novaEmpresa.jsp";
	}

}
