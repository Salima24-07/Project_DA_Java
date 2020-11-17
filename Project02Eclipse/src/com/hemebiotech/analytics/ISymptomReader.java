package com.hemebiotech.analytics;

import java.util.List;

import java.util.HashMap;

public interface ISymptomReader {
	HashMap<String, Integer> addElementToMap(String path_File );
	void writeAllMapInFile (HashMap<String,Integer> map, String path_File);
}
