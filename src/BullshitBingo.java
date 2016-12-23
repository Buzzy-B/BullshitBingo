import bullshitbingo.GameService;
import bullshitbingo.GameConfiguration;

//BULLSHIT BINGO MAIN CLASS
//command line tool

public class BullshitBingo {

	public static void main(String[] args) throws Exception {
		
		//CREATE COMMAND LINE SERVICE
		GameService gameService = new GameService();
		
		//GET GAME CONFIGURATION
		GameConfiguration gameConfiguration = gameService.parseCommandlineArguments(args);
		
		//VALIDATE CONFIGURATION AND CREATE FIELDS (if configuration not null)
		if (gameConfiguration != null) {
			gameConfiguration.validate();					//validate game configuration
			gameService.createFields(gameConfiguration);	//create fields
		}
	}
}
