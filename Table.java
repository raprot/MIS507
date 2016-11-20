import java.util.*;

public class Table
{
	private int tableNum;
	private ArrayList<Player> players;
	private int buttonPosition;
	private Dealer dealer;
	private double pot;
	private int maxNumPlayer;
	private CommunityCard communityCards;

	public Table()
	{
		tableNum = 0;
		players = new ArrayList();
		communityCards = new CommunityCard();
		buttonPosition = 0;
		dealer = null;
		pot = 0.0;
		maxNumPlayer = 4;
	}

	public String toString()
	{
		String out = "Table: " + getTableNum();
		if( dealer != null )
			out += "\nDealer: " + (getDealer()).getName();
		else
			out += "\nDealer: No Dealer";
		out += "\nNum of Players: " + players.size() + "/" + maxNumPlayer;
		out += "\nPot Size: " + pot;
		out += "\nButton Pos: " + getButtonPosition();

		if( players.size() > 0 )
		{
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

	public int getTableNum()
	{
		return tableNum;
	}

	public Player getPlayer(int pos)
	{
		return (Player)players.get(pos);
	}

	public ArrayList<Player> getCurrentPlayers()
	{
		return players;
	}

	public int getCurrentNumPlayer()
	{
		return players.size();
	}

	public boolean requestJoin(Player in)
	{
		if( maxNumPlayer > players.size() )
		{
			players.add(in);
			return true;
		}
		else
			return false;
	}

	public boolean requestLeave(Player out)
	{
		return players.remove(out);
	}

	public Dealer getDealer()
	{
		return dealer;
	}

	public void setDealer(Dealer in)
	{
		dealer = in;
	}

	public boolean isTableFull()
	{
		return maxNumPlayer == players.size();
	}

	public int getButtonPosition()
	{
		return buttonPosition;
	}

	public void setButtonPosition(int pos)
	{
		buttonPosition = pos;
	}

	public void moveButton()
	{
		if( buttonPosition+1 == players.size() )
			buttonPosition = 0;
		else
			buttonPosition+= 1;
	}

	public void clearPot()
	{
		pot = 0.0;
	}

	public void addPot(double amount)
	{
		pot += amount;
	}
}