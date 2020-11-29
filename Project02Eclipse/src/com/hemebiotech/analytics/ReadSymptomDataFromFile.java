package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Class - ReadSymptomDataFromFile - implémente l'interface - ISymptomReader- 
public class ReadSymptomDataFromFile implements ISymptomReader {
	
	
	// Methode - GetSymptoms() - qui lit un ficher et insert des elements de type "Symptom" dans une liste 	
	@Override
	public List<Symptom> GetSymptoms(String filepath) {
		
		List<Symptom> symptoms = null;
			try {
				/*
				 * lire le fichier ligne par ligne, puis on utilise le filtre suivant: 
				  si la valeur de ligne est égale à la propieté "symptom" d'un objet element dans la liste, 
				  alors, on incrémente la valeur de son propiété "occurence"
				  sinon, on crée un objet pour le nouveau symptom et initialise sa valeur d'occurence à 1 et on l'insert dans la liste.
				 */ 
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				symptoms = new ArrayList<Symptom>();
				String line = reader.readLine();
				
				while (line != null) {	
					String l = line;
					Symptom symptom = symptoms.stream()
		  					  .filter(s -> l.equals(s.getSymptom()))
		  		  			  .findAny().orElse(null);
					if(symptom != null) {
						symptom.setOccurence((symptom.getOccurence())+1);
					}else {
						symptoms.add(new Symptom(line, 1));
					}
					line = reader.readLine();
				}
				
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// tri la liste par ordre alphabétique
			Collections.sort(symptoms, Comparator.comparing(Symptom::getSymptom));

			// Afficher les valeurs des prorietés des objets de type Sypmtom elements de la liste  
			symptoms.forEach(s->System.out.println(s.getSymptom()+ " = " +s.getOccurence()));
		return symptoms;
	}
	
	/* Méthode - writeAllListInFile() - qui prend comme paramétre une liste, 
		et écrit les valeurs des propriétés symptom et ocuurence de ses elements, dans un fichier passé en paramétre.
	*/
	@Override	
	public void writeAllListInFile(List<Symptom> symptoms, String name_File) {
			
			FileWriter fw;
			try {
				
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(name_File)));				 
				symptoms.forEach(s->pw.println(s.getSymptom()+" = "+ s.getOccurence()));
				pw.close();
				  
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

}