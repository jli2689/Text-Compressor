
/**
 * Decompress.java: 
 * main method that decompress a compressed file (.zzz) to a text file(.dec) 
 * @author chrisjiaweili
 *
 */

public class Decompress {

	/**
	 * main method that will process and store codes.txt, and decompress a compressed file (.zzz) 
	 * @param args
	 */
	public static void main(String[] args) {

		//processing codes.txt to create the list of code pairs 
		TextFile codesFile;
		ArrayCode list; 
		char character;
		String code;
		CodePair cp;
				
		codesFile = new TextFile(args[1], "read"); 
		list = new ArrayCode(100); 
		
		code = ""; 
		while (code != null) { 
			character = codesFile.readChar(); 
			code = codesFile.readLine();
			cp = new CodePair(character, code); 
			list.add(cp);
		}			
		codesFile.close(); 
		
		
		/**
		 * reading every  bit of compressed file, checking the set of bits against the list of codes
		 * find the corresponding character and write it to the output file
		 */
		TextFile outputFile; 
		CompressedFile cFile; 
		String codeToFind = ""; 
		char cha = 1; 
		final int NONE = -1; 
		int pos = NONE; 
		
		cFile = new CompressedFile(args[0], "read");
		String outputFileName = args[0].substring(0, args[0].length()-3)+"dec"; 
		outputFile = new TextFile(outputFileName, "write");
		
		while (cha != 0) {
			cha = cFile.readBit(); 
			codeToFind = codeToFind + String.valueOf(cha); 
			for (int i = 0; i < list.getNumPairs(); i++) {
				if (list.getCode(i) != null)
				if (list.getCode(i).equals(codeToFind))
					pos = i; 
			}
			if (pos != NONE) {
				outputFile.writeChar(list.getCharacter(pos));
				codeToFind = "";
				pos = NONE; 
			} 
		}
		//close files 
		cFile.close();
		outputFile.close();
				
			
	}

}
