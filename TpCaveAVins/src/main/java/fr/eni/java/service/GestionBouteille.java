package fr.eni.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.java.bean.Bouteille;
import fr.eni.java.dao.BouteilleDAO;

@Service(value = "gestionBouteille")
public class GestionBouteille {
	
	@Autowired
	BouteilleDAO bdao;
	
	public Bouteille rechercherBouteille(int id) {
		return bdao.findOne(id);
	}
	
	public void ajouterBouteille(Bouteille b) throws Exception {
		if(b.getQuantite() < 0) {
			throw new Exception("La quantitée doit être supérieur ou égale à zéro.");
		}
		bdao.save(b);
	}
	
	public void modifier(Bouteille b) {
		bdao.save(b);
	}
	
	public void supprimerBouteille(int id) {
		bdao.delete(id);
	}
	
	public List<Bouteille> rechercherBouteille(){
		return bdao.findAll();
	}
	
	public List<Bouteille> rechercherBouteilleParNomAsc(){
		return bdao.findAllByOrderByNomAsc();
	}
	
	public List<Bouteille> rechercherBouteilleParNomDesc(){
		return bdao.findAllByOrderByNomDesc();
	}
	
	public List<Bouteille> rechercherBouteilleParMillesimeAsc(){
		return bdao.findAllByOrderByMillesimeAsc();
	}
	
	public List<Bouteille> rechercherBouteilleParMillesimeDesc(){
		return bdao.findAllByOrderByMillesimeDesc();
	}
	
	public List<Bouteille> rechercherBouteilleParPetillantAsc(){
		return bdao.findAllByOrderByPetillantAsc();
	}
	
	public List<Bouteille> rechercherBouteilleParPetillantDesc(){
		return bdao.findAllByOrderByPetillantDesc();
	}
	
	public List<Bouteille> rechercherBouteilleParQuantiteAsc(){
		return bdao.findAllByOrderByQuantiteAsc();
	}
	
	public List<Bouteille> rechercherBouteilleParQuantiteDesc(){
		return bdao.findAllByOrderByQuantiteDesc();
	}
	
	public List<Bouteille> rechercherBouteilleParCouleurAsc(){
		return bdao.findAllByOrderByCouleurNomAsc();
	}
	
	public List<Bouteille> rechercherBouteilleParCouleurDesc(){
		return bdao.findAllByOrderByCouleurNomDesc();
	}
	
	public List<Bouteille> rechercherBouteilleParRegionAsc(){
		return bdao.findAllByOrderByRegionAsc();
	}
	
	public List<Bouteille> rechercherBouteilleParRegionDesc(){
		return bdao.findAllByOrderByRegionDesc();
	}
	
	public List<Bouteille> rechercherParNomCommencant(String nom){
		return bdao.findByNomStartsWith(nom);
	}

}
