package com.hemebiotech.analytics;

import java.util.Map;

/** 
 * "ISymptomReader": An interface that defines the behavior of the class that implements it
 * @author salima
 */

public interface ISymptomReader {

	Map<String, Integer> addElementToMap( String pathFile );
	Map<String, Integer> sortMap(Map<String, Integer> map);
	void writeAllMapInFile (Map<String,Integer> map, String pathFile);
}