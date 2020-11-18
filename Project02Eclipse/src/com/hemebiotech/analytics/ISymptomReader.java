package com.hemebiotech.analytics;

import java.util.List;

public interface ISymptomReader {
	
	List<Symptom> GetSymptoms(String filepath);
	void writeAllListInFile(List<Symptom> symptoms_OCcurnce, String name_File);
	
}
