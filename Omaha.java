public class Omaha extends PokerGame{
  
  public Omaha(BettingStructure bettingStructure, GameType gameType){
    super(bettingStructure, gameType);
    numPlayerCards = 4;
    numCommunityCards = 5;
  }
  
  public String toString(){
    return ("This is an Omaha game. Each player gets " + numPlayerCards + 
            " cards, and there are " + numCommunityCards + " community cards.\n"
            + gameType + " " + bettingStructure);
  }
}