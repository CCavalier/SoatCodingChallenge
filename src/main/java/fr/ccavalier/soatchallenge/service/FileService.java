package fr.ccavalier.soatchallenge.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class FileService {

	public Optional<String> readFile(URI url){
		Optional<String> value = Optional.empty() ;
		try (Stream<String> stream = Files.lines(Paths.get(url))) {

			value = stream.findAny();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	public void writeFile(URI url, String valueToWrite) throws IOException, URISyntaxException {
		Files.write(Paths.get(url), valueToWrite.getBytes());
		Files.write(Paths.get(url), valueToWrite.getBytes());
	}
	
}
