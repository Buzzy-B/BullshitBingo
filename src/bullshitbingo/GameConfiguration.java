package bullshitbingo;

public class GameConfiguration {
	public int numberOfRows;
	public String buzzwords;
	public char separator;
	
	//validate configuration
	public void validate() throws Exception {
		//THROW INVALID ARGUMENT EXCEPTIONS
		//throw exception if number of rows is lower than 1
		if (numberOfRows <1) {
			throw new Exception("Number of rows must be 1 or higher");
		}
		//throw exception if buzzwords string is empty
		if (buzzwords.isEmpty()) {
			throw new Exception("Buzzword list must not be empty");
		}
	}
}
