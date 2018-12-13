package br.sham.servlet.gerenciador.dao;

import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;

import br.sham.servlet.gerenciador.model.Empresa;

public class EmpresaDAO {
	
	private static EmpresaDAO uniqueInstance = null;
	
	public static EmpresaDAO getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new EmpresaDAO();
		}
		return uniqueInstance;
	}

	Collection<Empresa> empresas;

	private EmpresaDAO() {
		empresas = new LinkedList<>();
		empresas.add(new Empresa("Doceria Bela Vista"));
		empresas.add(new Empresa("Ferrages Docel"));
		empresas.add(new Empresa("Alura"));
		empresas.add(new Empresa("Google"));
		empresas.add(new Empresa("Caelum"));
		empresas.add(new Empresa("Casa do Código"));

	}

	public Collection<Empresa> buscaPorSimilaridade(String nome) {

		return this.empresas.stream().filter(e -> e.getNome().toLowerCase().indexOf(nome) != -1 ? true : false)
				.collect(Collectors.toList());

	}
	
	public void adicionar(String nome) {
		this.empresas.add(new Empresa(nome));
	}

}
