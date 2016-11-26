public class Limit extends BettingStructure{  
  
  public Limit(){
  }//Default constructor for "Limit" type objects.
  
  public Limit(double bigBlind, double smallBlind){
    this.bigBlind = bigBlind;
    this.smallBlind = smallBlind;
  }//Constructor for "Limit" type objects that sets the big and small blinds.
  
  public void setBigBlind(Double bigBlind){
    this.bigBlind = bigBlind; 
  }
  //Setter for a "Limit" object's bigBlind variable.
  
  public double getBigBlind(){
    return this.bigBlind;}
  //Getter for a "Limit" object's bigBlind variable.
  
  public void setSmallBlind(Double smallBlind){
    this.smallBlind = smallBlind;
  }
  //Setter for a "Limit" object's smallBlind variable.
  
  public double getSmallBlind(){
    return this.smallBlind;
  }
  //Getter for a "Limit" object's smallBlind variable
  
  public String toString(){
    return ("This is a \"Limit\" table the Big Blind is: " + bigBlind +
            ", the Small Blind is " + smallBlind + ".");
  }
  //AF implementation for the "Limit" class.
  
  public boolean repOK(){
    return bigBlind >=0 && smallBlind >= 0;}
  //RI implementation for the "Limit" class.
   
}