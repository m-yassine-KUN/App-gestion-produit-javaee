package web;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.IProduitDao;
import dao.ProduitDao;

@WebServlet("/delete")
public class SupprimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IProduitDao dao= new ProduitDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id= Integer.parseInt(request.getParameter("id"));
	    dao.deleteById(id);
	
	  //faire une redirection  vers la servlet ListServlet
		request.getRequestDispatcher("liste").forward(request, response);
	
	}

}
