package fr.eni.java.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CouleurTPCAV")
public class Couleur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@OneToMany(mappedBy = "couleur", cascade = CascadeType.REMOVE)
	private List<Bouteille> bouteilles;

	public Couleur() {
		super();
	}
	
	public Couleur(String nom) {
		super();
		this.nom = nom;
	}

	public Couleur(String nom, List<Bouteille> bouteilles) {
		super();
		this.nom = nom;
		this.bouteilles = bouteilles;
	}

	public Couleur(int id, String nom, List<Bouteille> bouteilles) {
		super();
		this.id = id;
		this.nom = nom;
		this.bouteilles = bouteilles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Bouteille> getBouteilles() {
		return bouteilles;
	}

	public void setBouteilles(List<Bouteille> bouteilles) {
		this.bouteilles = bouteilles;
	}

	@Override
	public String toString() {
		return "Couleur [id=" + id + ", couleur=" + nom + "]";
	}
}
