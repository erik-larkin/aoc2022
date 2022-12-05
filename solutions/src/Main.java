public class Main
{
	public static void main(String[] args)
	{
		int day = 3;
		AbstractSolution solution = getSolutionForDay(day);

		if (solution != null)
		{
			System.out.printf("Part 1: %d%nPart 2: %d%n", 	
				solution.solutionOne(), solution.solutionTwo());	
		}
		else
			System.err.printf("No solution exists for day %d.%n", day);
	}
	
	private static AbstractSolution getSolutionForDay(int day)
	{
		switch (day)
		{
			case 1: return new CalorieCounter();
			case 2: return new RockPaperScissorsScoreCalculator();
			case 3: return new RucksackPrioritiser();
			default: return null;
		}
	}
}
