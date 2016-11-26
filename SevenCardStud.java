public class SevenCardStud extends PokerGame{
  
  public SevenCardStud(BettingStructure bettingStructure, GameType gameType){
    super(bettingStructure, gameType);
    numPlayerCards = 7;
    numCommunityCards = 0;
  }
}