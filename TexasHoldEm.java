public class TexasHoldEm extends PokerGame{
  
  public TexasHoldEm(BettingStructure bettingStructure, GameType gameType){
    super(bettingStructure, gameType);
    numPlayerCards = 2;
    numCommunityCards = 5;
  }
  
  public String toString(){
    return ("This is a Texas Hold 'Em game. Each player gets " + numPlayerCards + 
            " cards, and there are " + numCommunityCards + " community cards.\n"
            + gameType + " " + bettingStructure);
  }
}