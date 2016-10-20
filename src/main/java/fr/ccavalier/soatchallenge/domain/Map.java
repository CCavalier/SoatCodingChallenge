package fr.ccavalier.soatchallenge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Map {

	public static Map map;
	
	public int nbColisLivres;
	
	private int nbLignes;
	
	private int nbColonnes;
	
	private int nbCibles;
	
	private int nbDrones;
	
	private int deplacementMax;
	
	private int nbTours;
	
	private Coordonnee depart;
	
	private List<Coordonnee> coordonneesColis = new ArrayList<Coordonnee>();
	
	public void addCoordonnees(Coordonnee coordonnees){
		coordonneesColis.add(coordonnees);
	}


	public int getNbCibles() {
		return nbCibles;
	}

	public void setNbCibles(int nbCibles) {
		this.nbCibles = nbCibles;
	}

	public int getNbDrones() {
		return nbDrones;
	}

	public void setNbDrones(int nbDrones) {
		this.nbDrones = nbDrones;
	}

	public int getDeplacementMax() {
		return deplacementMax;
	}

	public void setDeplacementMax(int deplacementMax) {
		this.deplacementMax = deplacementMax;
	}

	public int getNbTours() {
		return nbTours;
	}

	public void setNbTours(int nbTours) {
		this.nbTours = nbTours;
	}

	public int getNbLignes() {
		return nbLignes;
	}

	public void setNbLignes(int nbLignes) {
		this.nbLignes = nbLignes;
	}

	public int getNbColonnes() {
		return nbColonnes;
	}

	public void setNbColonnes(int nbColonnes) {
		this.nbColonnes = nbColonnes;
	}


	public List<Coordonnee> getCoordonneesColis() {
		return coordonneesColis;
	}

	public void setCoordonneesColis(List<Coordonnee> coordonneesColis) {
		this.coordonneesColis = coordonneesColis;
	}

	public Coordonnee getDepart() {
		return depart;
	}

	public void setDepart(Coordonnee depart) {
		this.depart = depart;
	}
}
