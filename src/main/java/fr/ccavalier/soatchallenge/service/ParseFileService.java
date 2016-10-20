package fr.ccavalier.soatchallenge.service;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import fr.ccavalier.soatchallenge.domain.Coordonnee;
import fr.ccavalier.soatchallenge.domain.Map;

@Service
public class ParseFileService {

	public static Map parse(URI uri) {
		Map map = new Map();
		try (Stream<String> stream = Files.lines(Paths.get(uri))) {

			Iterator<String> iterator = stream.iterator();

			String[] firstLine = iterator.next().split("\\s+");
			map.setNbLignes(Integer.valueOf(firstLine[0]));
			map.setNbColonnes(Integer.valueOf(firstLine[1]));

			String[] secondLine = iterator.next().split("\\s+");

			map.setNbCibles(Integer.valueOf(secondLine[0]));
			map.setNbDrones(Integer.valueOf(secondLine[1]));
			map.setDeplacementMax(Integer.valueOf(secondLine[2]));
			map.setNbTours(Integer.valueOf(secondLine[3]));

			String[] thirdLine = iterator.next().split("\\s+");
			map.setLigneDepart(Integer.valueOf(thirdLine[0]));
			map.setColonneDepart(Integer.valueOf(thirdLine[1]));

			while (iterator.hasNext()) {
				String[] coordonneesLine = iterator.next().split("\\s+");
				map.addCoordonnees(new Coordonnee(Integer.valueOf(coordonneesLine[0]),
						Integer.valueOf(coordonneesLine[1])));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return map;
	}

}
