package fr.ccavalier.soatchallenge.service;

import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;

import org.junit.Test;

public class FileServiceTest {
	
	FileService fileService = new FileService();
	
	URL url = this.getClass().getClassLoader().getResource("test.txt");

	@Test
	public void readFileTest() throws URISyntaxException {
		
		Optional<String> value = fileService.readFile(url.toURI());
		assertNotEquals(value, Optional.empty());
		System.out.println(value);
	}
	
	
	@Test
	public void writeFileTest(){
		
	}

	
	
}
