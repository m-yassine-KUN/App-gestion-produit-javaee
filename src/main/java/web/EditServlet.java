package web;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.IProduitDao;
import dao.ProduitDao;
import modele.Produit;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IProduitDao dao= new ProduitDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id= Integer.parseInt(request.getParameter("id"));
		
		Produit prd= dao.findById(id);
		
	    request.setAttribute("prd", prd);
	
	   //request.getRequestDispatcher("formEdit.jsp").forward(request, response);
	   request.getRequestDispatcher("liste").forward(request, response);
	
	}

}
