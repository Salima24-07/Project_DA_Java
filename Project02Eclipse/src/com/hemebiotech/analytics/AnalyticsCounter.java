package com.hemebiotech.analytics;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		String path_FileSymptoms = "symptoms.txt"; // Chemin relatif de fichier qui contient les symptoms 
		String path_FileResults = "results.out"; // Fichier résultat qui contient le nombre d'occurence de chaque symptom
		ReadSymptomDataFromFile read_Symptoms = new ReadSymptomDataFromFile();
		read_Symptoms.writeAllMapInFile(read_Symptoms.addElementToMap(path_FileSymptoms), path_FileResults); 
	}
	
}