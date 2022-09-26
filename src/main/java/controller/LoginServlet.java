package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDAO;
import model.Login;

@WebServlet(urlPatterns = { "/Login", "/Login-create", "/Login-edit", "/Login-update", "/Login-delet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LoginDAO LoginDAO = new LoginDAO();
	Login login = new Login();
	
	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/Login":
			read(request, response);
			break;
		case "/Login-create":
			create(request, response);
			break;
		case "/Login-edit":
			edit(request, response);
			break;
		case "/Login-update":
			update(request, response);
			break;
		case "/Login-delet":
			delet(request, response);
			break;

		default:
			response.sendRedirect("Index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Login> lista = LoginDAO.getLogin();

		request.setAttribute("Login", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/login/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		login.setTipo(request.getParameter("Login"));
		
		LoginDAO.save(login);
		response.sendRedirect("Login");

	}

	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		login = LoginDAO.getLoginById(id);

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