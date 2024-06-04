package fr.eni.java.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BouteilleTPCAV")
public class Bouteille {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private boolean petillant;
	private int millesime;
	private int quantite;
	
	@ManyToOne
	@JoinColumn(name = "region_id", referencedColumnName = "id")
	private Region region;
	
	@ManyToOne
	@JoinColumn(name = "couleur_id", referencedColumnName = "id")
	private Couleur couleur;

	public Bouteille() {
		super();
	}

	public Bouteille(String nom, boolean petillant, int millesime, int quantite, Region region, Couleur couleur) {
		super();
		this.nom = nom;
		this.petillant = petillant;
		this.millesime = millesime;
		this.quantite = quantite;
		this.region = region;
		this.couleur = couleur;
	}

	public Bouteille(int id, String nom, boolean petillant, int millesime, int quantite, Region region,
			Couleur couleur) {
		super();
		this.id = id;
		this.nom = nom;
		this.petillant = petillant;
		this.millesime = millesime;
		this.quantite = quantite;
		this.region = region;
		this.couleur = couleur;
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

	public boolean isPetillant() {
		return petillant;
	}

	public void setPetillant(boolean petillant) {
		this.petillant = petillant;
	}

	public int getMillesime() {
		return millesime;
	}

	public void setMillesime(int millesime) {
		this.millesime = millesime;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
	    return "Bouteille [id=" + id + ", nom=" + nom + ", petillant=" + petillant + ", millesime=" + millesime
	            + ", quantite=" + quantite + ", couleur=" + couleur + "]";
	}
}
