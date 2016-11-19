public class TightPlayer extends AIPlayer
{
	private double betDegree;

	public TightPlayer(PlayerStyle ps)
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