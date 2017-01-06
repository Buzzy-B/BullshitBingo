package bullshitbingo;

//DEFAULT SETTINGS RESOURCE FILE
public class DefaultSettings {
	
	//default game configuration
	public GameConfiguration getGameConfiguration() {
		GameConfiguration gameConfiguration = new GameConfiguration();
		gameConfiguration.buzzwords = getBuzzwords();
		gameConfiguration.separator = getSeparator();
		gameConfiguration.numberOfRows = getNumberOfRows();
		return gameConfiguration;
	}
	
	//default buzzword list
	private String getBuzzwords() {
		return "Sonderlocke,ongoing,synchron bleiben,Zusammenspiel,Mapping,Speerspitze,(eine) Linie fahren,unterwegs sein,iterativ,Key Facts,Big Picture,Mission Critical,Next Steps,Priority/ Priorität,Schnittstelle,Pipeline,Platform-as-a-Service/ PAAS,Cloud-ready,abstimmen,Freigabe,Lenkungsausschuss,Driving Force,IT Landschaft,Neuausrichtung,Meilenstein/ Milestone,Showstopper,zeitnah,Umstrukturierung,proaktiv,Stakeholder,Risiken/ Projektrisiken,ASAP,ergebnisorientiert,Mehrwert schaffen,(Software/Updates) einspielen,Stakeholder,Teilprojektleiter,annahmenbasiert,pragmatisch,Tiefenbohrung,Wording,Optimierungsbedarf,Akzeptanzkriterien,Forschungsauftrag,Durchstich,streamlinen,aufgleisen,Klärungsbedarf,Druck machen,Cloud Competence Center/ CCC,Quick Win,greenlighten,Wissenstransfer,Bullet Points,BiPRO Norm,Prototyp,On Hold,Enabler,onboarden,Wackelpudding,proaktiv,Eckpfeiler,Leitplanken,in die Spur bringen,aufgehübscht,Senior,Junior,Reminder";
	}
	
	//default separator character for buzzword list
	private char getSeparator() {
		return ',';
	}
	
	//default number of rows
	private int getNumberOfRows(){
		return 5;
	}
}
