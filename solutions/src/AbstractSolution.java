import java.util.AbstractCollection;

public abstract class AbstractSolution<T>
{
	private AbstractCollection<String> lines;

	public AbstractSolution(String filename)
	{
		FileParser parser = new FileParser(filename);
		lines = parser.lines();
		parser.closeFile();
	}

	public AbstractCollection<String> lines() { return lines; }

	public abstract T solutionOne();

	public abstract T solutionTwo();
}
