package fr.ccavalier.soatchallenge.service.util;

import java.util.ArrayList;
import java.util.List;

import fr.ccavalier.soatchallenge.domain.Colis;
import fr.ccavalier.soatchallenge.domain.Coordonnee;
import fr.ccavalier.soatchallenge.domain.Directions;
import fr.ccavalier.soatchallenge.domain.Drone;
import fr.ccavalier.soatchallenge.domain.Map;
import fr.ccavalier.soatchallenge.domain.Stats;

public class Utils {

	public static int getDistance(Coordonnee A, Coordonnee B) {
		int distance = 0;
		
		distance = getChemin(A, B).size(); // TODO : passer par le calcul orthogonal ( sqrt((x1-x2)²+(y1-y2)²) )
		
//		System.out.println("Il faut " + distance + " déplacements pour aller de " + A + " à " + B);
		
		Stats.moyenneDistance = (Stats.moyenneDistance*Stats.nbDistances+distance) / (Stats.nbDistances + 1 );
		Stats.nbDistances++;
		
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
	public static List<Integer> getChemin(Coordonnee coordA, Coordonnee coordB) {
		Coordonnee A = new Coordonnee(coordA.getLigne(),coordA.getColonne());
		Coordonnee B = new Coordonnee(coordB.getLigne(),coordB.getColonne());
		boolean onEstArrives =  A.equals(B);
		List<Integer> deplacements = new ArrayList<Integer>();
		
		while(!onEstArrives) {
			if(A.getColonne()==B.getColonne()) {
				// on est sur la même colonne
				if(A.getLigne()<B.getLigne()) {
					// A est plus haut que B ; on doit donc descendre
					deplacements.add(Directions.BAS);
					A.setLigne(A.getLigne()+1);
				}else {
					// A est plus bas que B ; on doit donc monter
					deplacements.add(Directions.HAUT);
					A.setLigne(A.getLigne()-1);
				}
			} else {
				// ils sont pas sur la même colonne : déplacement latéral donc
				/** la largeur de la map **/
				int largeurMap = Map.map.getNbColonnes();
				/** la distance qui les sépare (en colonne, en ignorant les lignes) **/
				int distanceEnColonnes = Math.abs(A.getColonne()-B.getColonne());
				if(distanceEnColonnes<(largeurMap-distanceEnColonnes)) {
					//il vaut mieux y aller direct plutôt que faire le tour
					if(A.getColonne()<B.getColonne()) {
						// A est plus à gauche que B ; on doit donc aller à droite
						deplacements.add(Directions.DROITE);
						A.setColonne(A.getColonne()+1);
					}else {
						// A est plus à droite que B ; on doit donc aller à gauche
						deplacements.add(Directions.GAUCHE);
						A.setColonne(A.getColonne()-1);
					}
				}else {
					// il vaut mieux faire le "tour"
					if(A.getColonne()<B.getColonne()) {
						// A est plus à gauche que B ; on doit donc aller à gauche pour faire le tour
						deplacements.add(Directions.GAUCHE);
						A.setColonne(A.getColonne()<=1?largeurMap:A.getColonne()-1);
					}else {
						// A est plus à droite que B ; on doit donc aller à droite pour faire le tour
						deplacements.add(Directions.DROITE);
						A.setColonne((A.getColonne()+1)%largeurMap);
					}
				}
			}
//			System.out.println("Deplacement["+deplacements.size()+"] = " + deplacements.get(deplacements.size()-1));
//			System.out.println("A est en " + A);
			onEstArrives = A.equals(B);
		}
		
		return deplacements;
	}
	 
	public static List<Drone> initFlotte() {
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

	public static List<Colis> removeColis(List<Colis> colisList, Colis colisADrop) {
		List<Colis> list = new ArrayList<Colis>();
		for(Colis col : colisList) {
			if(col.equals(colisADrop)) {
				
			}
		}
		return list;
	}
}
