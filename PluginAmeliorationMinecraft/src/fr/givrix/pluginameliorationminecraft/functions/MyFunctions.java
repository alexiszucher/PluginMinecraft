package fr.givrix.pluginameliorationminecraft.functions;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyFunctions {
	
	public static void ReplaceText(String location, String word, String replacement) {
		
		// On initialise le chemin d'accès et l'encodage
		Path path = Paths.get(location);
		Charset charset = Charset.forName("UTF-8");
		
		try {
			Scanner scanner = new Scanner(path, charset);
			List<String> replacedLines = new ArrayList<>();
			String line;
			
			// On récupère les lignes une par une dans le document
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				
				// Si le mot est présent, on le remplace par le nouveau souhaité
				if (line.matches(".*" + word + ".*")) {
					line = line.replaceAll(line, replacement);
				}
				
				replacedLines.add(line);				
			}
			
			BufferedWriter writer = Files.newBufferedWriter(path, charset);
			
			// On réécrit les lignes une par une dans le document
			for (String replacedLine : replacedLines) {
				writer.write(replacedLine);
				writer.newLine();
			}
			
			// Libération de la mémoire
			writer.close();
			scanner.close();
			
		// Récupération des erreurs
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}