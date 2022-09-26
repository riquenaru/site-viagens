package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;

@WebServlet(urlPatterns = { "/Usuario", "/Usuario-create", "/Usuario-edit", "/Usuario-update", "/Usuario-delet" })
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UsuarioDAO UsuarioDAO = new UsuarioDAO();
	Usuario usuario = new Usuario();
	
	public UsuarioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/Usuario":
			read(request, response);
			break;
		case "/Usuario-create":
			create(request, response);
			break;
		case "/Usuario-edit":
			edit(request, response);
			break;
		case "/Usuario-update":
			update(request, response);
			break;
		case "/Usuario-delet":
			delet(request, response);
			break;

		default:
			response.sendRedirect("Index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Usuario> lista = UsuarioDAO.getUsuario();

		request.setAttribute("Usuario", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/usuario/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		usuario.setEmail(request.getParameter("Email"));
		
		UsuarioDAO.save(usuario);
		response.sendRedirect("Login");

	}

	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("cpf_cnpj"));

		usuario = UsuarioDAO.getUsuarioByCpf(getServletInfo());

		request.setAttribute("id", login.getId());
		request.setAttribute("tipo", login.getTipo());
		// nome da pag que eu vou precisar criar 
		RequestDispatcher rd = request.getRequestDispatcher("./views/login/Update.jsp");
		rd.forward(request, response);

	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login.setId(Integer.parseInt(request.getParameter("id")));
		login.setTipo(request.getParameter("tipo"));
		
		LoginDAO.update(login);
		response.sendRedirect("Login");
	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		LoginDAO.deleteById(id);
		response.sendRedirect("Login");
	}

}