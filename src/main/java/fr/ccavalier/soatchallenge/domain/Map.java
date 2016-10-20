package fr.ccavalier.soatchallenge.domain;

import java.util.ArrayList;
import java.util.List;

public class Map {

	
	private int nbLignes;
	
	private int nbColonnes;
	
	private int nbCibles;
	
	private int nbDrones;
	
	private int deplacementMax;
	
	private int nbTours;
	
	private int ligneDepart;
	
	private int colonneDepart;
	
	private List<Coordonnee> coordonneesColis = new ArrayList<Coordonnee>();
	
	public void addCoordonnees(Coordonnee coordonnees){
		coordonneesColis.add(coordonnees);
	}

	public int getLigneDepart() {
		return ligneDepart;
	}

	public void setLigneDepart(int ligneDepart) {
		this.ligneDepart = ligneDepart;
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

	public int getColonneDepart() {
		return colonneDepart;
	}

	public void setColonneDepart(int colonneDepart) {
		this.colonneDepart = colonneDepart;
	}

	public List<Coordonnee> getCoordonneesColis() {
		return coordonneesColis;
	}

	public void setCoordonneesColis(List<Coordonnee> coordonneesColis) {
		this.coordonneesColis = coordonneesColis;
	}
}
