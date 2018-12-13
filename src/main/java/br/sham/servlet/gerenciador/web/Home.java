package br.sham.servlet.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sham.servlet.gerenciador.model.Tarefa;

public class Home implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {

		return "index.jsp";
	}

}
