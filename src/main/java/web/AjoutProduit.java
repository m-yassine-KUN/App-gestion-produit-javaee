package web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.IProduitDao;
import dao.ProduitDao;
import modele.Produit;

@WebServlet("/add")
public class AjoutProduit extends HttpServlet {
	
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IProduitDao dao= new ProduitDao();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	int id= Integer.parseInt(request.getParameter("id"));
	String nom= request.getParameter("nom");
	int quantite= Integer.parseInt(request.getParameter("quantite"));
	double prix= Double.parseDouble(request.getParameter("prix"));

    Produit p= new Produit(id, nom, prix, quantite);

       dao.add(p);

    //PrintWriter  out= response.getWriter();
   // out.println("Un nouveau produit est ajouté avec succes");
	
	//faire une redirection  vers la servlet ListServlet
	
	
	request.getRequestDispatcher("liste").forward(request, response);

	
	}

}
