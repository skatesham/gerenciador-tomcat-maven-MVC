package br.sham.servlet.gerenciador.dao;

import java.util.HashMap;
import java.util.Map;

import br.sham.servlet.gerenciador.model.Usuario;


public class UsuarioDAO {

	private final static Map<String, Usuario> USUARIOS = new HashMap<>();
	static {
		USUARIOS.put("admin", new Usuario("admin","admin"));
		USUARIOS.put("sham", new Usuario("sham","123"));
	}

	public Usuario buscaPorUsuarioESenha(String email, String senha) {
		if (!USUARIOS.containsKey(email))
			return null;

		Usuario usuario = USUARIOS.get(email);
		if (usuario.getSenha().equals(senha))
			return usuario;
		
		return null;
	}

}

