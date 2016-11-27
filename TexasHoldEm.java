public class TexasHoldEm extends PokerGame{
    public TexasHoldEm(){
        super();
    }
    public TexasHoldEm(BettingStructure bettingStructure, GameType gameType){
        super(bettingStructure, gameType);
        this.numPlayerCards = 2;
        this.numCommunityCards = 5;
        
    }


 
    public String toString(){
        String result = "";
        result = "This is a Texas Hold 'Em game.";
        result += "Each player gets " + getNumPlayerCards() + " cards"; 
        result += "and there are " + getNumCommunityCards() + " community cards.\n";
        result +=  getGameType() + " " + getBettingStructure();
        return result;
    }
}