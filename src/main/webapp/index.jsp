<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Portal Imobiliário CG</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	background-color: #f5f5f5;
}

.banner {
	background: linear-gradient(135deg, #0d6efd, #084298);
	color: white;
	padding: 50px 20px;
	text-align: center;
}

.card-imovel {
	transition: 0.3s;
}

.card-imovel:hover {
	transform: translateY(-5px);
}

.preco {
	color: #198754;
	font-weight: bold;
	font-size: 1.3rem;
}
</style>
</head>
<body>

	<!-- Cabeçalho -->
	<header class="banner">
		<h1>Portal Imobiliário CG</h1>
		<p>Encontre imóveis para venda e aluguel</p>
	</header>

	<!-- Busca -->
	<div class="container mt-4">

		<div class="card shadow-sm">
			<div class="card-body">
				<h4>Pesquisar Imóveis</h4>

				<form action="listarImoveis" method="get">
					<div class="row">

						<div class="col-md-3">
							<label class="form-label">Finalidade</label> <select
								name="tipoNegocio" class="form-select">
								<option value="">Todos</option>
								<option value="VENDA">Venda</option>
								<option value="ALUGUEL">Aluguel</option>
							</select>
						</div>

						<div class="col-md-3">
							<label class="form-label">Tipo de Imóvel</label> <select
								name="tipoImovel" class="form-select">
								<option value="">Todos</option>
								<option value="APARTAMENTO">Apartamento</option>
								<option value="CASA">Casa</option>
								<option value="TERRENO">Terreno</option>
								<option value="COMERCIAL">Comercial</option>
							</select>
						</div>

						<div class="col-md-3">
							<label class="form-label">Cidade</label> <input type="text"
								name="cidade" class="form-control" placeholder="Digite a cidade">
						</div>
						<div class="col-md-3">
							<label class="form-label">Valor Máximo</label> <input
								type="number" name="valorMaximo" class="form-control"
								placeholder="R$">
						</div>
					</div>
					<div class="mt-3">
						<button type="submit" class="btn btn-primary">Buscar</button>
					</div>
				</form>
			</div>
		</div>
		<!-- Resultado -->
		<div class="mt-5">
			<h3>Imóveis Disponíveis</h3>
			<c:if test="${not empty erro}">
				<div class="alert alert-danger">${erro}</div>
			</c:if>
			<div class="row">
				<c:forEach items="${imoveis}" var="imovel">
					<div class="col-md-4 mb-4">
						<div class="card shadow-sm">
							<div class="card-body">
								<h5>${imovel.titulo}</h5>
								<p>Cidade: ${imovel.cidade}</p>
								<p>Tipo de Imóvel: ${imovel.tipoImovel.descricao}</p>
								<p>Finalidade: ${imovel.finalidadeImovel.descricao}</p>
								<p class="preco">R$ ${imovel.valor}</p>
							</div>

						</div>
					</div>
				</c:forEach>
			</div>
		</div>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>