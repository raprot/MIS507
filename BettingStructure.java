public abstract class BettingStructure{
  double bigBlind,//Variable to capture the current big blind.
                 smallBlind;//Variable to capture the current small blind.
  
  abstract public void setBigBlind(Double bigBlind);
  //Setter for a BettingStructure object's bigBlinds.
  
  abstract public double getBigBlind();
  //Abstract Getter for bigBlinds.
  
  abstract public void setSmallBlind(Double smallBlind);
  //Abstract Setter for smallBlinds.
  
  abstract public double getSmallBlind();
  //Abstract Getter for smallBlinds
  
  abstract public String toString();
  //AF implementation for the Abstract Betting Structure class.
  
  abstract public boolean repOK();
  //RI implementation for the Abstract Betting Structure class.
  
   
}