package fr.eni.java.servlet;

import java.io.IOException;
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
import fr.eni.java.service.GestionBouteille;

@WebServlet("/trier")
public class TrierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	GestionBouteille gb;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String triPar = request.getParameter("par");
		if(triPar == null||triPar.isEmpty()) {
			triPar = "nom";
		}
		
        List<Bouteille> b;
        switch (triPar) {
        case "dA":
        	b = gb.rechercherBouteilleParNomAsc();
        	break;
        case "dD":
        	b = gb.rechercherBouteilleParNomDesc();
        	break;
        case "mA":
        	b = gb.rechercherBouteilleParMillesimeAsc();
        	break;
        case "mD":
        	b = gb.rechercherBouteilleParMillesimeDesc();
        	break;
        case "cA":
        	b = gb.rechercherBouteilleParPetillantAsc();
        	break;
        case "cD":
        	b = gb.rechercherBouteilleParPetillantDesc();
        	break;
        case "nA":
        	b = gb.rechercherBouteilleParQuantiteAsc();
        	break;
        case "nD":
        	b = gb.rechercherBouteilleParQuantiteDesc();
        	break;
        case "coA":
        	b = gb.rechercherBouteilleParCouleurAsc();
        	break;
        case "coD":
        	b = gb.rechercherBouteilleParCouleurDesc();
        	break;
        case "rA":
        	b = gb.rechercherBouteilleParRegionAsc();
        	break;
        case "rD":
        	b = gb.rechercherBouteilleParRegionDesc();
        	break;
        default:
        	b = gb.rechercherBouteille();
        }
        request.setAttribute("listeB", b);
        
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/listerB.jsp");
        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
