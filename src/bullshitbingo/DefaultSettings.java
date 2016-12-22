package bullshitbingo;

//DEFAULT SETTINGS RESOURCE FILE
public class DefaultSettings {
	
	//default buzzword list
	public String getBuzzwords() {
		return "Sonderlocke,Tiefenbohrung,Wording,Optimierungsbedarf,Akzeptanzkriterien,Forschungsauftrag,Durchstich,streamlinen,aufgleisen,Klärungsbedarf,Druck machen,Cloud Competence Center/ CCC,Quick Win,greenlighten,Wissenstransfer,Bullet Points,BiPRO Norm,Prototyp,On Hold,Enabler,onboarden,Wackelpudding,proaktiv,Eckpfeiler,Leitplanken,in die Spur bringen,aufgehübscht,Senior,Junior";
	}
	
	//default separator character for buzzword list
	public char getSeparator() {
		return ',';
	}
	
	//default number of rows
	public int getNumberOfRows(){
		return 5;
	}
}
