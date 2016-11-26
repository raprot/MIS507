public class FiveCardDraw extends PokerGame{
  
  public FiveCardDraw(BettingStructure bettingStructure, GameType gameType){
    super(bettingStructure, gameType);
    numPlayerCards = 5;
    numCommunityCards = 0;
  }
}