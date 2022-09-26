<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Login" import="dao.LoginDAO"
	import="java.util.List"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%
@SuppressWarnings("unchecked")
List<Usuario> lista = (List<Usuario>) request.getAttribute("Usuario");
%>


<!doctype html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Usuario</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

</head>
<body>


	
	<nav class="navbar navbar-expand-lg bg-info">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="Index.html">Home</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                <li class="nav-item">
                                    <a class="nav-link" style="color: blue" href="Views/Destino/Index.jsp">Destinos</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link active" aria-current="page" href="Views/Promocoes/Index.jsp">Promoções</a>
                                </li>

                                <li class="nav-item">
                                    <a class="nav-link" href="Views/Contato/Index.jsp">Contato</a>
                                </li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                                        data-bs-toggle="dropdown" aria-expanded="false">
                                        Log-in
                                    </a>
                                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                        <!--Ainda pretendo usar o dropdown para o log in-->
                                        <li><a class="dropdown-item" href="Views/Login/Index.jsp">Acesso</a></li>
                                        <li><a class="dropdown-item" href="Views/Cadastro/Index.jsp">Cadastre-se</a></li>
                                        <li>
                                            <hr class="dropdown-divider">
                                        </li>
                                        <li><a class="dropdown-item" href="Views/adm/Index.jsp">ADM</a></li>
                                    </ul>
                                </li>
                            </ul>
                            <form class="d-flex" role="search">
                                <input class="form-control me-2" type="Destinos" placeholder="Destinos"
                                    aria-label="Destinos">
                                <button class="btn btn-outline-primary" type="submit">Buscar</button>
                            </form>
                        </div>
                    </div>
                </nav>
	
	<header class="tag">
		<h1 class="container">Login</h1>
	</header>

	<div class="container py-3">
		<a href="./Views/login/create.html" class="btn btn-primary mb-2">
			Criar Login </a>
		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th>Id Login</th>
						<th>Tipo Login</th>

					</tr>
				</thead>
				<tbody>

					<%
					for (Login c : lista) {
					%>
					<tr>
						<td><%=c.getId()%></td>
						<td><%=c.getTipo()%></td>

						<td class="d-flex"><a
							href="./login-edit?id=<%=c.getId()%>" class="btn btn-info">
								Editar </a> <a href="./login-delet?id=<%=c.getId()%>"
							class="btn btn-danger" style="margin-left: 10px;"> Deletar </a></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>



	<!-- Bootstrap JavaScript Libraries -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
		integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
		crossorigin="anonymous"></script>


</body>
</html>