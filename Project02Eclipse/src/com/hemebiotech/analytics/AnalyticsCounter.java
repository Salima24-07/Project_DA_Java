package com.hemebiotech.analytics;

import java.util.Map;

public class AnalyticsCounter {
	
	/**
	 * Initialize the paths of the source and result files, 
	 * and send them by parameter by calling the methods "addElementToMap" and "writeAllMapInFile"
	   of the class "ReadSymptomDataFromFile" 
	 * @author salima
	 * @param args
	 */
	
	public static void main(String args[]) throws Exception {

		String pathFileSymptoms = "symptoms.txt"; // chemin relatif de fichier qui contient les symptoms 
		String nameFileResults = "results.out"; // fichier resultat qui contient le nombre d'occurence de chaque symptom
		ReadSymptomDataFromFile readSymptom = new ReadSymptomDataFromFile();
		Map<String, Integer> symptoms = readSymptom.addElementToMap(pathFileSymptoms);
		readSymptom.writeAllMapInFile(symptoms, nameFileResults); 
	}
}