import java.until.*;


public class Dealer(){

	protected Deck deck;
	protected Table table;
	protected String name;
	protected PokerGmae game;


	public Dealer(String name){
		this.name = name;
		this.deck = new Deck();
		this.table = null;
		this.game = null;
	}

	public PokerGame getPokerGame(){
		return this.game;
	}
	public void setPokerGame(PokerGame game){
		this.game = game;
	}
	// ============================ Start: Unfinished ============================
	// public void startHand(){

	// }

	// public void endHand(){

	// }


	public ArrayList<Player> decideWinners(){
		// a array to storage all winner; 
		ArrayList<Player> winners = new ArrayList<Player>();
		
		// Get all current player, which doesn't fold/muck his/her hands.
		ArrayList<Player> currentPlayers = getTable().getCurrentPlayers();
		Card[5] winningHand = currentPlayers.get(0).getBestHand();
		winners.add(currentPlayers.get(0))

;		for (int i = 0; i < currentPlayers.size(); i++){
			 card[5] bestHand = currentPlayers.get(i).getBestHand();
			// winningHand.compareTo(bestHand) 
			// winning hand is better than player's best hand, return 1
			// winning hand is equal to player's best hand, return 0
			// winning hand is worse than player's best hand, return -1
			if (winningHand.compareTo(bestHand) <= 0 ){
			 	winningHand = bestHand;
			 	// winners.remove(currentPlayers.get(i));
			 	winners.add(currentPlayers.get(i))
			 }
		}
	}

	// public void update(){

	// }

	// ============================ End: Unfinished ============================

	public Card getCard(){
		return getDeck().getCard();
	}

	public void shuffleDeck(){
		getDeck().shuffleDeck();
	}

	public Deck getDeck(){
		return this.deck;
	}

	public void setDeck(){
		this.deck = new Deck();
	}

	public Table getTable(){
		return this.table;
	}

	public void setTable(Table table){
		this.table = table;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public double getAnte(){
		return game.getAnte();
	}

	public double getBigBlind(){
		return game.getBigBlind();
	}

	public double getSmallBlind(){
		return game.getSmallBlind();
	}


	public void getAnteFromPlayer(){
		// Get the ante from each player.

		for(int i = 0; i < getTable().getCurrentNumPlayer(); i++ ){
			double ante = getTable().getCurrentPlayers.get(i).bet(getAnte());		 
		}	getTable().addPot(ante);
	}


	public void getBlindsFromPlayer(){
		// currentPlayers is a array list = [player1, player2, ......, player 9], assume max number player is 9.
		// Get small blind from player at small blind postion - it shoulde be buttonPosition + 1
		int maxNumPlayer = getTable().getMaxNumPlayer();
		
		// Get button position, small blind position, and big blind position
		int buttonPosition = getTable().getButtonPosition();
		int smallBlindPostion = (buttonPosition + 1) % maxNumPlayer ;
		int bigBlindPosition = (buttonPostion + 2) % maxNumPlayer;
		
		// Find the player at small blind position and player will bet amount equal to small blind
		Player smallBlindPlayer = getTable().getCurrentPlayers().get(smallBlindPostion);
		double smallBlind = smallBlindPlayer.bet(getSmallBlind());

		// Find the player at big blind position and player will bet amount equal to Big blind
		Player bigBlindPlayer = getTable().getCurrentPlayers.get(bigBlindPosition);
		double bigBlind = bigBlindPlayer.bet(getBigBlind());

		// Add the small blind and big blind into pot
		getTable().addPot(smallBlind);
		getTable().addPot(bigBlind);
			
	}
	// ============================ Undetermined ============================
	// public void setPlayerHandMuck(boolean muck){

	// }


}	
