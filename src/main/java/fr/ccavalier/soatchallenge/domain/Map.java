package fr.ccavalier.soatchallenge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Map {

	public static Map map;
	
	private int nbLignes;
	
	private int nbColonnes;
	
	private int nbCibles;
	
	private int nbDrones;
	
	private int deplacementMax;
	
	private int nbTours;
	
	private Coordonnee depart;
	
	private List<Coordonnee> coordonneesColis = new ArrayList<Coordonnee>();
	
	private List<Colis> colisList = new ArrayList<Colis>();
	
	private List<Colis> colisListInitial = new ArrayList<Colis>();
	
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
	
	public List<Colis> coordoneesToColisList(){
		List<Colis> colisList = new ArrayList<Colis>();
		for(Coordonnee coor: coordonneesColis){
			colisList.add(new Colis(coor));
		}
		return colisList;
	}


	public List<Colis> getColisList() {
		return colisList;
	}


	public void setColisList(List<Colis> colisList) {
		this.colisList = colisList;
	}


	public List<Colis> getColisListInitial() {
		return colisListInitial;
	}


	public void setColisListInitial(List<Colis> colisListInitial) {
		this.colisListInitial = colisListInitial;
	}
}
