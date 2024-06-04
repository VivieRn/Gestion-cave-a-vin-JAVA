package fr.eni.java.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.eni.java.bean.Bouteille;
import fr.eni.java.bean.Couleur;
import fr.eni.java.bean.Region;
import fr.eni.java.service.GestionBouteille;
import fr.eni.java.service.GestionCouleur;
import fr.eni.java.service.GestionRegion;

public class TestGestionBouteille {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		GestionBouteille gb = context.getBean("gestionBouteille", GestionBouteille.class);
		GestionRegion gr = context.getBean("gestionRegion", GestionRegion.class);
		GestionCouleur gc = context.getBean("gestionCouleur", GestionCouleur.class);
		
		Couleur c1 = new Couleur("Rouge");
		Couleur c2 = new Couleur("Blanc");
		Couleur c3 = new Couleur("Rosé");
		gc.ajouterCouleur(c1); 	gc.ajouterCouleur(c2); 	gc.ajouterCouleur(c3);
		
		Region r1 = new Region("Auvergne-Rhône-Alpes");
		Region r2 = new Region("Bourgogne-Franche-Comté");
		Region r3 = new Region("Bretagne");
		gr.ajouterRegion(r1);  gr.ajouterRegion(r2);  gr.ajouterRegion(r3);
		
		
		Bouteille b1 = new Bouteille("Bordeau", false, 1999, 66, r2, c1);
		Bouteille b2 = new Bouteille("Bretagne", true, 2020, 420, r3, c3);
		Bouteille b3 = new Bouteille("Côte-du-Rhone", true, 2020, 420, r1, c2);
//		gb.ajouterBouteille(b1);  gb.ajouterBouteille(b2);  gb.ajouterBouteille(b3);
		
		List<Bouteille> listeB = gb.rechercherBouteille();
		System.out.println("Liste des bouteilles : ");
		for(Bouteille b : listeB) {
			System.out.println(b);
		}
		
		listeB = gb.rechercherBouteilleParNomDesc();
		System.out.println("\nListe des bouteilles par nom desc : ");
		for(Bouteille b : listeB) {
			System.out.println(b);
		}
		
		listeB = gb.rechercherBouteilleParNomAsc();
		System.out.println("\nListe des bouteilles par nom asc : ");
		for(Bouteille b : listeB) {
			System.out.println(b);
		}
		
		listeB = gb.rechercherBouteilleParMillesimeDesc();
		System.out.println("\nListe des bouteilles par millesime desc : ");
		for(Bouteille b : listeB) {
			System.out.println(b);
		}
		
		listeB = gb.rechercherBouteilleParQuantiteDesc();
		System.out.println("\nListe des bouteilles par quantite desc : ");
		for(Bouteille b : listeB) {
			System.out.println(b);
		}

		listeB = gb.rechercherBouteilleParCouleurDesc();
		System.out.println("\nListe des bouteilles par couleur desc : ");
		for(Bouteille b : listeB) {
			System.out.println(b);
		}
		
		listeB = gb.rechercherBouteilleParRegionDesc();
		System.out.println("\nListe des bouteilles par region desc : ");
		for(Bouteille b : listeB) {
			System.out.println(b);
		}
		
		listeB = gb.rechercherBouteilleParRegionAsc();
		System.out.println("\nListe des bouteilles par region asc : ");
		for(Bouteille b : listeB) {
			System.out.println(b);
		}
	}
}
