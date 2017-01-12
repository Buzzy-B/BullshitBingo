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
		return "abkaspern,Überblick verschaffen,partiell dazuholen,abtesten,Gesamtbild,Regeltermin,einen Blick (für etwas) haben,hin reporten,in den nächsten Sprint schieben,Taktzahl,externe Lösung,(eine Lösung) hinstellen,retten,freigeben/ freigegeben,Rückmeldung nach vorne,weiterdelegieren,spezifiziert,angereichert,ich bin (auch) Admin gewesen,22 Jahre Berufserfahrung,potentiell,Restarbeiten,akzeotabel sein,Ausprägung(en),evaluieren,Prosa,aktiv nachfragen,Zusammenspiel,Integration,abrunden,zurückgespielt werden/ zurückspielen,durchforsten,ins Boot holen,(r)andocken/ (r)anzudocken,anpacken,Sonderlocke,festtackern,auf dem/ den Zettel,festnageln,Fahrplan,durchgreifen,reinhaken,ongoing,synchron bleiben,Zusammenspiel,Mapping,Speerspitze,(eine) Linie fahren,unterwegs sein,iterativ,Key Facts,Big Picture,Mission Critical,Next Steps,Priority/ Priorität,Schnittstelle,Pipeline,Platform-as-a-Service/ PAAS,Cloud-ready,abstimmen,Freigabe,Lenkungsausschuss,Driving Force,IT Landschaft,Neuausrichtung,Meilenstein/ Milestone,Showstopper,zeitnah,Umstrukturierung,proaktiv,Stakeholder,Risiken/ Projektrisiken,ASAP,ergebnisorientiert,Mehrwert schaffen,(Software/Updates) einspielen,Stakeholder,Teilprojektleiter,annahmenbasiert,pragmatisch,Tiefenbohrung,Wording,Optimierungsbedarf,Akzeptanzkriterien,Forschungsauftrag,Durchstich,streamlinen,aufgleisen,Klärungsbedarf,Druck machen,Cloud Competence Center/ CCC,Quick Win,greenlighten,Wissenstransfer,Bullet Points,BiPRO Norm,Prototyp,On Hold,Enabler,onboarden,Wackelpudding,proaktiv,Eckpfeiler,Leitplanken,in die Spur bringen,aufhübschen/ aufgehübscht,Senior,Junior,Reminder";
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
