package fr.eni.java.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.java.bean.Bouteille;


public interface BouteilleDAO extends JpaRepository<Bouteille, Integer> {
	
	List<Bouteille> findAllByOrderByNomAsc();
	List<Bouteille> findAllByOrderByNomDesc();
	
	List<Bouteille> findAllByOrderByMillesimeAsc();
	List<Bouteille> findAllByOrderByMillesimeDesc();
	
	List<Bouteille> findAllByOrderByPetillantAsc();
	List<Bouteille> findAllByOrderByPetillantDesc();
	
	List<Bouteille> findAllByOrderByQuantiteAsc();
	List<Bouteille> findAllByOrderByQuantiteDesc();
	
	List<Bouteille> findAllByOrderByCouleurNomAsc();
	List<Bouteille> findAllByOrderByCouleurNomDesc();
	
	List<Bouteille> findAllByOrderByRegionAsc();
	List<Bouteille> findAllByOrderByRegionDesc();
	List<Bouteille> findByNomStartsWith(String nom);

}
