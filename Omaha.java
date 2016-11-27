public class Omaha extends PokerGame{
    
    public Omaha(){
        super();

    }

    public Omaha(BettingStructure bettingStructure, GameType gameType){
        super(bettingStructure, gameType);
        numPlayerCards = 4;
        numCommunityCards = 5;
   
    }

    public String toString(){
        String result = "";
        result = "This is a Omaha game.";
        result += "Each player gets " + getNumPlayerCards() + " cards"; 
        result += "and there are " + getNumCommunityCards() + " community cards.\n";
        result +=  getGameType() + " " + getBettingStructure();
        return result;
    }
}
