package br.sham.servlet.gerenciador.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.sham.servlet.gerenciador.model.Tarefa;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// qual tarefa quero executar?
		
		String tarefa = req.getParameter("tarefa");
		if (tarefa == null) {
			throw new IllegalArgumentException("Você esqueceu de inserir uma tarefa");
		}
		
		String nomeDaClasse = "br.sham.servlet.gerenciador.web."+tarefa;
		
		try {
			
			Class<?> type = Class.forName(nomeDaClasse);
			Tarefa instancia = (Tarefa) type.newInstance();

			// para qual página desejo ir?
			
			String pagina = instancia.executa(req, resp);
			req.getRequestDispatcher(pagina).forward(req, resp);
			
			
		}catch (Exception e) {
			throw new ServletException(e);
		}

		
		
	}

}
