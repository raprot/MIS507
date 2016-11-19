public class Card {
    
    private String rank, //String variable to capture the face vallue
                         //of any card
                   suit; //String variable to capture the suit value 
                         //of any card
  
     private int rankNumber, //Int variable to capture the integer face value
                             //of any card
                 suitNumber; //Int variable to capture the suit value of any
                             //card
     
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
    
    public int compareTo(Card card1, Card card2){
      int returnInt = 0;
      
      if(card1.getRankNumber() <= card2.getRankNumber()){
        returnInt = -1;
      } else if(card1.getRankNumber() >= card2.getRankNumber()){
        returnInt = 1;
      }
      
      return returnInt;
    }
/*
    public void setRank(String rank) {
        this.rank = rank;
    }//Setter to set a Card objet's rank String.

    public void setSuit(String suit) {
        this.suit = suit;
    }//Setter to set a Card object's suit String.
*/
    public void setRankNumber(int rankNumber) {
        this.rankNumber = rankNumber;
    }//Setter to set a Card obects's rankNumber.
/*
    public void setSuitNumber(int suitNumber) {
        this.suitNumber = suitNumber;
    }//Setter to set a Card object's suitNumber.    
    */   
    public String toString(){
      return(rank + String.valueOf(suit.charAt(0)));
      /*toString implementation used for fine testing of cards
      return (rank + " of " + suit + ". Has a integer rank value of " + rankNumber + 
                           " and a integer suit value of " + suitNumber + ".");
                           */
    }//AF implementation, allows a user to print the contents of a Card object.
    
    public boolean RepOK(Card testCard){
      return ((testCard.getRankNumber() >= 2 && testCard.getRankNumber() <= 14) &&
              (testCard.getSuitNumber() >= 1 && testCard.getSuitNumber() <= 4) &&
              (testCard.getSuit() != null && testCard.getRank() != null));
    }//RI implementation of a Card object to validate that the contents of 
     //a card object are logically correct.
}