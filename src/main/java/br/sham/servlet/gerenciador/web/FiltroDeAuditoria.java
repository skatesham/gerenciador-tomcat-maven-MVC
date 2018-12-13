package br.sham.servlet.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.sham.servlet.gerenciador.model.Usuario;

//@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println("Usuario acessando a URI " + req.getRequestURI());
		
		String usuario = "<delogado>";
		
		// Validar requisições que usuario esteja na sessão
		HttpSession session = req.getSession();
		Usuario u = (Usuario) session.getAttribute("usuario.logado");
		if (u != null) {
			usuario = u.getUsuario();
			System.out.println("Autenticação Sucedida!");
			req.setAttribute("nome", u.getUsuario());
			chain.doFilter(request, response);
		} else {
			
			if (!req.getRequestURI().equals("/gerenciador/login")) {
				System.out.println("Rota Filtrada");
				req.getRequestDispatcher("dynamic/login.jsp").forward(req, response);
			}
			else {
				System.out.println("Direcionado do Login!");
				chain.doFilter(request, response);
			}
		}
		
		/*
		 * Filtrar requisições que possuam login com cookie 
		 * 
		Cookie cookie = getUsuario(req);

		if (cookie != null) {
			chain.doFilter(request, response);
			usuario = cookie.getValue();
		} else {
			if (req.getRequestURI() != "/gerenciador/login")
				req.getRequestDispatcher("dynamic/login.jsp").forward(req, response);
		}
		*/
		
		System.out.println("Usuario = " + usuario);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/*
	private Cookie getUsuario(HttpServletRequest req) {

		Cookie[] cookies = req.getCookies();

		if (cookies == null)
			return null;

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("usuario.logado")) {
				return cookie;
			}
		}

		return null;
	}
	*/
}
