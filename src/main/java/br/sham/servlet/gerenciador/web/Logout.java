package br.sham.servlet.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.sham.servlet.gerenciador.model.Tarefa;

public class Logout implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "/dynamic/login.jsp";
	}

}
