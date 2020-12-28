package com.hemebiotech.analytics;

import com.hemebiotech.Interfaces.IFileBuilder;
import com.hemebiotech.Interfaces.ISymptomsReader;

import java.util.Map;

public class AnalyticsCounter
{
	public static void main(String args[]) throws Exception
	{
		ISymptomsReader symptomsReader = new SimpleSymptomReader("symptoms.txt");
		IFileBuilder fileBuilder = new OutFileBuilder("result.out", "%1$s : %2$s");

		Map<String, Integer> countedSymptoms = symptomsReader.getSymptoms();
		fileBuilder.buildFile(countedSymptoms);
	}
}
