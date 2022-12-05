public class Main
{
	public static void main(String[] args)
	{
		int day = 2;
		AbstractSolution<Integer> solution = getSolutionForDay(day);

		if (solution != null)
		{
			String answer = String.format("Part 1: %d%Part 2: %d%n", 	
				solution.solutionOne(), solution.solutionTwo());

			System.out.println(answer);	
		}
		else
			System.err.printf("No solution exists for day %d.%n", day);
	}
	
	private static AbstractSolution<Integer> getSolutionForDay(int day)
	{
		switch (day)
		{
			case 1: return new CalorieCounter();
			case 2: return new RockPaperScissorsScoreCalculator();
			default: return null;
		}
	}
}
