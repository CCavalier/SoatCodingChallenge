package fr.ccavalier.soatchallenge.domain;

import java.util.List;

public class Stats {
	public static float moyenneDistance=0;
	public static float moyenneDistanceDeplacements=0;
	public static int nbColisLivres=0;
	public static int nbDistances=0;
	public static int nbDeplacements=0;
	
	public static int getNbColisTransportablesNonLivres(List<Drone> flotte) {
		int nbColisNonTransportes=0;
		for(Drone d : flotte) {
			nbColisNonTransportes+=d.getNbColisInitial()-d.getNbColisRestants();
		}
		return nbColisNonTransportes;
	}
}
