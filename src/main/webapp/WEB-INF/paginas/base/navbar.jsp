<nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
	<a class="navbar-brand" href="#">Gerenciador</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item active">
				<form action="/gerenciador/executa?tarefa=Home" method="post">
					<input class="btn btn-link nav-link active" type="submit" value="Home" />
				</form>
			</li>
			<li class="nav-item">
				<form action="/gerenciador/executa?tarefa=Logout" method="post">
					<input class="btn btn-link nav-link" type="submit" value="Logout" />
				</form>
			</li>
		</ul>
	</div>

</nav>
<br>
<br>
<br>