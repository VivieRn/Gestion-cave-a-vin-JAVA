package fr.eni.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.java.bean.Couleur;

public interface CouleurDAO extends JpaRepository<Couleur, Integer> {

}
