package br.sham.servlet.gerenciador.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sham.servlet.gerenciador.dao.EmpresaDAO;
import br.sham.servlet.gerenciador.model.Empresa;
import br.sham.servlet.gerenciador.model.Tarefa;

public class BuscaEmpresa implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		String filtro = request.getParameter("filtro");
		
		Collection<Empresa> empresas = EmpresaDAO.getInstance().buscaPorSimilaridade(filtro);
		
		request.setAttribute("empresas", empresas);
		
		return "/WEB-INF/paginas/buscaEmpresa.jsp";
	}

}
