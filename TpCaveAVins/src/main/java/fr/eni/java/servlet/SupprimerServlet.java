package fr.eni.java.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fr.eni.java.service.GestionBouteille;

@WebServlet("/supprimer")
public class SupprimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	GestionBouteille gb;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String idStr = request.getParameter("index");
			int id = Integer.parseInt(idStr.substring(1));
			gb.supprimerBouteille(id);
			response.sendRedirect(request.getContextPath()+"/lister");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
