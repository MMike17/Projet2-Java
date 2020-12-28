package com.hemebiotech.analytics;

import com.hemebiotech.Interfaces.ISymptomsReader;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * Extracts and counts symptoms from a simple list of symptoms in a .txt file
 */
public class SimpleSymptomReader implements ISymptomsReader
{
	/** name of the file to read (with extention) */
	private String fileName;

	public SimpleSymptomReader(String fileName)
	{
		this.fileName = fileName;
	}

	@Override
	public Map<String, Integer> getSymptoms()
	{
		TreeMap<String, Integer> countedSymptoms = new TreeMap<String, Integer>();
		Object[] fileContent = null;

		try
		{
			BufferedReader fileReader = new BufferedReader(
					new FileReader(fileName));

			try
			{
				// gets file content as array of objects
				fileContent = fileReader.lines().toArray();
			}
			finally
			{
				fileReader.close();
			}
		}
		catch (Exception exception) // catch FileReader instantiation Exception
		{
			System.out.print(exception);
		}

		if (fileContent == null)
		{
			System.out.print("Couldn't read file content");
			return null;
		}

		// counts symptoms
		for (Object symptom : fileContent)
		{
			String castSymptom = (String) symptom;

			if (countedSymptoms.containsKey(castSymptom))
				countedSymptoms.put(castSymptom,
						countedSymptoms.get(castSymptom) + 1);
			else
				countedSymptoms.put(castSymptom, 1);
		}

		return countedSymptoms;
	}
}
