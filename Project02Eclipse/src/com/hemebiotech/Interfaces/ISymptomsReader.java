package com.hemebiotech.Interfaces;

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
	public Map<String, Integer> getSymptoms();
}
