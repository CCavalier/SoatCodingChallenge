package fr.ccavalier.soatchallenge.service;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.Test;

public class FileServiceTest {
	
	FileService fileService = new FileService();
	
	URL url = this.getClass().getClassLoader().getResource("test.txt");

	@Test
	public void test() {
		
		String value = fileService.readFile(url.getFile());
		assertNotNull(value);
	}

}
