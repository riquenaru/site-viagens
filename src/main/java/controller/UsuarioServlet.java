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
import dao.LoginDAO;
import model.Login;

@WebServlet(urlPatterns = { "/Usuario", "/Usuario-create", "/Usuario-edit", "/Usuario-update", "/Usuario-delet" })
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UsuarioDAO UsuarioDAO = new UsuarioDAO();
	Usuario usuario = new Usuario();
	LoginDAO log = new LoginDAO();
	Login l1 = new Login();
	
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

		request.setAttribute("lista", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/usuario/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setCpf_cnpj(request.getParameter("cpf_cnpj"));
		UsuarioDAO.save(usuario);
		
		response.sendRedirect("index.htm");

	}

	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("cpf_cnpj"));
		

		//usuario = UsuarioDAO.getUsuarioByCpf(getServletInfo()); //Pode ser que aqui dê erro por causa do cpf
		
		usuario.setCpf_cnpj(request.getParameter("cpf_cnpj"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setEmail(request.getParameter("email"));
		
		
		
		// nome da pag que eu vou precisar criar 
		RequestDispatcher rd = request.getRequestDispatcher("./views/usuario/Update.jsp");
		rd.forward(request, response);

	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpfUpdate = request.getParameter("cpf_cnpj");
		usuario = UsuarioDAO.getUsuarioByCpf(cpfUpdate);
		request.setAttribute("email", usuario.getEmail());
		request.setAttribute("cpf_cnpj", usuario.getCpf_cnpj());
		request.setAttribute("tipo", usuario.getSenha());
		UsuarioDAO.update(usuario);
		
		response.sendRedirect("Usuario");
	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		UsuarioDAO.deleteByCpf(id);
		response.sendRedirect("Usuario");
	}

}