package fr.eni.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import fr.eni.java.bean.Region;
import fr.eni.java.dao.RegionDAO;

@Service(value = "gestionRegion")
public class GestionRegion {
	
	@Autowired
	RegionDAO rdao;
	
	public void ajouterRegion(Region r) {
		rdao.save(r);
	}
	
	public Region rechercherRegion(int id) {
		return rdao.findOne(id);
	}
	
	public List<Region> listeRegion(){
		return rdao.findAll();
	}

}
