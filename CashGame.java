public class CashGame extends GameType{


	public CashGame(){
		//Default constructor for CashGane objects.
		this.ante = 0;
	}
	public CashGame(double ante){
		this.ante = ante;
	}

	// Delete by Johnny 
	//Constructor for cash game objects that sets the ante ant game types.

	public void setAnte(double ante){
		//Setter for CashGame objects that sets the ante variable.
		// do nothing because it is cash game
	}


	public String toString(){
		//AF implementation for CashGame objects.
		return ("The current game type is cash game and the ante is $" +  this.ante + ".");
	}

	public boolean repOK(){
		//RI implementation of a CashGame object. Ante should be equal to 0.
 
		return this.ante == 0 ;
	}
	
}