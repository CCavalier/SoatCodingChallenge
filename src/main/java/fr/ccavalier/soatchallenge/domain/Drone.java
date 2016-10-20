package fr.ccavalier.soatchallenge.domain;

import java.util.List;

public class Drone {
	
	/**
	 * La position du drone.
	 */
	Coordonnee position;
	
	int nbColisInitial;
	
	int nbColisRestants;
	
	int nbDeplacementsRestants;
	
	List<Integer> listeDeplacements;

	/**
	 * @return the position
	 */
	public Coordonnee getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Coordonnee position) {
		this.position = position;
	}

	/**
	 * @return the nbColisInitial
	 */
	public int getNbColisInitial() {
		return nbColisInitial;
	}

	/**
	 * @param nbColisInitial the nbColisInitial to set
	 */
	public void setNbColisInitial(int nbColisInitial) {
		this.nbColisInitial = nbColisInitial;
	}

	/**
	 * @return the nbColisRestants
	 */
	public int getNbColisRestants() {
		return nbColisRestants;
	}

	/**
	 * @param nbColisRestants the nbColisRestants to set
	 */
	public void setNbColisRestants(int nbColisRestants) {
		this.nbColisRestants = nbColisRestants;
	}

	/**
	 * @return the nbDeplacementsRestants
	 */
	public int getNbDeplacementsRestants() {
		return nbDeplacementsRestants;
	}

	/**
	 * @param nbDeplacementsRestants the nbDeplacementsRestants to set
	 */
	public void setNbDeplacementsRestants(int nbDeplacementsRestants) {
		this.nbDeplacementsRestants = nbDeplacementsRestants;
	}

	public void move(Coordonnee position2) {
		// penser à décrémenter le fucking nb
		
	}
	
	public int getNbToursRestants() {
		return Map.map.getNbTours() - this.listeDeplacements.size();
	}
}
