import java.util.*;

public class Player
{
	private String name;
	private int chip;
	private int bet;
	private PlayerHand playerHand;
	private Table currTable;

	public Player()
	{
		name = "";
		chip = 0;
		bet = 0;
		playerHand = new PlayerHand();
		currTable = null;
	}

	public String toString()
	{
		String out = "Player: " + getName();
		out += "\nChip Amount: " + getChip();
		if( currTable != null )
			out += "\nTable: " + currTable.getTableNum();
		else
			out += "\nTable: No Table";

		ArrayList<Card> cards = playerHand.getCards();

		if( cards.size() > 0 )
		{
			out += "\nCards: ";

			Iterator<Card> cardList = cards.iterator();
			while (cardList.hasNext())
			{
			  Card next = cardList.next();

			  out += next.getSuit() + next.getRank();

			  if( cardList.hasNext() )
			  	out += ", ";
			}
		}
		else
			out += "\nPlayers: No Players";

		return out;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getChip()
	{
		return chip;
	}

	public void setChip(int chip)
	{
		this.chip = chip;
	}

	public void bet(int amount)
	{
		bet += amount;
	}

	public void check()
	{

	}

	public void call()
	{

	}

	public void fold()
	{

	}

	public boolean quit()
	{
		if( currTable == null )
			return false;
		else
			return currTable.requestLeave(this);
	}

	public void allin()
	{
		raise(chip);
	}

	public void raise(int amount)
	{
		bet += amount;
	}

	public PlayerHand getPlayerHand()
	{
		return playerHand;
	}

	public boolean joinTable(Table reqTable)
	{
		if( reqTable.requestJoin(this) )
		{
			currTable = reqTable;
			return true;
		}
		else
			return false;
	}

	public boolean leaveTable()
	{
		if( currTable.requestLeave(this) )
		{
			currTable = null;
			return true;
		}
		else
			return false;
	}
}
