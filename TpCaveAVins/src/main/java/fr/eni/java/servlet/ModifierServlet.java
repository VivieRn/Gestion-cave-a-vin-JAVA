package fr.eni.java.servlet;

import java.io.IOException;

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

@WebServlet("/editer")
public class ModifierServlet extends HttpServlet {
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
		try {
			String idStr = request.getParameter("index");
			int id = Integer.parseInt(idStr.substring(1));
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
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/editerB.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Couleur coul = gc.rechercherCouleur(Integer.parseInt(request.getParameter("couleurId")));
			Region reg = gr.rechercherRegion(Integer.parseInt(request.getParameter("regionId")));
			
			int id = Integer.parseInt(request.getParameter("id"));
			Bouteille b = gb.rechercherBouteille(id);
			b.setNom(request.getParameter("nom"));
			b.setMillesime(Integer.parseInt(request.getParameter("millesime")));
			b.setPetillant(Boolean.parseBoolean(request.getParameter("petillant")));
			b.setQuantite(Integer.parseInt(request.getParameter("quantite")));
			b.setCouleur(coul);
			b.setRegion(reg);
			
			gb.modifier(b);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("lister");
	}

}
