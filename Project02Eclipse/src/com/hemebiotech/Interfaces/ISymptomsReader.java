package com.hemebiotech.Interfaces;

import java.util.Map;

/**
 * Interface used to read symptoms
 * 
 * @see com.hemebiotech.analytics.AnalyticsCounter
 * @author MikeMatthews
 */
public interface ISymptomsReader
{
	/**
	 * Method used to get symptoms
	 * 
	 * @return a Map of unique symptoms and their occurance count
	 */
	public Map<String, Integer> getSymptoms();
}
