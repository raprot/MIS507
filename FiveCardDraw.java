public class FiveCardDraw extends PokerGame{
    public FiveCardDraw(){
         super();
    }
    public FiveCardDraw(BettingStructure bettingStructure, GameType gameType){
        super(bettingStructure, gameType);
        numPlayerCards = 5;
        numCommunityCards = 0;
    }

    public String toString(){
        String result = "";
        result = "This is a Five Card Draw game.";
        result += "Each player gets " + getNumPlayerCards() + " cards"; 
        result += "and there are " + getNumCommunityCards() + " community cards.\n";
        result +=  getGameType() + " " + getBettingStructure();
        return result;
    }
}