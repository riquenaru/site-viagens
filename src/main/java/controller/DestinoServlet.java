package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoDAO;
import model.Destino;

@WebServlet(urlPatterns = { "/Destino", "/Destino-create", "/Destino-edit", "/Destino-update", "/Destino-delet" })
public class DestinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DestinoDAO DestinoDAO = new DestinoDAO();
	Destino destino = new Destino();
	
	public DestinoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/Destino":
			read(request, response);
			break;
		case "/Destino-create":
			create(request, response);
			break;
		case "/Destino-edit":
			edit(request, response);
			break;
		case "/Destino-update":
			update(request, response);
			break;
		case "/Destino-delet":
			delet(request, response);
			break;

		default:
			response.sendRedirect("Index.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Destino> lista = DestinoDAO.getDestino();

		request.setAttribute("lista", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/destino/index.jsp");
		rd.forward(request, response);
	}

	// CREATE
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		destino.setDestino(request.getParameter("destino"));
		
		DestinoDAO.save(destino);
		response.sendRedirect("Destino");

	}

	// READ BY ID
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_destino = Integer.parseInt(request.getParameter("id_destino"));

		destino.setIdDestino(id_destino);
		destino.setDestino(request.getParameter("destino"));
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/destino/Update.jsp");
		rd.forward(request, response);

	}

	// UPDATE
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		destino.setIdDestino(Integer.parseInt(request.getParameter("id_destino")));
		destino.setDestino(request.getParameter("destino"));
		
		DestinoDAO.update(destino);
		response.sendRedirect("Destino");
	}

	// DELET
	protected void delet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_destino = Integer.parseInt(request.getParameter("id"));

		DestinoDAO.deleteById(id_destino);
		response.sendRedirect("Destino");
	}

}