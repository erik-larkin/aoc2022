import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractCollection;
import java.util.ArrayList;

public class FileParser 
{
	private static BufferedReader reader;
	private AbstractCollection<String> lines;
	
	public FileParser() {}
	public FileParser(String filename) { openFile(filename); }	

	public void openFile(String filename)
	{
		try
		{
			if (reader != null)
				reader.close();
				
			reader = new BufferedReader(new FileReader(filename));
			lines = getLines();
		}
		catch (Exception e)
		{
			System.err.printf("%s could not be opened. Error message: %s%n", filename, e);
			System.exit(1);
		}
	}
	
	public void closeFile()
	{
		try
		{
			if (reader != null)
				reader.close();

			reader = null;
		}
		catch (Exception e)
		{
			System.err.printf("File could not be closed. Error message: %s%n", e);
		}
	}

	public AbstractCollection<String> lines() { return lines; }

	private AbstractCollection<String> getLines() throws IOException
	{
		ArrayList<String> result = new ArrayList<String>();
		String line = reader.readLine();
		
		while (line != null)
		{
			result.add(line);
			line = reader.readLine();
		}
		
		return result;
	}
}
