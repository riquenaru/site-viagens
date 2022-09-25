<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="model.Login"
    import="java.util.List"
%>

<%
@SuppressWarnings("unchecked")
List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="index.css" type="text/css" media="all" />
<title>viagem.com</title>
</head>
<body>

<!-- INICIO - Menu NavBar-->
  <div>
    <div>
      <nav class="navbar navbar-expand-lg bg-info">
        <div class="container-fluid">
          <a class="navbar-brand" href="./Index.jsp"
          style="color:blue;">Home</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="./Promocoes.jsp">Promoções</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="./Destino.jsp">Destinos</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="./Contato.jsp">Contato</a>
              </li>

              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
                  aria-expanded="false">
                  Log-in
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li><a class="dropdown-item" href="./Login.jsp">Acesso</a></li>
                  <li><a class="dropdown-item" href="./Cadastro.jsp">Cadastre-se</a></li>
                  <li>
                    <hr class="dropdown-divider">
                  </li>
                  <li><a class="dropdown-item" href="#">Ajuda</a></li>
                </ul>
                <li class="nav-item">
                <a class="nav-link" href="./Login">Login ADM</a>
              </li>
              </li>
            </ul>
            <form class="d-flex" role="search">
              <input class="form-control me-2" type="Destinos" placeholder="Destinos" aria-label="Destinos">
              <button class="btn btn-outline-primary" type="submit">Buscar</button>
            </form>
          </div>
        </div>
      </nav>
    </div> <!-- FIM - Menu NavBar-->


</body>
</html>