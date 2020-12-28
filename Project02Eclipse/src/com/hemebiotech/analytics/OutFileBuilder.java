package com.hemebiotech.analytics;

import com.hemebiotech.Interfaces.IFileBuilder;

import java.io.FileWriter;
import java.util.Map;

/**
 * Writes file with formatted data
 */
public class OutFileBuilder implements IFileBuilder
{
	/**
	 * name of the file (with extention)
	 */
	private String fileName;
	/**
	 * format of file lines
	 */
	private String lineFormat;

	public OutFileBuilder(String fileName, String lineFormat)
	{
		this.fileName = fileName;
		this.lineFormat = lineFormat;
	}

	@Override
	public void buildFile(Map<String, Integer> symptoms)
	{
		String fileContent = new String();

		// feeds data in file depending on format
		for (String key : symptoms.keySet())
			fileContent += String.format(lineFormat, key, symptoms.get(key)) + " \n";

		writeFile(fileContent);
	}

	/**
	 * Writes file
	 * 
	 * @param fileContent content of the file to write
	 */
	void writeFile(String fileContent)
	{
		try
		{
			FileWriter writer = new FileWriter(fileName);

			try
			{
				writer.write(fileContent);
			}
			catch (Exception exception) // catch FileWriter write() Exception
			{
				System.out.print(exception);
			}
			finally
			{
				writer.close();
			}
		}
		catch (Exception exception) // catch FileWriter instanciation Exception
		{
			System.out.print(exception);
		}
	}
}
