/*
 *  An interface that you will implement in the StudentTrends class.
 */
public interface Trends {	
	
	/**
	 * Increase the count of string s.
	 * 
	 * @param s          String whose count is being increased.
	 * @param amount     Amunt by which it is being increased.
	 */
	public void increaseCount(String s, int amount);
	
	/**
	 * Return the number of times string s has been seen.
	 * @param s     The string we are counting.
	 * @return int  The number of times s has been seen thus far.
	 */
	public int getCount(String s);
	
	
	/**
	 * Get the nth most popular item based on its count.  (0 = most popular, 1 = 2nd most popular).
	 * In case of a tie, return the string that comes first alphabetically.
	 * @param n         Rank requested
	 * @return string   nth most popular string.
	 */
	public String getNthMostPopular(int n);

	/**
	 * Return the total number of UNIQUE strings in the list. This will NOT be equal to the number of
	 * times increaseCount has been called, because sometimes you will add the same string to the
	 * data structure more than once. This function is useful when looping through the results
	 * using getNthPopular. If you do getNthPopular(numEntries()-1), it should get the least popular item. 
	 * @return  Number of distinct entries.
	 */
	public int numEntries();
};

    
   
