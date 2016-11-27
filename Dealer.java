import java.util.*;


public abstract class Dealer{

	protected Deck deck;
	protected Table table;
	protected String name;
	protected PokerGame pokerGame;
	protected ArrayList<Player> activePlayers;

	// In Dealer Class, activePlayers is a list of players for this round of game.
	// for each stage (preflop, flop, turn, river, the activePlayers means those player with player hand, which means unfold their hand)
	// In each stage, the number of activePlayer may change because some player may fold their hands.
	// In Table Class, the currentPlayers means those player who's in the game in the begining of this round(preflop)
	// In Table Class, the players are those player who put chips on table, but not in the game for this round. (not exit the table)

	

	public Dealer(){
		this.name = null;
		this.deck = null;
		this.table = null;
		this.pokerGame = null;
	}



	public Dealer(String name){
		this.name = name;
		this.deck = null;
		this.table = null;
		this.pokerGame = null;
	}


	public void setPokerGame(PokerGame pokerGame){
		this.pokerGame = pokerGame;
	}

	public PokerGame getPokerGame(){
		return this.pokerGame;
	}
	
	
	public abstract void startHands();
	// Each different type of Dealer has his/her own way to start hands based on the game type
	// 
	
	
	public void burnCard(){
		// Burn Card
		getCard();
	}


	public void dealCommunityCard(){
		// This is for Texas Hold'em and Omaha. For Poker Game are 7 Card Stud or 5 Card Draw. it won't be executed.
		if(getPokerGame().getNumCommunityCards() > 0){
			// Get a card from deck
			Card communityCard = getCard();
			// Add this card to community card
			getTable().getCommunityCards().setCard(communityCard);

		}

	}

	public void endHands(){
		// 1. Decide the winners
		// 2  Move the button to the next player's position
		// decideWinners();
		// moveButton();


	}

	private void moveButton(){
		int currentNumPlayer = getTable().getCurrentNumPlayer(); 
		int buttonPosition = getTable().getButtonPosition();
		getTable().setButtonPosition((buttonPosition + 1) % currentNumPlayer); 
		getTable().clearPot();

	}

	// Unfinished

	private ArrayList<Player> decideWinners(){
		
		// Get all current player, which doesn't fold/muck his/her hands.
		ArrayList<Player> currentPlayers = getTable().getCurrentPlayers();
		
		// a array to storage all winner; 
		ArrayList<Player> winners = new ArrayList<>();
		for (int i = 0; i < currentPlayers.size(); i++){
			winners.add(currentPlayers.get(i));
		}

		for (int i = 0; i < currentPlayers.size(); i++){
			for (int j = 0; j < currentPlayers.size(); j ++){
				// winning hand is better than player's best hand, return 1
				// winning hand is equal to player's best hand, return 0
				// winning hand is worse than player's best hand, return -1
				if (currentPlayers.get(i).getPokerHand().compareTo(currentPlayers.get(j).getPokerHand()) ==-1 ){
					winners.remove(currentPlayers.get(i));
				}
			}
		}
		// divide the pot equally to all winners.
		int currentNumWinner = winners.size();
		for (int i = 0; i < currentNumWinner; i++){
			double amount = getTable().getPot()/currentNumWinner;
			winners.get(i).winPot(amount);
		}
		
		getTable().clearPot();
		return winners;

	}	


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

	// set a new Deck
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
		return getPokerGame().getGameType().getAnte();
	}

	public double getSmallBlind(){
		return getPokerGame().getBettingStructure().getSmallBlind();
	}

	public double getBigBlind(){
		return getPokerGame().getBettingStructure().getBigBlind();
	}

	public void getAnteFromPlayer(){
		// Get the ante from each player and add thess ante into pot.
		double totalAnte = 0;
		for(int i = 0; i < getTable().getCurrentPlayers().size(); i++ ){
			totalAnte += getTable().getCurrentPlayers().get(i).bet(getAnte());		 
		}	
		getTable().addPot(totalAnte);
	}


	public void getBlindsFromPlayer(){
		// In the begining of each round, dealer will get the small blind and big blind from two players at SB position and BB position.
		// Players is a array list = [player1, player2, ......, player 9], assume max number player is 9.
		// Get small blind(SB) from one player at small blind postion: index of SB player shoulde be buttonPosition + 1
		// Get big blin(BB) from one player at big blind position: index of BB player should be buttonPosition + 2


		// Get 

		int currentNumPlayer = getTable().getCurrentNumPlayer(); // <Option1>
		// int currentNumPlayer = getTable().getCurrentNumPlayer(); <Option2>
		
		System.out.println(currentNumPlayer);

		// button positon should be the index of array list of players, ArrayList<Player>
		
		int buttonPosition = getTable().getButtonPosition(); 
		
		// Get button position, small blind position, and big blind position
		
		int smallBlindPostion = (buttonPosition + 1) % currentNumPlayer ;
		int bigBlindPosition = (buttonPosition + 2) % currentNumPlayer;
		
		// Find the player at small blind position and player will bet amount equal to small blind
		Player smallBlindPlayer = getTable().getCurrentPlayers().get(smallBlindPostion);
		double smallBlind = smallBlindPlayer.bet(getSmallBlind());

		// Find the player at big blind position and player will bet amount equal to Big blind
		Player bigBlindPlayer = getTable().getCurrentPlayers().get(bigBlindPosition);
		double bigBlind = bigBlindPlayer.bet(getBigBlind());

		// Add the small blind and big blind into pot
		getTable().addPot(smallBlind);
		getTable().addPot(bigBlind);
			
	}
	public void getAmountFromPlayer(double amount){
		getTable().addPot(amount);
	}

	public ArrayList<Player> getActivePlayers(){
		return activePlayers;

	}
	public void setActivePlayers(){
		for (int i = 0; i < getTable().getPlayers().size(); i++){
			System.out.println("TEST-----------------" + i);
			this.activePlayers.add(getTable().getPlayers().get(i));	
		}
		// this.activePlayers = (ArrayList<Player>)getTable().getPlayers().clone();
	} 

	public String toString(){
		String result = "";
		result += "Dealer info: " + getName() + "\n";
		result += "Poker Game info: " + getPokerGame() + "\n";
		result += "Table info: " + getTable() + "\n";	

		return result;


	}

}	
