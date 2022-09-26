<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="index.css" type="text/css" media="all" />
    <title>Update</title>
</head>
<body>

    <!-- Inicio NavBar -->
    <div>
        <div>
            <nav class="navbar navbar-expand-lg bg-info">
                <div class="container-fluid">
                    <a class="navbar-brand" href="Index.jsp" style="color:blue;">Home</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="./promoçoes.jsp">Promoções</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="./destino.jsp">Destinos</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="./contato.jsp">Contato</a>
                            </li>

                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                                    data-bs-toggle="dropdown" aria-expanded="false">
                                    Log-in
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="login.jsp">Acesso</a></li>
                                    <li><a class="dropdown-item" href="cadastro.jsp">Cadastre-se</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="Login">ADM</a></li>
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
        </div> <!-- FIM - Menu NavBar-->


        <div class="container-fluid col-11 m-auto">
            <form action="./Login-update">
                <div class="form-group">
                    <label for="tipo id">ID</label>
                    <input type="number" value="<%=request.getAttribute("id")%>" class="form-control" name="id" id="exampleID" aria-describedby="IdHelp"
                        >
                        
                    <small id="IDlHelp" class="form-text text-muted"></small>
                </div>
                <div class="form-group">
                    <label for="tipo acesso">Tipo</label>
                    <input type="text" value= "<%=request.getAttribute("tipo")%>" class="form-control" name="tipo" id="example Tipo" aria-describedby="tipoHelp"
                        placeholder="Seu acesso">
                        
                    <small id="TipoHelp" class="form-text text-muted"></small>
                   <button type="submit" class="btn btn-primary">Enviar</button>
                    
                </div>
	      </form>
        </div>

</div>

</body>
</html>