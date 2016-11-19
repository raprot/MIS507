public class LoosePlayer extends AIPlayer
{
	private double betDegree;

	public LoosePlayer(PlayerStyle ps)
	{
		super(ps);
		betDegree = 0;
	}

	public void setBettingDegree(double degree)
	{
		betDegree = degree;
	}

	public double getBettingDegree()
	{
		return betDegree;
	}

}