package fr.eni.java.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import fr.eni.java.bean.Couleur;
import fr.eni.java.bean.Region;
import fr.eni.java.service.GestionBouteille;
import fr.eni.java.service.GestionCouleur;
import fr.eni.java.service.GestionRegion;

public class AjoutCouleurEtRegion {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		GestionRegion gr = context.getBean("gestionRegion", GestionRegion.class);
		GestionCouleur gc = context.getBean("gestionCouleur", GestionCouleur.class);
		
		Couleur c1 = new Couleur("Rouge");
		Couleur c2 = new Couleur("Blanc");
		Couleur c3 = new Couleur("Rosé");
		gc.ajouterCouleur(c1); 	gc.ajouterCouleur(c2); 	gc.ajouterCouleur(c3);
		
		Region r1 = new Region("Auvergne-Rhône-Alpes");
		Region r2 = new Region("Bourgogne-Franche-Comté");
		Region r3 = new Region("Bretagne");
		Region r4 = new Region("Centre-Val de Loire");
		Region r5 = new Region("Corse");
		Region r6 = new Region("Grand Est");
		Region r7 = new Region("Hauts-de-France");
		Region r8 = new Region("Île-de-France");
		Region r9 = new Region("Normandie");
		Region r10 = new Region("Nouvelle-Aquitaine");
		Region r11 = new Region("Occitanie");
		Region r12 = new Region("Pays de la Loire");
		Region r13 = new Region("Provence-Alpes-Côte d'Azur");
		
		gr.ajouterRegion(r1);  gr.ajouterRegion(r2);  gr.ajouterRegion(r3); gr.ajouterRegion(r4);
		gr.ajouterRegion(r5);  gr.ajouterRegion(r6);  gr.ajouterRegion(r7); gr.ajouterRegion(r8);
		gr.ajouterRegion(r9);  gr.ajouterRegion(r10);  gr.ajouterRegion(r11); gr.ajouterRegion(r12);
		gr.ajouterRegion(r13);
		
		List<Region> listeR = gr.listeRegion();
		System.out.println("Liste des region : ");
		for(Region r : listeR) {
			System.out.println(r);
		}
		
		List<Couleur> listeC = gc.listeCouleur();
		System.out.println("\nListe des couleurs : ");
		for(Couleur c : listeC) {
			System.out.println(c);
		}

	}

}
