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
  
  public static void main(String[] args){
    
    Limit limitTable = new Limit(2.00, 4.00);
    
    NoLimit noLimitTable =  new NoLimit(50,100);
    
    System.out.println(limitTable.toString());
    
    System.out.println(noLimitTable.toString());
    
  }
   
}