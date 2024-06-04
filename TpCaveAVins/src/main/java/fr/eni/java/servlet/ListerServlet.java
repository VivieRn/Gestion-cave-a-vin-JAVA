package fr.eni.java.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fr.eni.java.bean.Bouteille;
import fr.eni.java.bean.Couleur;
import fr.eni.java.bean.Region;
import fr.eni.java.service.GestionBouteille;
import fr.eni.java.service.GestionCouleur;
import fr.eni.java.service.GestionRegion;

@WebServlet(urlPatterns = {"/lister", "/afficher"})
public class ListerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	GestionBouteille gb;
	@Autowired
	GestionCouleur gc;
	@Autowired
	GestionRegion gr;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/afficher" : 
			afficher(request, response);
			break;
		default:
			lister(request, response);
			break;
		}
	}
	
	private void lister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Bouteille> b =null;
		String filtre = request.getParameter("filtre");
		if(filtre != null) {
			b = gb.rechercherParNomCommencant(filtre);
			request.setAttribute("filtre", filtre);
		} else {
			b = gb.rechercherBouteille();
			if(b == null) {
				b = new ArrayList<Bouteille>();
			}
		}
		request.setAttribute("listeB", b);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/listerB.jsp");
        rd.forward(request, response);
	}
	
	private void afficher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String idStr = request.getParameter("index");
			int id = Integer.parseInt(idStr);
			Bouteille b = gb.rechercherBouteille(id);
			Couleur couleur = gc.rechercherCouleur(b.getCouleur().getId());
			Region region = gr.rechercherRegion(b.getRegion().getId());
			b.setCouleur(couleur);
			b.setRegion(region);
			request.setAttribute("listeRegion", gr.listeRegion());
			request.setAttribute("listeCoul", gc.listeCouleur());
			request.setAttribute("bout", b);
		}catch(Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/afficherB.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
