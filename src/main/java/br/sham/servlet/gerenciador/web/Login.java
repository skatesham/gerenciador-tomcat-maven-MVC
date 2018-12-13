package br.sham.servlet.gerenciador.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.sham.servlet.gerenciador.dao.UsuarioDAO;
import br.sham.servlet.gerenciador.model.Usuario;

public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Funciona como LOGOUT
		
		// Logout com session
		HttpSession session = req.getSession();
		// opção 1
		session.removeAttribute("usuario.logado");
		// opção 2
		session.invalidate();
		
		/* Logout com Cookies
		Cookie cookie = getUsuario(req);
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		*/
		
		//resp.sendRedirect("logout.html");
		req.getRequestDispatcher("dynamic/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String usuario = req.getParameter("usuario");
		String senha = req.getParameter("senha");

		UsuarioDAO udao = new UsuarioDAO();

		Usuario u = udao.buscaPorUsuarioESenha(usuario, senha);
		if (u == null) {
			req.getRequestDispatcher("dynamic/login.jsp").forward(req, resp);
			System.out.println("Usuario Não Existe");
		} else {
			session.setAttribute("usuario.logado", u);
			/* Login com Cookies
			Cookie cookie = new Cookie("usuario.logado", usuario);
			cookie.setMaxAge(10*60);
			resp.addCookie(cookie);
			*/
			System.out.println("Login Concluido");
			req.setAttribute("nome", u.getUsuario());
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}

	}

	/**
	 * Função para busca de cookie com 'usuario.logado' como chave
	 * @param req
	 * @return

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