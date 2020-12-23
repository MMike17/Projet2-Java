package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;

public class AnalyticsCounter {
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
		Map<String, Integer> countedSymptoms = countSymptoms(reader);
		reader.close();

		writeFile(countedSymptoms);
	}

	static Map<String, Integer> countSymptoms(BufferedReader reader) {
		Map<String, Integer> symptoms = new HashMap<String, Integer>();
		Object[] fileContent = reader.lines().toArray();

		for (Object symptom : fileContent) {
			String castSymptom = (String) symptom;

			if (symptoms.containsKey(castSymptom))
				symptoms.put(castSymptom, symptoms.get(castSymptom) + 1);
			else
				symptoms.put(castSymptom, 1);
		}

		return symptoms;
	}

	static void writeFile(Map<String, Integer> symptoms) throws IOException {
		FileWriter writer = new FileWriter("result.out");

		for (String key : symptoms.keySet())
			writer.write(key + " : " + symptoms.get(key) + "\n");

		writer.close();
	}
}
