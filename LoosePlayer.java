public class LoosePlayer extends AIPlayer
{
	private double betStrategy;

	public LoosePlayer()
	{
		super();
		betStrategy = 0;
	}

	public void setBetStrategy(double strategy)
	{
		betStrategy = strategy;
	}

	public double getBetStrategy()
	{
		return betStrategy;
	}

	public String toString()
	{
		return "Bet Strategy: " + betStrategy;
	}

	public boolean repOK()
	{
		if( betStrategy < 0 )
			return false;
		else
			return true;
	}
}