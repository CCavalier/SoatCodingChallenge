package fr.ccavalier.soatchallenge.service.util;

import java.util.ArrayList;
import java.util.List;

import fr.ccavalier.soatchallenge.domain.Coordonnee;
import fr.ccavalier.soatchallenge.domain.Directions;
import fr.ccavalier.soatchallenge.domain.Drone;
import fr.ccavalier.soatchallenge.domain.Map;

public class Utils {

	public static int getDistance(Coordonnee A, Coordonnee B) {
		int distance = 0;
		
		distance = getChemin(A, B).size();
		
		return distance;
	}

	/**
	 * Retourne le chemin <b> de A à B !!! </b>
	 * On se déplace latéralement puis verticalement
	 * 
	 * @param A origine
	 * @param B arrivée
	 * @return le chemin (liste de déplacements)
	 */
	public static List<Integer> getChemin(Coordonnee A, Coordonnee B) {
		boolean onEstArrives =  A.equals(B);
		List<Integer> deplacements = new ArrayList<Integer>();
		
		while(!onEstArrives) {
			if(A.getColonne()==B.getColonne()) {
				// on est sur la même colonne
				if(A.getLigne()<B.getLigne()) {
					// A est plus haut que B ; on doit donc descendre
					deplacements.add(Directions.BAS);
				}else {
					// A est plus bas que B ; on doit donc monter
					deplacements.add(Directions.HAUT);
				}
			} else {
				// ils sont pas sur la même colonne : déplacement latéral donc
				/** la largeur de la map **/
				int largeurMap = 0; //TODO : remplacer par la bonne valeur
				/** la distance qui les sépare (en colonne, en ignorant les lignes) **/
				int distanceEnColonnes = Math.abs(A.getColonne()-B.getColonne());
				if(distanceEnColonnes<(largeurMap-distanceEnColonnes)) {
					//il vaut mieux y aller direct plutôt que faire le tour
					if(A.getColonne()<B.getColonne()) {
						// A est plus à gauche que B ; on doit donc aller à droite
						deplacements.add(Directions.DROITE);
					}else {
						// A est plus à droite que B ; on doit donc aller à gauche
						deplacements.add(Directions.GAUCHE);
					}
				}else {
					// il vaut mieux faire le "tour"
					if(A.getColonne()<B.getColonne()) {
						// A est plus à gauche que B ; on doit donc aller à gauche pour faire le tour
						deplacements.add(Directions.GAUCHE);
					}else {
						// A est plus à droite que B ; on doit donc aller à droite pour faire le tour
						deplacements.add(Directions.DROITE);
					}
				}
			}
		}
		
		return deplacements;
	}
	 
	public List<Drone> initFlotte() {
		List<Drone> flotte = new ArrayList<Drone>();
		
		for(int i=0; i<Map.map.getNbDrones();i++) {
			Drone drone = new Drone();
			drone.setListeDeplacements(new ArrayList<Integer>());
			drone.setNbColisInitial(4);
			drone.setNbColisRestants(drone.getNbColisInitial());
			drone.setNbDeplacementsRestants(Map.map.getDeplacementMax()-40*4);
			drone.setPosition(Map.map.getDepart());
			flotte.add(drone);
		}
		
		return flotte;
	}
}
