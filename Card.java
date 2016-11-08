public class Card {
    
    private String rank, //String variable to capture the Face Value 
                               //of any card
                 suit;      //String variable to capture the Suit Value 
                               //of any card
  
     private int rankNumber,
              suitNumber;
     
     public Card(){
         
     }
     

    public Card(String rank, String suit, int suitNumber, int rankNumber) {
        this.rank = rank;
        this.suit = suit;
        this.rankNumber = rankNumber;
        this.suitNumber = suitNumber;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getRankNumber() {
        return rankNumber;
    }

    public int getSuitNumber() {
        return suitNumber;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setRankNumber(int rankNumber) {
        this.rankNumber = rankNumber;
    }

    public void setSuitNumber(int suitNumber) {
        this.suitNumber = suitNumber;
    }    
       
    public String toString(){
      return (rank + " of " + suit + ". Has a integer rank value of " + rankNumber + 
                           " and a integer suit value of " + suitNumber + ".");
    }
}