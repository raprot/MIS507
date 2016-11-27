public class SevenCardStud extends PokerGame{
    
    public SevenCardStud(){
        super();
    }
    public SevenCardStud(BettingStructure bettingStructure, GameType gameType){
        super(bettingStructure, gameType);
        numPlayerCards = 7;
        numCommunityCards = 0;
    
    }

    public String toString(){
        String result = "";
        result = "This is a Seven Card Stud game.";
        result += "Each player gets " + getNumPlayerCards() + " cards"; 
        result += "and there are " + getNumCommunityCards() + " community cards.\n";
        result +=  getGameType() + " " + getBettingStructure();
        return result;
    }
}