
/**
 * Compress.java: 
 * main method that compress a text file (.txt) into a compression file (.zzz)
 * @author chrisjiaweili
 *
 */

public class Compress {
	 
	/**
	 * main methods that will process and store codes.txt, and compress a text file (.txt)
	 * @param args
	 */
	public static void main(String[] args) {
			
		/**
		 * processing codes.txt to create the list of code pairs 
		 */
		TextFile codesFile;
		ArrayCode list; 
		char character;
		String code;
		
		codesFile = new TextFile(args[1], "read"); 
		list = new ArrayCode(100); 
		
		code = ""; 
		while (code != null) {
			character = codesFile.readChar(); 
			code = codesFile.readLine();
			list.add(new CodePair(character, code));
		}	
		codesFile.close(); 

		
		/**
		 * processing input text file and compressed file
		 */
		TextFile inputText; 
		CompressedFile cFile; 
		String codeOfChar;
		char cha = 1; 
		final int NONE = -1; 
		int pos = NONE; 
		
		inputText = new TextFile(args[0], "read"); 
		String cFileName = args[0].substring(0, args[0].length()-3)+"zzz"; 
		cFile = new CompressedFile(cFileName, "write"); 
		
		while (cha != 0) {
			cha = inputText.readChar(); 
			for (int i = 0; i < list.getNumPairs(); i++)
				if (cha == list.getCharacter(i))
					pos = i; 
			
			if (pos == NONE) {
				inputText.close();
				cFile.close();
				System.out.println("The character is not found." );
				System.exit(0);
			}
			else {
				codeOfChar = list.getCode(pos);
				if (list.getCode(pos) != null)
				for (int j = 0; j < codeOfChar.length(); j++)
					cFile.writeBit(codeOfChar.charAt(j));
			}
		}	
		 //closes files 
		inputText.close();
		cFile.close();
		
	}


}
