import java.util.ArrayList;
import java.util.List;

import bullshitbingo.BullshitBingoCalculator;
import bullshitbingo.DefaultSettings;

//BULLSHIT BINGO MAIN CLASS
public class BullshitBingo {

	public static void main(String[] args) throws Exception {
		
		//PARAMETERS
		String buzzwords;
		char separator;
		int numberOfRows;
		
		//GET DEFAULT SETTINGS
		DefaultSettings defaultSettings = new DefaultSettings();
		buzzwords = defaultSettings.getBuzzwords();
		separator = defaultSettings.getSeparator();
		numberOfRows = defaultSettings.getNumberOfRows();
		
		BullshitBingoCalculator bullshitBingoCalculator = new BullshitBingoCalculator();
		
		//COMMAND LINE
		if (args.length > 0) {
			for (int i=0; i<args.length; i++) {
				if (args[i].equals("--help")) {
					
					//help
					System.out.println("-------------------");
					System.out.println("BULLSHIT BINGO HELP");
					System.out.println();
					System.out.println("Accepted argumens:");
					System.out.println("   --numberOfRows (int): Changes the size of the game (default: 5)");
					System.out.println("   --buzzwords (String): Determines the content (default content if empty)");
					System.out.println("   --separator (char): Sets the separator character of the buzzwords string (default: \',\')");
					System.out.println("-------------------");
					return;
					
				} else if (args[i].equals("--numberOfRows")) {
					
					//number of rows (always equals number of columbs)
					if (args.length < i+2){
						throw new Exception ("Optional argument --numberOfRows must be specified when used");
					} else {
						if (!bullshitBingoCalculator.isNumeric(args[i+1])) {
							throw new Exception ("numberOfRows must define a number");
						}
						numberOfRows = Integer.valueOf(args[i+1]);
					}
					
				} else if (args[i].equals("--buzzwords")) {
					
					//buzzwords
					if (args.length < i+2){
						throw new Exception ("Optional argument --buzzwords must be specified when used");
					} else {
						if (args[i+1].substring(0,2).equals("--")) {
							throw new Exception("Optional argument --buzzwords must be specified when used");
						}
						buzzwords = args[i+1];
					}
					
				} else if (args[i].equals("--separator")) {
					
					//separsator
					if (args.length < i+2){
						throw new Exception ("Optional argument --separator must be specified when used");
					} else {
						if (args[i+1].substring(0,2).equals("--")) {
							throw new Exception("Optional argument --separator must be specified when used");
						}
						//there must be a hyphen before the char
						if (args[i+1].charAt(0) == '\'') {
							separator = args[i+1].charAt(1);
						} else {
							throw new Exception("Optional argument --separator must be specified when used and the separator must be surrounded by hyphens");
						}
					}
					
				}
			}
		}
		
		//THROW INVALID ARGUMENT EXCEPTIONS
		//throw exception if number of rows is lower than 1
		if (numberOfRows <1) {
			throw new Exception("Number of rows must be 1 or higher");
		}
		//throw exception if buzzwords string is empty
		if (buzzwords.isEmpty()) {
			throw new Exception("Buzzword list must not be empty");
		}
		
		
		//FIND SUBSTRING POSITIONS FOR BUZZWORDS
		//create list of integers for the substring position data
		List<Integer> separatorPositions = new ArrayList<Integer>();
		//add first index from buzzword string to separatorPositions list
		//in case the buzzword string does not begin with a separator
		if (buzzwords.charAt(0) != separator) {
			separatorPositions.add(0);
		}
		
		//find separator positions in buzzword string and store them to a list
		for (int i=0; i<buzzwords.length(); i++) {
			if (buzzwords.charAt(i) == separator) {
				separatorPositions.add(i);
			}
		}
		//add last index from buzzwords string to separatorPositions list
		//in case the buzzword string is not terminated by a separator
		if ((separatorPositions.size() > 0) && (buzzwords.length() > separatorPositions.get(separatorPositions.size()-1))) {
			separatorPositions.add(buzzwords.length());
		}
		
		//CREATE FIELDS		
		//throw exception if number of buzzwords is lower than number of fields
		int numberOfFields = numberOfRows * numberOfRows;
		if (separatorPositions.size() -1 < numberOfFields) {
			throw new Exception("Number of buzzwords ("+(separatorPositions.size()-1)+") is lower than number of fields ("+numberOfFields+").");
		}
		
		//find longest buzzword length in order to determine columb width
		int columbWidth = 0;
		for (int i=1; i< separatorPositions.size()-1; i++) {
			int lengthAtCurrentIndex = separatorPositions.get(i) - separatorPositions.get(i-1);
			if (lengthAtCurrentIndex > columbWidth) {
				columbWidth = lengthAtCurrentIndex;
			}
		}
		
		//add two spaces to columb width in order to separate the columbs
		columbWidth +=2;
		
		//randomize content and fill fields
		List<Integer> unusedContentIndices = new ArrayList<Integer>();
		
		//init list of unused content indices
		for (int i=0; i<separatorPositions.size()-1; i++) {
			unusedContentIndices.add(i);
		}
			

		//FILL FIELDS
		for (int i=0; i<numberOfFields; i++) {
			//fill field and remove index from list of unused content indices
			int currentIndex = (int) ((unusedContentIndices.size()-1) * Math.random());
			int substringBeginIndex = separatorPositions.get(unusedContentIndices.get(currentIndex));
			if (substringBeginIndex > 0) {
				substringBeginIndex ++;
			}
			System.out.print(buzzwords.substring(substringBeginIndex,separatorPositions.get(unusedContentIndices.get(currentIndex)+1)));
			int numberOfFillerSpaces = columbWidth - buzzwords.substring(substringBeginIndex,separatorPositions.get(unusedContentIndices.get(currentIndex)+1)).length();
			for (int j=0; j< numberOfFillerSpaces; j++) {
				System.out.print(" ");
			}
			
			//new columb
			if (((i+1) % numberOfRows) == 0) {
				System.out.println();
				System.out.println();
			}
			unusedContentIndices.remove(currentIndex);
		}
		
	}
}
