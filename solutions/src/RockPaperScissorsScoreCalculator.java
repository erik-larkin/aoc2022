public class RockPaperScissorsScoreCalculator extends AbstractSolution
{
	private static final char ROCK = 'A';
	private static final char PAPER = 'B';
	private static final char SCISSORS = 'C';

	private static final char LOSE = 'X';
	private static final char WIN = 'Z';

	private static final int WIN_SCORE = 6;
	private static final int DRAW_SCORE = 3;

	private static final char SHIFT_KEY = 23;
	
	String[] rounds;
	public RockPaperScissorsScoreCalculator()
	{
		super("./inputs/rockpaperscissors.txt");
		rounds = super.lines().toArray(String[]::new);
	}	

	public int solutionOne() { return getScoreForAllRounds(false); };

	public int solutionTwo() { return getScoreForAllRounds(true); };
	
	private int getScoreForAllRounds(boolean correctWay)
	{
		int result = 0;

		for (int i = 0; i < rounds.length; i++)
			result += getScoreForOneRound(rounds[i], correctWay);

		return result;
	}

	private int getScoreForOneRound(String line, boolean correctWay)
	{
		int result = 0;

		char theirMove = line.charAt(0);
		char myMove = decode(line.charAt(2), theirMove, correctWay);

		result += moveValue(myMove);

		if (theirMove == myMove)
			result += DRAW_SCORE;
		else if (isWin(myMove, theirMove))
			result += WIN_SCORE;
		
		return result;
	}

	private char decode(char myMove, char theirMove, boolean correctWay)
	{
		char result;

		if (correctWay)
			result = (char) (theirMove + getShift(myMove, theirMove));
		else
			result = (char) (myMove - SHIFT_KEY);
		
		return result;
	}

	private int getShift(char myMove, char theirMove)
	{
		switch (myMove)
		{
			case WIN: return (theirMove == SCISSORS ? -2 : 1);
			case LOSE: return (theirMove == ROCK ? 2 : -1);
			default:
		}	
		return 0;
	}

	private int moveValue(char move) { return move - 64; }
	
	private boolean isWin(char myMove, char theirMove)
	{
		switch (myMove)
		{
			case ROCK: return (theirMove == SCISSORS);
			case PAPER: return (theirMove == ROCK);
			case SCISSORS: return (theirMove == PAPER);
			default: return false;
		}
	}
}
