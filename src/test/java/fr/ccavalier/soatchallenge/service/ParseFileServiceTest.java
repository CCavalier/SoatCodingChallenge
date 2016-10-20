package fr.ccavalier.soatchallenge.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Test;

import fr.ccavalier.soatchallenge.domain.Coordonnee;
import fr.ccavalier.soatchallenge.domain.Map;

public class ParseFileServiceTest {
	

	@Test
	public void nbLignesEtColognesCorrect() throws URISyntaxException{
		URL urlInputFile = this.getClass().getClassLoader().getResource("BigChallengeInput.txt");
		Map map = ParseFileService.parse(urlInputFile.toURI());
		assertNotNull(map);
		assertEquals(500, map.getNbLignes());
		assertEquals(1246, map.getNbColonnes());
		assertEquals(1500, map.getNbCibles());
		assertEquals(400, map.getNbDrones());
		assertEquals(1000, map.getDeplacementMax());
		Coordonnee depart = new Coordonnee(4, 199);
		assertEquals(depart.getLigne(), map.getDepart().getLigne());
		assertEquals(depart.getColonne(), map.getDepart().getColonne());
		/*assertEquals(199, map.getColonneDepart());*/
		
		assert(!map.getCoordonneesColis().isEmpty());
		assertEquals(390, map.getCoordonneesColis().get(0).getLigne());
		assertEquals(43, map.getCoordonneesColis().get(0).getColonne());
	}

	

}
