package fr.ccavalier.soatchallenge.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DroneTest {

	private static final int NB_COLONNES = 50;
	private static final int NB_TOURS = 15;
	
	@Before
	public void setUp() {
		Map map = new Map();
		List<Colis> colisList = new ArrayList<Colis>();
		Colis col1 = new Colis();
		colisList.add(col1);
		
		map.setColisList(colisList);
		
		map.setNbColonnes(NB_COLONNES);
		map.setNbTours(NB_TOURS);
		
		Map.map=map;
	}
	
	@Test
	public void testMoveStraightHorizontal() {
		final int nbDeplRestantsInit = 50;
		Boolean res = false;
		Drone drone = new Drone();
		drone.setListeDeplacements(new ArrayList<Integer>());
		drone.setNbDeplacementsRestants(nbDeplRestantsInit);
		Coordonnee depart = new Coordonnee(10,10);
		Coordonnee arrivee = new Coordonnee(10, 15);
		final int distance = 15 - 10 ;
		drone.setPosition(depart);

		final int nbToursRestants = drone.getNbToursRestants();
		
		res = drone.move(arrivee);
		
		assertTrue(res);
		assertEquals(arrivee, drone.getPosition());
		assertFalse(drone.getListeDeplacements().isEmpty());
		assertEquals(drone.getNbDeplacementsRestants(),nbDeplRestantsInit-distance);
		assertEquals(drone.getNbToursRestants(),nbToursRestants-distance);
		assertEquals(drone.getListeDeplacements().size(),distance);
	}
	
	@Test
	public void testMoveAroundHorizontal() {
		final int nbDeplRestantsInit = 50;
		Boolean res = false;
		Drone drone = new Drone();
		drone.setListeDeplacements(new ArrayList<Integer>());
		drone.setNbDeplacementsRestants(nbDeplRestantsInit);
		Coordonnee depart = new Coordonnee(10,5);
		Coordonnee arrivee = new Coordonnee(10, 45);
		final int distance = NB_COLONNES - (45 - 5); // car il fait le tour
		drone.setPosition(depart);

		final int nbToursRestants = drone.getNbToursRestants();
		
		res = drone.move(arrivee);
		
		assertTrue(res);
		assertEquals(arrivee, drone.getPosition());
		assertFalse(drone.getListeDeplacements().isEmpty());
		assertEquals(drone.getNbDeplacementsRestants(),nbDeplRestantsInit-distance);
		assertEquals(drone.getNbToursRestants(),nbToursRestants-distance);
		assertEquals(drone.getListeDeplacements().size(),distance);
	}
	
	@Test
	public void testMoveStraightVertical() {
		final int nbDeplRestantsInit = 50;
		Boolean res = false;
		Drone drone = new Drone();
		drone.setListeDeplacements(new ArrayList<Integer>());
		drone.setNbDeplacementsRestants(nbDeplRestantsInit);
		Coordonnee depart = new Coordonnee(10,10);
		Coordonnee arrivee = new Coordonnee(15, 10);
		final int distance = 15 - 10 ;
		drone.setPosition(depart);

		final int nbToursRestants = drone.getNbToursRestants();
		
		res = drone.move(arrivee);
		
		assertTrue(res);
		assertEquals(arrivee, drone.getPosition());
		assertFalse(drone.getListeDeplacements().isEmpty());
		assertEquals(drone.getNbDeplacementsRestants(),nbDeplRestantsInit-distance);
		assertEquals(drone.getNbToursRestants(),nbToursRestants-distance);
		assertEquals(drone.getListeDeplacements().size(),distance);
	}
	
	@Test
	public void testMove() {
		final int nbDeplRestantsInit = 50;
		Boolean res = false;
		Drone drone = new Drone();
		drone.setListeDeplacements(new ArrayList<Integer>());
		drone.setNbDeplacementsRestants(nbDeplRestantsInit);
		Coordonnee depart = new Coordonnee(10,10);
		Coordonnee arrivee = new Coordonnee(15, 15);
		final int distance = (15 - 10) + (15 - 10) ;
		drone.setPosition(depart);

		final int nbToursRestants = drone.getNbToursRestants();
		
		res = drone.move(arrivee);
		
		assertTrue(res);
		assertEquals(arrivee, drone.getPosition());
		assertFalse(drone.getListeDeplacements().isEmpty());
		assertEquals(drone.getNbDeplacementsRestants(),nbDeplRestantsInit-distance);
		assertEquals(drone.getNbToursRestants(),nbToursRestants-distance);
		assertEquals(drone.getListeDeplacements().size(),distance);
	}

	@Test
	public void testGetNbToursRestants() {
//		fail("Not yet implemented");
	}

	@Test
	public void testDrop() {
//		fail("Not yet implemented");
	}

	@Test
	public void testFormaterPourEcrire() {
//		fail("Not yet implemented");
	}

}
