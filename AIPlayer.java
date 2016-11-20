abstract public class AIPlayer extends Player
{
	protected PlayerStyle style;

	public AIPlayer(PlayerStyle ps)
	{
		super();
		style = ps;
	}

	abstract public void setBettingDegree(double degree);

	abstract public double getBettingDegree();
}