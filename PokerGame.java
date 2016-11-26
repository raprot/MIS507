public class PokerGame{
  int numPlayerCards;
  int numCommunityCards;
  private BettingStructure bettingStructure;
  private GameType gameType;
  
  public PokerGame(){
  }
  
  public PokerGame(BettingStructure bettingStructure, GameType gameType){
    this.gameType = gameType;
    this.bettingStructure = bettingStructure;
  }
  
  public GameType getGameType(){
    return gameType;
  }
  
  public BettingStructure getBettingStructure(){
    return bettingStructure;
  }
  
  public int getNumPlayerCards(){
    return numPlayerCards;
  }
  
  public int getNumCommunityCards(){
    return numCommunityCards;
  }
  
  public String toString(){
    return ("Each player gets " + numPlayerCards + " cards, and there are " +
            numCommunityCards + " community cards. " + gameType + " " + 
            bettingStructure);
  }
  
  public boolean repOK(){
    return (numPlayerCards > 0 && numCommunityCards >= 0 && 
           bettingStructure != null && gameType != null);
  }
  
  public static void main(String[] args){
    
    BettingStructure bs = new Limit(2,4);
    
    GameType gt = new CashGame(0, "Cash");
    
    PokerGame pg = new TexasHoldEm(bs, gt);
    
    System.out.println(pg.repOK());
    
    
  }
}