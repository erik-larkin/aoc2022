import java.util.Arrays;

public class RucksackPrioritiser extends AbstractSolution 
{
	private static final int UPPER_OFFSET = 38;
	private static final int LOWER_OFFSET = 96;

	String[] rucksacks;

	public RucksackPrioritiser()
	{
		super("./inputs/rucksacks.txt");
		rucksacks = super.lines().toArray(String[]::new);
	}

	public int solutionOne() { return sumRepeatedPriorities(rucksacks); }

	public int solutionTwo() { return sumBadges(rucksacks); }

	private int sumRepeatedPriorities(String[] rucksacks)
	{
		int result = 0;
		for (int i = 0; i < rucksacks.length; i++)
			result += getRepeatedPriority(rucksacks[i]);

		return result;
	}
	
	private int sumBadges(String[] rucksacks)
	{
		int result = 0;
		for (int i = 0; i < rucksacks.length; i += 3)
			result += findBadges(i, rucksacks);

		return result;
	}

	private int findBadges(int startIndex, String[] rucksacks)
	{
		int[] rucksack1 = getPriorities(rucksacks[startIndex]);
		int[] rucksack2 = getPriorities(rucksacks[startIndex + 1]);
		int[] rucksack3 = getPriorities(rucksacks[startIndex + 2]);

		Arrays.sort(rucksack2);
		Arrays.sort(rucksack3);

		for (int item : rucksack1)
		{
			if (Arrays.binarySearch(rucksack2, item) >= 0 && 
					Arrays.binarySearch(rucksack3, item) >= 0)
				return item;
		}

		return 0;
	}

	private int getRepeatedPriority(String rucksack)
	{
		int[] priorities = getPriorities(rucksack);
		int length = priorities.length;

		int[] firstCompartment = getSubarray(priorities, 0, length / 2);
		int[] secondCompartment = getSubarray(priorities, (length / 2), length);

		int repeatedPriority = findRepeatedItem(firstCompartment, secondCompartment);

		return repeatedPriority; 
	}

	private int[] getPriorities(String contents) { return getPriorities(contents.toCharArray()); }

	private int[] getPriorities(char[] contents)
	{
		if (contents != null && contents.length > 0)
		{
			int[] result = new int[contents.length];

			for (int i = 0; i < contents.length; i++)
			{
				int item = contents[i];
				if (item < 91)
					result[i] = item - UPPER_OFFSET;
				else
					result[i] = item - LOWER_OFFSET;
			}

			return result;
		}
		return null;
	}

	private int[] getSubarray(int[] array, int start, int end)
	{
		return Arrays.copyOfRange(array, start, end);
	}
	
	private int findRepeatedItem(int[] arr1, int[] arr2)
	{
		int[] sortedArr2 = Arrays.copyOf(arr2, arr2.length);
		Arrays.sort(sortedArr2);

		for (int i = 0; i < arr1.length; i++)
		{
			if (Arrays.binarySearch(sortedArr2, arr1[i]) >= 0)
				return arr1[i];	
		}

		return 0;
	}
}
