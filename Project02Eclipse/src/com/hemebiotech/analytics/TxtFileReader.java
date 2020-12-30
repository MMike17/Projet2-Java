package com.hemebiotech.analytics;

import com.hemebiotech.Interfaces.ISymptomsReader;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * Extracts and counts symptoms from a simple list of symptoms in a .txt file
 * 
 * @see com.hemebiotech.Interfaces.ISymptomsReader
 * @see com.hemebiotech.analytics.AnalyticsCounter
 * @author MikeMatthews
 */
public class TxtFileReader implements ISymptomsReader
{
	/** name of the file to read (with extention) */
	private String fileName;

	public TxtFileReader(String fileName)
	{
		this.fileName = fileName;
	}

	/**
	 * Reads symptoms from txt file, counts and orders them
	 * 
	 * @see com.hemebiotech.Interfaces.ISymptomsReader
	 */
	@Override
	public Map<String, Integer> getSymptoms()
	{
		Object[] fileContent = null;
		BufferedReader fileReader = null;

		try
		{
			fileReader = new BufferedReader(
					new FileReader(fileName));

			// gets file content as array of objects
			fileContent = fileReader.lines().toArray();
		}
		catch (Exception exception) // catch FileReader instantiation Exception
		{
			exception.printStackTrace();
		}
		finally
		{
			try
			{
				fileReader.close();
			}
			catch (Exception resourceException) // catch Exception of resource closing
			{
				resourceException.printStackTrace();
			}
		}

		if (fileContent == null)
		{
			System.out.print("Couldn't read file content");
			return null;
		}

		return readFile(fileContent);
	}

	/**
	 * Converts file lines into a map of symptoms and their occurences
	 * 
	 * @param fileLines lines read from file
	 * @return Map of symptoms and their occurences
	 * @see #getSymptoms
	 */
	Map<String, Integer> readFile(Object[] fileLines)
	{
		TreeMap<String, Integer> countedSymptoms = new TreeMap<String, Integer>();

		// counts symptoms
		for (Object symptom : fileLines)
		{
			String castSymptom = (String) symptom;

			// adds one to the occurence count of the symptom
			if (countedSymptoms.containsKey(castSymptom))
				countedSymptoms.put(castSymptom, countedSymptoms.get(castSymptom) + 1);
			else // 
				countedSymptoms.put(castSymptom, 1);
		}

		return countedSymptoms;
	}
}
