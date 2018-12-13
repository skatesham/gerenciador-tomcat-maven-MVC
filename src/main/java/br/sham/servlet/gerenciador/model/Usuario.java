package br.sham.servlet.gerenciador.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class Usuario {
	
	private String usuario;
	private String senha;

}
