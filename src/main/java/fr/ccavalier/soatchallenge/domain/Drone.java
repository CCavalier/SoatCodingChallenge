package fr.ccavalier.soatchallenge.domain;

import java.util.List;

import fr.ccavalier.soatchallenge.service.util.Utils;

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

	public void move(Coordonnee positionCible) {
		// penser à décrémenter le fucking nb
		List<Integer> deplacements = Utils.getChemin(this.getPosition(), positionCible);
		int distance = deplacements.size();
		
		if(distance>this.getNbDeplacementsRestants() || distance>this.getNbToursRestants()) {
			System.err.println("c'est la merde on peut pas aller là mec!"); 
		}else {
			// le déplacement est un succès
			this.setPosition(positionCible);
			this.listeDeplacements.addAll(deplacements);
			this.setNbColisRestants(this.getNbColisRestants()-1);
			this.setNbDeplacementsRestants(this.getNbDeplacementsRestants()-distance);
		}
	}
	
	public int getNbToursRestants() {
		return Map.map.getNbTours() - this.listeDeplacements.size();
	}

	public void drop(Colis colisLePlusProche) {
		if(!colisLePlusProche.getPosition().equals(this.getPosition())) {
			System.err.println("putain on peut pas drop un colis si on est pas dessus!"); 
		}else if(colisLePlusProche.isEstLivre()){
			System.err.println("merde il a déjà été livré...");
		}else {
			// le drop est un succès
			colisLePlusProche.setEstLivre(true);
			this.setNbColisRestants(this.getNbColisRestants()-1);
		}
	}
	
	/**
	 * comble les déplacements avec des 0
	 */
	public void formaterPourEcrire() {
		for(int i=0;i<this.getNbDeplacementsRestants();i++) {
			this.listeDeplacements.add(Directions.STANBY);
		}
	}

	/**
	 * @return the listeDeplacements
	 */
	public List<Integer> getListeDeplacements() {
		return listeDeplacements;
	}

	/**
	 * @param listeDeplacements the listeDeplacements to set
	 */
	public void setListeDeplacements(List<Integer> listeDeplacements) {
		this.listeDeplacements = listeDeplacements;
	}
}
