public class Card {
    
    private String rank, //String variable to capture the face vallue
                         //of any card
                   suit; //String variable to capture the suit value 
                         //of any card
  
     private int rankNumber, //Int variable to capture the integer face value
                             //of any card
                 suitNumber; //Int variable to capture the suit value of any
                             //card
     
     //AF: "rank" refers to the displayed string face value of a card.
     //"suit refers to the displayed string value of a card.
     //"rankNumber" refers to the integer face value of a card used for hand
     // strength comparisons.
     //"suitNumber" refers to the integer suit value, used to find out if a 
     //hand is a flush.
     //RI: rank and suit should not be nil. rankNumber should be between 2 and 
     //14. suitNumber should be between 1 and 4.
     
     //AF implementation, allows a user to print the contents of a Card object.
     public String toString(){
      return(rank + String.valueOf(suit.charAt(0)));
      /*toString implementation used for fine testing of cards
      return (rank + " of " + suit + ". Has a integer rank value of " + rankNumber + 
                           " and a integer suit value of " + suitNumber + ".");
                           */
    }     
     
    //RI implementation of a Card object to validate that the contents of 
    //a card object are logically correct.      
    public boolean repOK(){
      return ((rankNumber >= 2 && rankNumber <= 14) &&
              (suitNumber >= 1 && suitNumber <= 4) &&
              (suit != null && rank != null));
    }//RI implementation of a Card object to validate that the contents of 
     //a card object are logically correct.    
     
     public Card(){
         
     } //Default construtor. Creates an empty null card.
     

    public Card(String suit, String rank, int suitNumber, int rankNumber) {
        this.suit = suit;
        this.rank = rank;
        this.suitNumber = suitNumber;
        this.rankNumber = rankNumber;        
    } //Constructor used by the deck object to instantiate new cards. Sets the
      //rank string value, suit string value, rankNumber integer value,
      //and suitNumber integer value for each card.

    public String getRank() {
        return rank;
    }//Getter to return a Card object's rank String.

    public String getSuit() {
        return suit;
    }//Getter to return a Card object's suit String.

    public int getRankNumber() {
        return rankNumber;
    }//Getter to return a Card object's integer rankNumber.

    public int getSuitNumber() {
        return suitNumber;
    }//Getter to return a Card object's integer suitNumber.
    
     
/*
    public void setRank(String rank) {
        this.rank = rank;
    }//Setter to set a Card objet's rank String.

    public void setSuit(String suit) {
        this.suit = suit;
    }//Setter to set a Card object's suit String.
*/
    public void setRankNumber(int rankNum) {
        this.rankNumber = rankNumber;
    }//Setter to set a Card obects's rankNumber.
/*
    public void setSuitNumber(int suitNumber) {
        this.suitNumber = suitNumber;
    }//Setter to set a Card object's suitNumber.    
    */   
}