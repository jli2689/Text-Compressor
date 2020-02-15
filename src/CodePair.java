/**
 * CodePair.java: 
 * This class represents an entry associating a character 
 * with a code
 * @author chrisjiaweili
 */

public class CodePair {
	
	/**Attribute:
	 * stores character and code
	 */
	private char character;
	private String codeOC;

	/**Create a new instance of CodePair
	 * @param c
	 * @param code
	 */
	public CodePair(char c, String code) {
		codeOC = code;
		character = c;
	}
	
	/**
	 * public methods that return the content of a code
	 * @return String of code
	 */
	public String getCode() {
		return codeOC;
	}
	
	/**
	 * public methods that return the content of a character
	 * @return character of character 
	 */
	public char getCharacter() {
		return character; 
	}
	
	/**
	 * public setter methods for character
	 * @param c
	 */
	public void setCharacter(char c) {
		character = c;
	}
	
	/**
	 * public setter methods for code
	 * @param code 
	 */
	public void setCode(String code) {
		codeOC = code;
	}
	
	/**
	 * public method that checks whether the content of one code pair is the same as another 
	 * @param anotherPair
	 * @return boolean true or false 
	 */
	public boolean equals(CodePair anotherPair) {
		if (character == anotherPair.character & codeOC.equals(anotherPair.codeOC))
			return true; 
		else return false;
	}
	
}