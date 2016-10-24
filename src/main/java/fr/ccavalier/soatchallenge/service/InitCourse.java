package fr.ccavalier.soatchallenge.service;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import fr.ccavalier.soatchallenge.domain.Drone;
import fr.ccavalier.soatchallenge.domain.Map;
import fr.ccavalier.soatchallenge.domain.Stats;
import fr.ccavalier.soatchallenge.service.util.Utils;

public class InitCourse {

	public static void main(String[] args) throws URISyntaxException, IOException {
		FileService fileService = new FileService();
		URL urlInputFile = fileService.getClass().getClassLoader().getResource("BigChallengeInput.txt");
		Map map = ParseFileService.parse(urlInputFile.toURI());
		Map.map = map;
		map.setColisList(map.coordoneesToColisList());
		map.getColisListInitial().addAll(map.getColisList());
		List<Drone> droneList = Utils.initFlotte();
		DroneIntelligence.intelligenceFlotte(droneList);
		
		/* STATISTIQUES */
		System.out.println("--------------------------------------------------------------------------------------"
						 + "\nSTATS : \n"
						 + "--------------------------------------------------------------------------------------");
		System.out.println("\n\n\t __ DONNEES INITIALES __");
		System.out.println(" - Position de départ : " + Map.map.getDepart());
		System.out.println(" - Nombre de drones : " + Map.map.getNbDrones()); 
		System.out.println(" - Nombre de déplacements maximum par drone : " + Map.map.getDeplacementMax());
		System.out.println(" - Nombre de déplacements maximum par drone avec mon approximation à la con : " + (Map.map.getDeplacementMax()-40*4));
		System.out.println(" - Nombre de colis cibles : " + Map.map.getColisListInitial().size());
		System.out.println(" - Déplacements perdus : " + (Stats.getNbColisTransportablesNonLivres(droneList)*40));
		
		System.out.println("\n\n\t __ DONNEES FINALES __");
		System.out.println(" - Nombre de colis livrés : " + Stats.nbColisLivres);
		System.out.println(" - Nombre de distances calculées : " + Stats.nbDistances);
		System.out.println(" - Moyenne des distances calculées : " + Stats.moyenneDistance);
		System.out.println(" - Nombre de déplacements réalisés : " + Stats.nbDeplacements);
		System.out.println(" - Moyenne de la distance de déplacement : " + Stats.moyenneDistanceDeplacements);
		
		System.out.println("\n\n\t\t************ SCORE ************\n");
		int nbColisLivres = (Map.map.getColisListInitial().size() - Map.map.getColisList().size());
		//nb_colis * ((nb_tour * nb_drones) - nb_deplacement_fait)
		System.out.println("nb_colis * ((nb_tour * nb_drones) - nb_deplacement_fait) = " +  nbColisLivres
				+ " * ((" + (Map.map.getNbTours()) + " * " + Map.map.getNbDrones() + ") - " + Stats.nbDeplacements * Stats.moyenneDistanceDeplacements + ")");
		long score = 0;
		score = nbColisLivres * ((Map.map.getNbTours() * Map.map.getNbDrones()) - ((long)((float)Stats.nbDeplacements * Stats.moyenneDistanceDeplacements)));
		if(Map.map.getColisList().isEmpty()) {
			System.out.println("\t BONUS tous colis livrés : (nb_colis * 10) = (" + Map.map.getColisListInitial().size() + " * 10 ) = " + (Map.map.getColisListInitial().size()*10));
			score += Map.map.getColisListInitial().size()*10;
		}
		System.out.println("\n*-------------\n\tSCORE FINAL* = " + score+"\n-------------\n");
		
		StringBuffer valueToWrite = new StringBuffer();
		for(Drone drone : droneList){
			drone.formaterPourEcrire();
			StringBuffer moves = new StringBuffer();
			moves.append(String.valueOf(4-drone.getNbColisRestants()));
			
			for(Integer val : drone.listeDeplacements){
				moves.append(" " + val);
			}
			 valueToWrite.append(moves.toString()+System.lineSeparator());
		}
		URI outputFile = new File(new File(urlInputFile.toURI()).getParentFile().toURI().getPath()+"resultat.txt").toURI();
		Files.write(Paths.get(outputFile), valueToWrite.toString().getBytes());
		System.out.println("\n\n -- FIN ECRITURE FICHIER --");
	}

}
