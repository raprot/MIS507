public class Omaha extends PokerGame{
  
  public Omaha(BettingStructure bettingStructure, GameType gameType){
    super(bettingStructure, gameType);
    numPlayerCards = 4;
    numCommunityCards = 5;
  }
}