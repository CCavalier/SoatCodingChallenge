package fr.ccavalier.soatchallenge.service;

import fr.ccavalier.soatchallenge.domain.Colis;
import fr.ccavalier.soatchallenge.domain.Drone;
import fr.ccavalier.soatchallenge.service.util.Utils;

public class DroneIntelligence {
		
	public void deplacementJusquauColisLePlusProche(Drone drone) {
		Colis colisLePlusProche = getColisLePlusProche(drone);
		int distance = Utils.getDistance(drone.getPosition(), colisLePlusProche.getPosition());
		if(distance<drone.getNbDeplacementsRestants()
			&& distance<drone.getNbToursRestants()) {
			// on peut se déplacer jusque là
			drone.move(colisLePlusProche.getPosition());
		}
	}

	private Colis getColisLePlusProche(Drone drone) {
		// TODO Auto-generated method stub
		return null;
	}
}
