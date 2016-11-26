public class SevenCardStud extends PokerGame{
  
  public SevenCardStud(BettingStructure bettingStructure, GameType gameType){
    super(bettingStructure, gameType);
    numPlayerCards = 7;
    numCommunityCards = 0;
  }
  
  public String toString(){
    return ("This is a Seven Card Stud game. Each player gets " + numPlayerCards + 
            " cards, and there are " + numCommunityCards + " community cards.\n"
            + gameType + " " + bettingStructure);
  }
}