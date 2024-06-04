package fr.eni.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import fr.eni.java.bean.Couleur;
import fr.eni.java.dao.CouleurDAO;

@Service(value = "gestionCouleur")
public class GestionCouleur {
	
	@Autowired
	CouleurDAO cdao;
	
	public void ajouterCouleur(Couleur c) {
		cdao.save(c);
	}
	
	public Couleur rechercherCouleur(int id) {
		return cdao.findOne(id);
	}
	
	public List<Couleur> listeCouleur(){
		return cdao.findAll();
	}

}
