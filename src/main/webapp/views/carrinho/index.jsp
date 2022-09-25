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


<!doctype html>
<html lang="pt-br">
  <head>
    <title>Clientes </title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.2.0-beta1 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"  integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

    <link rel="stylesheet" href="./css/style.css">
  </head>
  <body>
      
    
<div class="main">
    <nav class="navbar navbar-expand-md navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="./index.jsp">
                aluguel carro
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a href="../autores/index.html" class="nav-link text-dark ">
                            clientes
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="../editoras/index.html" class="nav-link text-dark">
                            Carros
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="../livros/index.html" class="nav-link text-dark">
                            Aluguel
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <header class="tag">
        <h1 class="container">Clientes</h1>
    </header>

    <div class="container py-3">
        <a href="./views/clientes/create.html" class="btn btn-primary mb-2">
            Criar cliente
        </a>
        <div class="table-responsive">
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>Cidade</th>
                        <th>Cpf</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                
                <% for (Cliente c: clientes) { %>
                    <tr>
                        <td><%=c.getId() %></td>
                        <td><%=c.getNome() %></td>
                        <td><%=c.getCidade() %></td>
                        <td><%=c.getCpf() %></td>
                        <td class="d-flex">
                            <a href="./clientes-edit?id=<%=c.getId() %>" class="btn btn-info">
                                Editar
                            </a>
                            <a href="./clientes-delet?id=<%=c.getId() %>" class="btn btn-danger" style="margin-left: 10px;">
                                Deletar
                            </a>
                        </td>
                    </tr>
                  <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>

    
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>
  </body>
</html>