package com.hemebiotech.analytics;

import com.hemebiotech.Interfaces.ISymptomsReader;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter
{
	public static void main(String args[]) throws Exception
	{
		ISymptomsReader symptomsReader = new SimpleSymptomReader(
				"symptoms.txt");
		Map<String, Integer> countedSymptoms = symptomsReader.getSymptoms();
		Map<String, Integer> sortedSymptoms = sortSymptoms(countedSymptoms);
		writeFile(sortedSymptoms);
	}

	static Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms)
	{
		Map<String, Integer> sortedMap = new TreeMap<String, Integer>();

		for (String symptom : symptoms.keySet())
			sortedMap.put(symptom, symptoms.get(symptom));

		return sortedMap;
	}

	static void writeFile(Map<String, Integer> symptoms) throws IOException
	{
		FileWriter writer = new FileWriter("result.out");

		for (String key : symptoms.keySet())
			writer.write(key + " : " + symptoms.get(key) + "\n");

		writer.close();
	}
}
