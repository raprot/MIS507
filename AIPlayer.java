abstract public class AIPlayer extends Player
{
	protected PlayerStyle style;
	private String name;

	public AIPlayer(PlayerStyle ps)
	{
		super();
		style = ps;
		name = "Jane Doe";
	}

	abstract public void setBettingDegree(double degree);

	abstract public double getBettingDegree();

	public String toString()
	{
		return name + ": " + style;
	}

	public boolean repOK()
	{
		if( name == null || style == null )
			return false;
		else
			return true;
	}
}