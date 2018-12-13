<%@ include file="../WEB-INF/paginas/base/header.jsp"%>
<style>
body{
    background-image: url('bg-web.jpg');
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
    height: 100%;
}
</style>
<nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
	<a class="navbar-brand" href="#">Gerenciador</a>
</nav>
<br>
<br>
<br>
<h1>Login</h1>
<div class="row">
	<div class="ml-auto mr-auto col-sm-6">
		<form action="/gerenciador/login" method="POST">
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">Usuário</span>
				</div>
				<input class="form-control" name="usuario">
			</div>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text">Senha</span>
				</div>
				<input class="form-control" type="password" name="senha">
			</div>
			<button class="btn btn-lg btn-dark" type="submit">Login</button>
		</form>
	</div>
</div>
<%@ include file="../WEB-INF/paginas/base/footer.jsp"%>