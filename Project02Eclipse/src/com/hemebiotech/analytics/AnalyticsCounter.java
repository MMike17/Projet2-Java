package com.hemebiotech.analytics;

import com.hemebiotech.Interfaces.IFileBuilder;
import com.hemebiotech.Interfaces.ISymptomsReader;

import java.util.Map;

/**
 * Program entry point
 * 
 * @see com.hemebiotech.Interfaces.ISymptomsReader
 * @see com.hemebiotech.Interfaces.IFileBuilder
 * @author MikeMatthews
 */
public class AnalyticsCounter
{
	public static void main(String args[]) throws Exception
	{
		// instantiating classes references as Interfaces
		ISymptomsReader symptomsReader = new TxtFileReader("symptoms.txt");
		IFileBuilder fileBuilder = new OutFileBuilder("result.out", "%1$s : %2$s");

		Map<String, Integer> countedSymptoms = symptomsReader.getSymptoms();
		fileBuilder.buildFile(countedSymptoms);
	}
}
