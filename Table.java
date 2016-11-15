import java.util.*;

public class Table
{
	private String name;
	private ArrayList players;
	private int buttonPosition;
	private Dealer dealer;
	private int potSize;
	private int maxNumPlayer;
	private ArrayList pots;

	public Table()
	{
		name = "";
		players = new ArrayList();
		buttonPosition = 0;
		dealer = null;
		potSize = 0;
		maxNumPlayer = 4;
		pots = new ArrayList();
	}

	public String toString()
	{
		String out = "Table: " + getTableName();
		if( dealer != null )
			out += "\nDealer: " + (getDealer()).getName();
		else
			out += "\nDealer: No Dealer";
		out += "\nNum of Players: " + players.size() + "/" + maxNumPlayer;
		out += "\nPot Size: " + potSize;
		out += "\nNum of Pots: " + pots.size();
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

	public String getTableName()
	{
		return name;
	}

	public Player getPlayer(int pos)
	{
		return (Player)players.get(pos);
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


}