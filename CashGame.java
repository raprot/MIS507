public class CashGame extends GameType{
  
  public CashGame(){
  }//Default constructor for CashGane objects.
  
  public CashGame(double ante, String type){
    this.ante = ante;
    this.type = type;}
  //Constructor for cash game objects that sets the ante ant game types.
  
  public void setAnte(double ante){
    this.ante = ante;}
  //Setter for CashGame objects that sets the ante variable.

  public double getAnte(){
    return this.ante;}
  //Getter for CashGame objects that returns the current table ante.
  
  public void setType(String type){
    this.type = type;}
  //Setter for CashGame objects that sets the game type.
  
  public String getType(){
    return this.type;}
  //Getter for CashGame objects that returns the current game type.
  
  public String toString(){
    return ("The current game type is " + this.type + " and the ante is $" + 
            this.ante + ".");
  }//AF implementation for CashGame objects.
  
 public boolean repOK(){
    return this.ante >= 0 && this.type != null;
    }
  //RI implementation of a CashGame object. Ante should be greater than
  //or equal to 0 and type should never be null.
  
}