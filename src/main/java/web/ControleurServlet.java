package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.IProduitDao;

import dao.ProduitDaoAvecJDBC;
import modele.Produit;

@WebServlet("/controleur")
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IProduitDao dao = new ProduitDaoAvecJDBC();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if ("delete".equals(action)) {

			int id = Integer.parseInt(request.getParameter("id"));
			dao.deleteById(id);

		}

		if ("edit".equals(action)) {

			int id = Integer.parseInt(request.getParameter("id"));

			Produit prd = dao.findById(id);

			request.setAttribute("prd", prd);

		}

		Collection<Produit> produits = dao.findAll();

		request.setAttribute("produits", produits);

		request.getRequestDispatcher("WEB-INF/produits.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		double prix = Double.parseDouble(request.getParameter("prix"));

		Produit p = new Produit(id, nom, prix, quantite);

		if(id==0)  dao.add(p);
		else dao.update(p);

		doGet(request, response);
	}
}
