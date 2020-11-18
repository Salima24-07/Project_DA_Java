package com.hemebiotech.analytics;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		
		String path_FileSymptoms = "symptoms.txt"; // chemin relatif de fichier qui contient les symptoms 
		String name_FileResults = "results.out"; // fichier resultat qui contient le nombre d'occurence de chaque symptom
		ReadSymptomDataFromFile read_Symptoms = new ReadSymptomDataFromFile();
		read_Symptoms.writeAllListInFile(read_Symptoms.GetSymptoms(path_FileSymptoms), name_FileResults);
	}
}