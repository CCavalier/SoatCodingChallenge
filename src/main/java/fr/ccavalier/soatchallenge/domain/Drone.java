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
	
	public List<Integer> listeDeplacements;

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

	/**
	 * Déplace le drone sur la position passée en paramètre. <br/>
	 * Calcule le chemin du drone jusqu'à la position, et s'y rend <b>uniquement</b> si le drone a assez de déplacements et de tours restants.<br/>
	 * Affiche un message d'erreur sinon.<br/>
	 * En cas de succès, met à jour :
	 * <ul>
	 * 	<li>la position du drone (désormais égale à positionCible)</li>
	 * 	<li>la liste de déplacements du drone</li>
	 * 	<li>le nombre de déplacements restants du drone</li>
	 * 	<li>(les statistiques de l'application : moyenneDistanceDeplacements et nbDeplacements)</li>
	 * </ul>
	 * Le nombre de tours restants est une valeur calculée, et n'est donc pas mis à jour.
	 * 
	 * @param positionCible la position d'arrivée souhaitée
	 * @return true si le déplacement est un succès, false sinon
	 */
	public boolean move(Coordonnee positionCible) {
		List<Integer> deplacements = Utils.getChemin(this.getPosition(), positionCible);
		int distance = deplacements.size();
		
		if(distance>this.getNbDeplacementsRestants() || distance>this.getNbToursRestants()) {
			System.err.println("c'est la merde on peut pas aller là mec!"); 
			return false;
		}else {
			// le déplacement est un succès
			this.setPosition(positionCible);
			this.listeDeplacements.addAll(deplacements);
			this.setNbDeplacementsRestants(this.getNbDeplacementsRestants()-distance);
			Stats.moyenneDistanceDeplacements = (Stats.moyenneDistanceDeplacements * Stats.nbDeplacements + distance) / (Stats.nbDeplacements + 1 );
			Stats.nbDeplacements++;
			return true;
		}
	}
	
	public int getNbToursRestants() {
		return Map.map.getNbTours() - this.listeDeplacements.size();
	}

	public void drop(Colis colisADrop) {
		if(!colisADrop.getPosition().equals(this.getPosition())) {
			System.err.println("putain on peut pas drop un colis si on est pas dessus!"); 
		}else if(colisADrop.isEstLivre()){
			System.err.println("merde il a déjà été livré...");
		}else {
			// le drop est un succès
			colisADrop.setEstLivre(true);
			Map.map.getColisList().remove(colisADrop);
//			Map.map.setColisList(Utils.removeColis(Map.map.getColisList(),colisADrop));
			this.setNbColisRestants(this.getNbColisRestants()-1);
			Stats.nbColisLivres++;
			System.out.println(" ==> Drop Success");
			System.out.println("");
		}
	}
	
	/**
	 * comble les déplacements avec des 0
	 */
	public void formaterPourEcrire() {
		int nbToursRestants = this.getNbToursRestants();
		for(int i=0;i<nbToursRestants;i++) {
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
