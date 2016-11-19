import java.util.*;


public class Dealer{

	protected Deck deck;
	protected Table table;
	protected String name;
	protected PokerGame gameType;


	// In Dealer Class, activePlayers is a list of players for this round of game.
	// for each stage (preflop, flop, turn, river, the activePlayers means those player with player hand, which means unfold their hand)
	// In each stage, the number of activePlayer may change because some player may fold their hands.
	// In Table Class, the currentPlayers means those player who's in the game in the begining of this round(preflop)
	// In Table Class, the players are those player who put chips on table, but not in the game for this round. (not exit the table)

	protected ArrayList<Player> activePlayers;



	public Dealer(String name){
		this.name = name;
		this.deck = null;
		this.table = null;
		this.gameType = null;
	}


	public void setPokerGame(PokerGame gameType){
		this.gameType = gameType;
	}

	public PokerGame getPokerGame(){
		return this.gameType;
	}

	// ============================ Start: Unfinished ============================
	public void startHands(){
		// 1. Suffle the deck
		// 2. Get ante from each player based on game type. Only get Ante from each player if ante > 0.
		// 3. Get small blind and big blind from two players at SB position and BB position
		// 4. Burn Card (remove the first card on deck)
		// 5. Give each player their card based on game type,
		//  e.g. each player get two cards for Texas hold'em, e.g. for Omaha, each player will get four cards.

		// step 1: Set deck and shuffle deck
		setDeck();
		shuffleDeck();
		// step 2: Get antes
		if( getAnte() > 0){
			getAnteFromPlayer();
		}
		// step 3: Get Blinds
		getBlindsFromPlayer();
		// step 4: Burn card
		getCard();
		// step 5: Give
		// Give the first card, then second card, .....

		int currentNumPlayer = getTable().getCurrentNumPlayer();
		int buttonPosition = getTable().getButtonPosition();

		for (int i = 0; i < gameType.getNumPlayerHands(); i ++){
			// Give first player
			for (int j = 1; j <= getTable().getCurrentNumPlayer(); j++){
				Card card = getCard();
				getTable().getCurrentPlayers().get( (buttonPosition + j) % currentNumPlayer ).setPlayerHand(card);
			}
		}
	}

	public void dealCommunityCard(){
		// This is for Texas Hold'em and Omaha. For 7 Card Stud , 5 Card Draw. it won't be executed.
		if(getGame().getNumCommunityCard() > 0){
			// Burn card
			getCard();
			// Get a card from deck
			Card communityCard = getCard();
			// Add this card to community card
			getTable().setCommunityCard(commmunityCard);

		}

	}

	public void endHands(){
		// 1. Decide the winners
		// 2  Move the button to the next player's position
		decideWinners();
		moveButton();


	}

	public void moveButton(){
		int currentNumPlayer = getTable().getCurrentNumPlayer();
		int buttonPosition = getTable().getButtonPosition();
		getTable().setButtonPosition((buttonPosition + 1) % currentNumPlayer);
		getTable().clearPot();

	}

	//
	public ArrayList<Player> decideWinners(){
		// a array to storage all winner;
		ArrayList<Player> winners = new ArrayList<Player>();

		// Get all current player, which doesn't fold/muck his/her hands.
		ArrayList<Player> currentPlayers = getTable().getCurrentPlayers();
		Card[] winningHand = currentPlayers.get(0).getBestHand();
		winners.add(currentPlayers.get(0))

;		for (int i = 0; i < currentPlayers.size(); i++){
			 Card[] bestHand = currentPlayers.get(i).getBestHand();
			// winningHand.compareTo(bestHand)
			// winning hand is better than player's best hand, return 1
			// winning hand is equal to player's best hand, return 0
			// winning hand is worse than player's best hand, return -1
			if (winningHand.compareTo(bestHand) <= 0 ){
			 	winningHand = bestHand;
			 	// winners.remove(currentPlayers.get(i));
			 	winners.add(currentPlayers.get(i));
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
		return getGame().getAnte();
	}

	public double getBigBlind(){
		return getGame().getBigBlind();
	}

	public double getSmallBlind(){
		return getGame().getSmallBlind();
	}


	public void getAnteFromPlayer(){
		// Get the ante from each player and add thess ante into pot.

		for(int i = 0; i < getCurrentPlayers().size(); i++ ){
			double ante = getCurrentPlayers.get(i).bet(getAnte());
		}	getTable().addPot(ante);
	}


	public void getBlindsFromPlayer(){
		// In the begining of each round, dealer will get the small blind and big blind from two players at SB position and BB position.
		// Players is a array list = [player1, player2, ......, player 9], assume max number player is 9.
		// Get small blind(SB) from one player at small blind postion: index of SB player shoulde be buttonPosition + 1
		// Get big blin(BB) from one player at big blind position: index of BB player should be buttonPosition + 2


		// Get

		int currentNumPlayer = getTable().getCurrentPlayers().size(); // <Option1>
		// int currentNumPlayer = getTable().getCurrentNumPlayer(); <Option2>


		// button positon should be the index of array list of players, ArrayList<Player>

		int buttonPosition = getTable().getButtonPosition();

		// Get button position, small blind position, and big blind position

		int smallBlindPostion = (buttonPosition + 1) % currentNumPlayer ;
		int bigBlindPosition = (buttonPostion + 2) % currentNumPlayer;

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

	public ArrayList<Player> getActivePlayer(){
		return activePlayers;

	}


}
