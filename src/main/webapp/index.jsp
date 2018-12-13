<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/paginas/base/header.jsp"%>
<%@ include file="/WEB-INF/paginas/base/navbar.jsp"%>
<h2>Bem vindo ao Gerenciador de Empresas</h2>
<div class="row">
	<div class="col-md-6">
		<h5>Buscar Empresa</h5>
		<form action="/gerenciador/executa?tarefa=BuscaEmpresa" method="post">
			<div class="form-group">
				<label for="filtro">Filtro de Busca</label> <input
					class="form-control" name="filtro" id="filtro">
			</div>
			<input class="btn btn-block mt-2" type="submit" value="Buscar" />
		</form>
	</div>
	<div class="col-md-6">
		<h5 class="mt-2">Criar Empresa</h5>
		<form action="/gerenciador/executa?tarefa=NovaEmpresa" method="POST">
			<div class="form-group">
				<label for="nome">Nome da Empresa</label> <input
					class="form-control" name="nome" id="nome">
			</div>
			<button class="btn btn-block mt-2" type="submit">Criar</button>
		</form>
	</div>
</div>
<br>
<br>
<br>


<!--  TAG IF JSTL  

<c:if test="${usuarioLogado!=null}">
    Você está logado como ${usuarioLogado.email}<br />
</c:if>

  END JSTL  -->

<%@ include file="../WEB-INF/paginas/base/footer.jsp"%>
