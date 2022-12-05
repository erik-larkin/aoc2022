import java.util.AbstractCollection;
import java.util.Collections;
import java.util.PriorityQueue;

public class CalorieCounter extends AbstractSolution
{
	private PriorityQueue<Integer> calories;
	
	public CalorieCounter()
	{
		super("./inputs/calories.txt");
		calories = countCalories(super.lines()); 
	}

	public int solutionOne() { return calories.poll(); }
	
	public int solutionTwo() { return calories.poll() + calories.poll() + calories.poll(); }
		
	private PriorityQueue<Integer> countCalories(AbstractCollection<String> lines)
	{
		PriorityQueue<Integer> result = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		int currentCalories = 0;

		for (String line : lines)
		{
			if (line.isBlank())
			{
				result.add(currentCalories);
				currentCalories = 0;	
			}
			else
				currentCalories += Integer.parseInt(line);	
		}
		
		return result;
	}	
}