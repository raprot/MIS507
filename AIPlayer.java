public class AIPlayer extends Player
{
	// protected PlayerStyle startHandSelection;
	// protected PlayerStyle bettingPattern;
	protected PlayerStyle playerStyle;

	public AIPlayer(){
		super();
		// this.name = "";
		// this.chip = 0;
		// this.bet = 0;
		// this.playerHand = new PlayerHand();
		// this.table = null;		
		// this.startHandSelection = null;
		// this.bettingPattern = null;
		this.playerStyle = null;
	}

	// Add a constructor with parameters by Johnny
	public AIPlayer(String name, double chip){
		super(name, chip);
		// this.name = name;
		// this.chip = chip;
		// this.bet = 0;
		// this.playerHand = new PlayerHand();
		// this.table = null;
		// this.startHandSelection = null;
		// this.bettingPattern = null
	}
	public void selectPlayerStyle(String style){
		if(style.equalsIgnoreCase("aggro")  ){
			this.playerStyle = new AggroStyle();
		}
		else if(style.equalsIgnoreCase("neutral")  ){
			this.playerStyle = new NeutralStyle();
		}
		else if(style.equalsIgnoreCase("passive")) {
			this.playerStyle = new PassiveStyle();
		}
		else {
			this.playerStyle = null;
		}
		
	}


	// public void setStartHandSelection(PlayerStyle startHandSelection){
	// 	this.startHandSelection = startHandSelection;
	// }

	// public PlayerStyle getStartHandSelection(){
	// 	return this.startHandSelection;
	// }

	// public void setBettingPattern(PlayerStyle bettingPattern){
	// 	this.bettingPattern = bettingPattern;
	// }

	// public PlayerStyle getBettingDegree(){
	// 	return this.bettingPattern;

	

}