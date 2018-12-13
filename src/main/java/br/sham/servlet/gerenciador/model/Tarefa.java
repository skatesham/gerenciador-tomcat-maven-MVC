package br.sham.servlet.gerenciador.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Tarefa {

    public String executa(HttpServletRequest request, HttpServletResponse response);

}