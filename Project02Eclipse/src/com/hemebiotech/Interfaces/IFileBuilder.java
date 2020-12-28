package com.hemebiotech.Interfaces;

import java.util.Map;

/**
 * Interface used to build and write file
 */
public interface IFileBuilder
{
	/**
	 * Method used to build and write file
	 * 
	 * @param symptoms Map of symptoms and their occurence count
	 */
	public void buildFile(Map<String, Integer> symptoms);
}
