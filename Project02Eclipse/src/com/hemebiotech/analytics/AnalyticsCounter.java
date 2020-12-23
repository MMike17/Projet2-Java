package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;

public class AnalyticsCounter {
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
		Map<String, Integer> countedSymptoms = countSymptoms(reader);
		reader.close();

		Map<String, Integer> sortedSymptoms = sortSymptoms(countedSymptoms);
		writeFile(sortedSymptoms);
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

	static Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sortedSymptoms = new HashMap<String, Integer>();

		Comparator<String> compareString = new Comparator<String>() {
			@Override
			public int compare(String word1, String word2) {
				if (word1.length() == 0 || word2.length() == 0)
					return 1;

				int char11 = word1.toCharArray()[0];
				int char12 = 0;

				if (word1.length() > 1)
					char12 = word1.toCharArray()[1];

				int char21 = word2.toCharArray()[0];
				int char22 = 0;

				if (word2.length() > 1)
					char22 = word2.toCharArray()[1];

				System.out.print("\n\nword 1 : " + word1 + "\nword 2 : " + word2 + "\n\nchar 11 : " + char11
						+ "\nchar 12 : " + char12 + "\n\nchar 21 : " + char21 + "\nchar 22 : " + char22 + "\n");

				if (char11 > char21) {
					System.out.print("\n" + char11 + " > " + char21 + " return 1");
					return 1;
				} else if (char11 < char21) {
					System.out.print("\n" + char11 + " < " + char21 + " return -1");
					return -1;
				} else {
					if (char12 < char22) {
						System.out.print("\n" + char12 + " < " + char22 + " return 1");
						return -1;
					} else {
						System.out.print("\n" + char12 + " >= " + char22 + " return 1");
						return -1;
					}
				}
			}
		};

		Set<String> keySet = new TreeSet<String>(compareString);

		// puts symptoms in TreeSet so they are sorted
		for (String symptom : symptoms.keySet())
			keySet.add(symptom);

		// feeds sorted symptoms back into HashMap
		for (String key : keySet)
			sortedSymptoms.put(key, symptoms.get(key));

		return sortedSymptoms;
	}

	static void writeFile(Map<String, Integer> symptoms) throws IOException {
		FileWriter writer = new FileWriter("result.out");

		for (String key : symptoms.keySet())
			writer.write(key + " : " + symptoms.get(key) + "\n");

		writer.close();
	}
}
