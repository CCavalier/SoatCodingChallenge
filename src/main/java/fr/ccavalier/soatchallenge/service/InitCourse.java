package fr.ccavalier.soatchallenge.service;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import fr.ccavalier.soatchallenge.domain.Colis;
import fr.ccavalier.soatchallenge.domain.Map;

public class InitCourse {

	public static void main(String[] args) throws URISyntaxException {
		FileService fileService = new FileService();
		URL urlInputFile = fileService.getClass().getClassLoader().getResource("BigChallengeInput.txt");
		Map map = ParseFileService.parse(urlInputFile.toURI());
		map.setColisList(map.coordoneesToColisList());

	}

}
