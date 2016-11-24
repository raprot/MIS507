public class TournamentGame extends GameType{
  
  public TournamentGame(){
  }
  //Default constructor for TournamentGame objects.
  
  public TournamentGame(double ante, String type){
    this.ante = ante;
    this.type = type;}
  //TournamentGame constructor that sets the ante and type variables.
  
  public void setAnte(double ante){
    this.ante = ante;}
  //Setter for TournamentGame objects that sets the ante variable.

  public double getAnte(){
    return this.ante;}
  //Getter for TournamentGame objects that returns the ante variable.
  
  public void setType(String type){
    this.type = type;}
  //Setter for TournamentGame objects that sets the type variable.
  
  public String getType(){
    return this.type;}
  //Getter for TournamentGame objects that returns the type variable.
  
  public String toString(){
    return ("Table ante is " + this.ante + " chips the current game type is " + 
            this.type + ".");
  }//AF implementation of a tournament game object.
  
  public boolean repOK(){
    return this.ante >= 0 && this.type != null;
  }
  //RI implementation of a TournamentGame object. Ante should be greater than
  //or equal to 0 and type should never be null.
  
}