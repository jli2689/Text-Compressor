/**
 * ArrayCode.java: 
 * This class contains methods that processes a list of code pairs
 * @author chrisjiaweili
 */

public class ArrayCode {
	private CodePair[] cpList;
	private int numberOfcp; 

	public ArrayCode(int size) {
		cpList = new CodePair[size]; 
		numberOfcp = 0;
	}
	
	/**
	 * Public method add(), and private methods to adjust the size of array
	 * @param pair
	 */
	public void add(CodePair pair) {
		if (numberOfcp == cpList.length && cpList.length <= 100)
			doubleCapacity();
		if (numberOfcp == cpList.length && cpList.length > 100)
			increaseCapacity(); 
		cpList[numberOfcp] = pair;
		numberOfcp++; 
	}
	/**
	 * Private method that double the size of code pair array 
	 */
	private void doubleCapacity() {
		CodePair[] largerList = new CodePair[cpList.length * 2];
		for (int i = 0; i < cpList.length; i++)
			largerList[i] = cpList[i]; 
		cpList = largerList; 
	}
	/**
	 * Private method that increase 20 to the size of code pair array
	 */
	private void increaseCapacity() {
		CodePair[] increasedList = new CodePair[cpList.length + 20]; 
		for (int i = 0; i < cpList.length; i++)
			increasedList[i] = cpList[i]; 
		cpList = increasedList; 
	}

	/**
	 * public method remove(), and private method to adjust the size of array
	 * @param pairToRemove
	 */
	public void remove(CodePair pairToRemove) {
		int ret = -1; 
		
		if (numberOfcp == 0)
			System.out.println("The list is empty.");
		
		for (int i = 0; i < numberOfcp && ret == -1; i++)
			if (cpList[i].equals(pairToRemove))
				ret = i; 
		if (ret == -1)
			System.out.println("The pair is not in the list.");
		cpList[ret] = cpList[numberOfcp-1]; 
		cpList[numberOfcp-1] = null; 
		numberOfcp--; 
		if (ret != -1 && numberOfcp < cpList.length/4)
			halfCapacity();
	}
	/**
	 * Private method that decrease the size of code pair array by half
	 */
	private void halfCapacity() {
		CodePair[] smallerList = new CodePair[cpList.length / 2];
		for (int i = 0; i < smallerList.length; i++)
			smallerList[i] = cpList[i]; 
		cpList = smallerList;
	}
	
	/**
	 * public methods to find position of a code
	 * @param code
	 * @return position as an int, or -1 if not found 
	 */
	public int findCode(String code) {
		int ret = -1;
		for (int i = 0; i < numberOfcp && ret == -1; i++)
			if (cpList[i].getCode().equals(code))
				ret = i; 
			else 
				ret = -1;
		return ret;
	}
	
	/**
	 * public method that find the character
	 * @param c
	 * @return position as an int, or -1 if not found 
	 */
	public int findCharacter(char c) {
		int ret = -1;
		for (int i = 0; i < numberOfcp && ret == -1; i++)
			if (cpList[i].getCharacter() == c)
				ret = i; 
			else 
				ret = -1; 
		return ret; 
	}
	
	/**
	 * public methods to get the content of a code, given its position
	 * @param i
	 * @return string representing the code
	 */
	public String getCode(int i) {
		if (0 <= i && i < numberOfcp)
			return cpList[i].getCode(); 
		else
			return null; 
	}
	
	/**
	 * public methods to get the content of a character, given its position
	 * @param i
	 * @return char representing the character 
	 */
	public char getCharacter(int i) {
		if (0 <= i && i < numberOfcp)
			return cpList[i].getCharacter(); 
		else
			return 0; 
	}
	
	/**
	 * public method that return the size of array
	 * @return size as int 
	 */
	public int getSize() {
		return cpList.length; 
	}
	
	/**
	 * public method that return the number of code pairs stored in the array 
	 * @return size as int 
	 */
	public int getNumPairs() {
		return numberOfcp; 
	}
}
