package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ReadSymptomDataFromFile implements ISymptomReader {
	
	/**
	 * Sorts the specified Map in alphabetical order
	 * @author salima
	 * @param map : Map to sort
	 * @return result: sorted Map
	 */
	@Override	
	public Map<String, Integer> sortMap(Map<String, Integer> map) {
		
		Map<String, Integer> result = map.entrySet()
				  .stream()
				  .sorted(Map.Entry.comparingByKey()) // Compare item keys
				  .collect(Collectors.toMap(
				    Map.Entry::getKey,
				    Map.Entry::getValue,
				    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		return result;
	}
	
	/**
	 *Read the file line by line, then use the following filter:
		if the row value is equal to the "symptom" property of an element object in the list,
		then, we increment the value of its "occurrence" property
		otherwise, we create an object for the new symptom and initialize its occurrence value to 1 and insert it in the list.
		@author Salima
		@param pathFile : source file path
		@return symptom : a result map 
		
	 */
	
	@Override
	public Map<String, Integer> addElementToMap(String pathFile) {
		
		Map<String, Integer> symptoms = new HashMap<String, Integer>();
			
			try (BufferedReader bd = new BufferedReader (new FileReader(pathFile))){ /* (try-with-resources) The stream is 
																				      
																				      automatically closed at the end of the try block */
				String symptom = bd.readLine();
				while (symptom != null) {
					if(symptoms.get(symptom) == null) {
						symptoms.put(symptom, 1);
					}else {
						symptoms.put(symptom, symptoms.get(symptom)+1 );
					}
					symptom = bd.readLine(); // get another symptom
				}
				

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		return sortMap(symptoms);
		
	}

	/**
	 * Method - writeAllListInFile () - which takes a Map as parameter,
	   and write the values and keys of its elements,
	   in the file
	   @author Salima
	   @param: a source map
	 * @param: result file path
	 */
	@Override
	public void writeAllMapInFile(Map<String,Integer> symptoms, String pathFile) {
		
		try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(pathFile)))) {
			// Afficher les symptoms et ses occurences dans la console
			symptoms.entrySet().forEach(s->pw.println(s.getKey() +" = "+ s.getValue()));
			  
		} catch (Exception e1) {
			//Afficher les traces des exceptions
			e1.printStackTrace();
		}
	}


}