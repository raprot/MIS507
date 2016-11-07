public class Player
{
	private String memberName;
	private String name;
	private int chip;
	private int bet;
	private PokerHand playerHand;
	private Table currTable;

	public Player()
	{
		memberName = "";
		name = "";
		chip = 0;
		bet = 0;
		playerHand = new PlayerHand;
		currTable = null;
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

	public PokerHand getPlayerHand()
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
}







}