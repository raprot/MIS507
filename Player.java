import java.util.*;
// Add abstract before class: no constructor is needed (no-instantiate)
public abstract class Player{

	// Change all visiblity of instance variable:  private to protected 
	protected String name;
	protected double chip;
	protected double bet; //for each stage, the bet should be reset to 0.
	protected PlayerHand playerHand;
	protected Table table; // Change currTable to Table, made by Johnny
	protected PokerHand pokerHand; // Add by Johnny



	// No constructor is needed (no-instantiate) : made by Johnny
	public Player(){
		name = "";
		chip = 0;
		bet = 0;
		playerHand = new PlayerHand();
		table = null;
	}

	// // Add constructor with parameters, made by Johnny
	public Player(String name, double chip){
		this.name = name;
		this.chip = chip; 
		bet = 0;
		playerHand = new PlayerHand();
		table = null;
	}	

	
	// In order to verify clearly, all instance variable should add this. in the front of intance varaible name

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public double getChip(){
		return this.chip;
	}

	public void setChip(double chip){
		this.chip = chip;
	}

	// Add by Johnny 
	public double getBet(){
		return this.bet;
	}


	
	// Change all return type: bet, check, call, raise, allin from void to double

	public double bet(double amount)
	{	
		// amount should be less than chip, amount <= this.chip
		this.bet = 0; // Add by Johnny
		this.chip -= amount; // Add by Johnny
		this.bet += amount;

		return amount;
	}

	public double check()
	{
		// no betting action
		this.bet = 0; // Add by Johnny
		return 0 ;

	}

	//  Made by Johnny
	public double call()
	
	{
		/*
		// the correct implementation way should be the player should the previous player's betting amount.
		
		int playerPosition = getTable().getCurrentPlayers().indexOf(this);
		int currentNumPlayer = getTable().getCurrentNumPlayers();

		// for player at position 0
		if (playerPostion == 0){
			int previsouPlayerPosition = currentNumPlayer -1;
			
		}
		else{
			int previsouPlayerPosition = playerPostion -1 ;
		}

		double amount = getTable().getCurrentPlayers().get(previousPlayerPosition).getBet();
		bet(amount); 
		//
		*/
		return 0.0;
	}

	// Made by Johnny;
	public double fold(){
		// remove the this Player from active player list
		// System.out.println(getTable());
		// System.out.println("TEST...." + getTable().getDealer());
		System.out.println("TEST...." + getTable().getDealer().getActivePlayers());

		getTable().getDealer().getActivePlayers().remove(this);
		this.bet = 0.0;
		return 0.0;
	}
	// Made by Johnny
	public void raise(double amount){
		// raising amount should be greater than th amount the previous player bets. 
		// option 1:// Add by Johnny
		bet(amount);
		// option 2:
		// bet(amount- call()) + call()

	}

	// Revise by Johnny
	public void allin(){	
		bet(this.chip);
	}

	// Made by Johnny
	public void winPot(double amount){
		this.chip += amount;
	}


	public PlayerHand getPlayerHand(){
		return this.playerHand;
	}

	// made by Johnny
	// public Card[] getBesthand(){
	// 	PokerHand pokerHand = new PokerHand();
	// 	return pokerHand.getBestHand(getPlayerHand(), getTable().getCommunityCards());
	// }
	
	public PokerHand getPokerHand(){
		return this.pokerHand;
	}
	public Table getTable(){
		return this.table;
	}

	public boolean joinTable(Table reqTable){
		if (reqTable.requestJoin(this)){
			table = reqTable;
			System.out.print("TEST: "  + table);
			this.pokerHand = new PokerHand( getPlayerHand(), this.table.getCommunityCards()); 
			return true; 
		}
		else
			return false;
	}

	public boolean leaveTable(){
		if (table.requestLeave(this)){
			table = null;
			return true;
		}
		else
			return false;
	}
	public boolean quit(){
		if (table == null){
			return false;
		}
		else{
			return table.requestLeave(this);
		}
	}

	public String toString(){
		String out = "Player: " + getName();
		out += "\nChip Amount: " + getChip();
		if( table != null )
			out += "\nTable: " + table.getTableNum();
		else
			out += "\nTable: No Table";

		ArrayList<Card> cards = playerHand.getCards();

		if( cards.size() > 0 ){
			out += "\nCards: ";

			Iterator<Card> cardList = cards.iterator();
			while (cardList.hasNext()){
			  Card next = cardList.next();
			  out += next.getSuit() + next.getRank();

			  if (cardList.hasNext())
			  	out += ", ";
			}
		}
		else
			out += "\nPlayers: No Players";

		return out;
	}
}
