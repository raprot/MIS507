public class FiveCardDraw extends PokerGame{
  
  public FiveCardDraw(BettingStructure bettingStructure, GameType gameType){
    super(bettingStructure, gameType);
    numPlayerCards = 5;
    numCommunityCards = 0;
  }
  
  public String toString(){
    return ("This is a Five Card Draw Game. Each player gets " + numPlayerCards +
            " cards, and there are " + numCommunityCards + " community cards.\n" 
            + gameType + " " + bettingStructure);
  }
}