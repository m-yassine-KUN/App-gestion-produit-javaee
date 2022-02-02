package web;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/articles")
public class ArticlesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> panier=null;
		
		HttpSession session= request.getSession();
		
		//Y a t il panier dans la session?
		
		 panier=  (List<String>) session.getAttribute("panier");
		
		if (panier==null) {//pas de panier dans la session
			
			panier= new ArrayList<>();
			session.setAttribute("panier", panier);
			
		}
		
		
		String article = request.getParameter("article");
		
		
		panier=  (List<String>) session.getAttribute("panier");
		if(article!=null) panier.add(article);
		
		
		
		PrintWriter out= response.getWriter();
		out.print(panier);
		
		
	}

}
