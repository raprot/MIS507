public class TexasHoldEm extends PokerGame{
  
  public TexasHoldEm(BettingStructure bettingStructure, GameType gameType){
    super(bettingStructure, gameType);
    numPlayerCards = 2;
    numCommunityCards = 5;
  }
}