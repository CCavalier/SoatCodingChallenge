package fr.ccavalier.soatchallenge.service;

import static org.junit.Assert.assertNotEquals;

import java.io.File;
import java.io.IOException;
import java.net.URI;
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
	}
	
	
	@Test
	public void writeFileTest() throws URISyntaxException, IOException{
		String outputFile = "C:/output.txt";
		fileService.writeFile(outputFile, "aze");
//		Optional<String> value = fileService.readFile(outputFile);
//		assertNotEquals(value, Optional.empty());
	}

	
	
}
