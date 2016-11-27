import java.util.*;

public class HoldemDealer extends Dealer{
	
	public HoldemDealer(){
		super();
	}

	public HoldemDealer(String name){
		super(name);
	}


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
		
		// step 5: Give cards to each player
		// Give the first card, then second card, .....

		int currentNumPlayer = getTable().getCurrentNumPlayer(); 
		int buttonPosition = getTable().getButtonPosition(); 
		
		for (int i = 0; i < getPokerGame().getNumPlayerCards(); i ++){ 
			// Give first player 
			for (int j = 1; j <= getTable().getCurrentNumPlayer(); j++){
				Card card = getCard();
				getTable().getCurrentPlayers().get( (buttonPosition + j) % currentNumPlayer ).getPlayerHand().setCard(card);
			}		
		}
	}


}
