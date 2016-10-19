package fr.ccavalier.soatchallenge.service;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;

import org.junit.Test;

public class FileServiceTest {
	
	FileService fileService = new FileService();
	
	URL urlInputFile = this.getClass().getClassLoader().getResource("test.txt");
	

	@Test
	public void readFileTest() throws URISyntaxException {
		Optional<String> value = fileService.readFile(urlInputFile.toURI());
		assertNotEquals(value, Optional.empty());
	}
	
	@Test
	public void writeFileTest() throws URISyntaxException, IOException{
		URI outputFile = new File(new File(urlInputFile.toURI()).getParentFile().toURI().getPath()+"newFile.txt").toURI();
		String expectedOutput = "aze";
		fileService.writeFile(outputFile, expectedOutput);
		Optional<String> value = fileService.readFile(outputFile);
		assertNotEquals(value, Optional.empty());
		assertEquals(expectedOutput, value.get());
	}
}
