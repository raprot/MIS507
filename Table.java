import java.util.*;

public class Table
{
	private int tableNum;
	private int maxNumPlayer; // a capacity of a table, maxNumPlayer >= players.size()
	private ArrayList<Player> players; // [player1, player2, player 3, player 4]
	// private ArrayList<Player> currentPlayers ; // [player1, player2, player4] beacuse player 3 leave Table so player3.leaveTable() is True
	// private int currentNumPlayer;
	private Dealer dealer;
	private double pot;
	private int buttonPosition; 
	private CommunityCard communityCards;


	public Table(){
		this.tableNum = 0;
		this.maxNumPlayer = 0 ;
		this.players = new ArrayList<>(); // fix the error
		// this.currentPlayers = new ArrayList<>();
		// this.currentNumPlayer = 0;
		this.dealer = null;
		this.pot = 0.0;
		this.buttonPosition = 0; 
		this.communityCards = new CommunityCard();
		
		
	}

	public Table(int tableNum, int maxNumPlayer){
		this.tableNum = tableNum;
		this.maxNumPlayer = maxNumPlayer;
		this.players = new ArrayList<Player>();
		// this.currentPlayers = new ArrayList<Player>();
		// this.currentNumPlayer = 0;
		this.dealer = null;
		this.pot = 0.0;
		this.buttonPosition = 0;
		this.communityCards = new CommunityCard();
		
	}



	public int getTableNum(){
		return this.tableNum;
	}

	public Player getPlayer(int position){
		return (Player)players.get(position);
	}

	public ArrayList<Player> getPlayers(){
		return this.players;
	}

	// public void setPlayer(Player player){
	// 	this.players.add(player);
	// }

	public void setMaxNumPlayer(int maxNumPlayer){
		this.maxNumPlayer = maxNumPlayer;
	}

	public int getMaxNumPlayer(){
		return this.maxNumPlayer;
	}

	// public void setCurrentPlayers(){

	// 	for (Player player : getPlayers()){
	// 		if (! player.leaveTable()){
	// 			getCurrentPlayers().add(player);
	// 		}
	// 	}


	// }


	public ArrayList<Player> getCurrentPlayers(){
		return this.players;
	}

	public int getCurrentNumPlayer(){
		return players.size();
	}
	

	public boolean requestJoin(Player in){
		if( maxNumPlayer > players.size() )
		{
			players.add(in);
			return true;
		}
		else
			return false;
	}

	public boolean requestLeave(Player out){
		return players.remove(out);
	}

	public Dealer getDealer(){
		return this.dealer;
	}

	public void setDealer(Dealer dealer){
		this.dealer = dealer;
	}

	public boolean isTableFull(){
		return maxNumPlayer == players.size();
	}

	public int getButtonPosition(){
		return buttonPosition;
	}

	public void setButtonPosition(int buttonPosition){
		this.buttonPosition = buttonPosition;
	}

	public void moveButton(){
		if (buttonPosition + 1 == players.size()){
			buttonPosition = 0;
		}
		else{
			buttonPosition += 1;
		}
	}

	
	

	public double getPot(){
		return this.pot;
	}

	public void addPot(double amount){
		this.pot += amount;
	}

	public void clearPot(){
		this.pot = 0.0;
	}

	
	// Add by Johnny
	public void setCommunictyCard(Card communityCard){
		this.communityCards.setCard(communityCard);
	}

	// Add by Johnny
	public CommunityCard getCommunityCards(){
		return this.communityCards;
	}


	public String toString(){
		String out = "Table: " + getTableNum();
		if( dealer != null )
			out += "\nDealer: " + (getDealer()).getName();
		else
			out += "\nDealer: No Dealer";
		out += "\nNum of Players: " + players.size() + "/" + maxNumPlayer;
		out += "\nPot Size: " + pot;
		out += "\nButton Pos: " + getButtonPosition();

		if( players.size() > 0 ){
			out += "\nPlayers: ";

			Iterator<Player> playerList = players.iterator();
			while (playerList.hasNext()){
			  out += (playerList.next()).getName();

			  if( playerList.hasNext() )
			  	out += ", ";
			}
		}
		else
			out += "\nPlayers: No Players";
		return out;
	}
}