package com.hemebiotech.Interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * Interface used to read symptoms from file
 */
public interface ISymptomsReader
{
	/**
	 * Method used to get symptoms from file
	 * 
	 * @return a Map of unique symptoms and their occurance count
	 */
	public Map<String, Integer> getSymptoms()
			throws FileNotFoundException, IOException;
}
