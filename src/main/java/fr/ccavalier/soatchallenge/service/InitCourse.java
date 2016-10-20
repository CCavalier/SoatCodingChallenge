package fr.ccavalier.soatchallenge.service;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import fr.ccavalier.soatchallenge.domain.Drone;
import fr.ccavalier.soatchallenge.domain.Map;

public class InitCourse {

	public static void main(String[] args) throws URISyntaxException, IOException {
		FileService fileService = new FileService();
		URL urlInputFile = fileService.getClass().getClassLoader().getResource("BigChallengeInput.txt");
		Map map = ParseFileService.parse(urlInputFile.toURI());
		map.setColisList(map.coordoneesToColisList());
		List<Drone> droneList =new ArrayList<Drone>();
		String valueToWrite = "";
		for(Drone drone : droneList){
			String moves = String.valueOf(4-drone.getNbColisRestants());
			
			for(Integer val : drone.listeDeplacements){
				moves+=val+" ";
			}
			 valueToWrite+=moves+System.lineSeparator();
		}
		URI outputFile = new File(new File(urlInputFile.toURI()).getParentFile().toURI().getPath()+"resultat.txt").toURI();
		Files.write(Paths.get(outputFile), valueToWrite.getBytes());

	}

}
