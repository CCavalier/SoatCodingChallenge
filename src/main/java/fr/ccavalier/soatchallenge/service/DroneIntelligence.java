package fr.ccavalier.soatchallenge.service;

import java.util.Iterator;
import java.util.List;

import fr.ccavalier.soatchallenge.domain.Colis;
import fr.ccavalier.soatchallenge.domain.Drone;
import fr.ccavalier.soatchallenge.domain.Map;
import fr.ccavalier.soatchallenge.service.util.Utils;

public class DroneIntelligence {
	
	public static void intelligenceFlotte(List<Drone> flotte) {
		Iterator<Drone> it = flotte.iterator();
		
		while(it.hasNext()) {
			Drone drone = it.next();
			if(drone.getNbColisRestants()>0) {
				intelligenceDrone(drone);
			}
		}
	}
		
	public static void intelligenceDrone(Drone drone) {
		boolean dead = false;
		
		while(!dead) {
			// on va chercher le colis le plus proche
			Colis colisLePlusProche = deplacementJusquauColisLePlusProche(drone);
			if(colisLePlusProche != null) {
				// le déplacement est un succès
				// on lâche le colis
				drone.drop(colisLePlusProche);
			}
			
			dead = drone.getNbColisRestants()==0 || colisLePlusProche == null;
		}
	}
	
	public static Colis deplacementJusquauColisLePlusProche(Drone drone) {
		Colis colisLePlusProche = getColisLePlusProche(drone);
		if(colisLePlusProche != null) {
			int distance = Utils.getDistance(drone.getPosition(), colisLePlusProche.getPosition());
			if(distance<drone.getNbDeplacementsRestants()
				&& distance<drone.getNbToursRestants()) {
				// on peut se déplacer jusque là
				drone.move(colisLePlusProche.getPosition());
			}else {
				colisLePlusProche = null;
			}
		}else {
			// plus de colis
		}
		return colisLePlusProche;
	}

	private static Colis getColisLePlusProche(Drone drone) {
		List<Colis> listColis = Map.map.getColisList();
		Iterator<Colis> it = listColis.iterator();
		Colis colisLePlusProche = null;
		
		while(it.hasNext()) {
			Colis colis = it.next();
			if(colisLePlusProche==null) { colisLePlusProche=colis;}
			if(!colis.isEstLivre()) {
				if(Utils.getDistance(drone.getPosition(), colis.getPosition())<Utils.getDistance(drone.getPosition(),colisLePlusProche.getPosition())) {
					colisLePlusProche = colis;
				}
			}
		}
		
		return colisLePlusProche;
	}
}
