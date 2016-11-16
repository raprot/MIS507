import java.util.ArrayList;

public class Deck{
   private static Card[] newDeck = new Card[52];//Array of Card objects that
                                                //holds the Deck of Cards.
   
   private final int DECK_SIZE = 52; //Final int variable to capture how many
                                     //indices a Deck array should have.
   private       int topCard = 52;   //Integer variabe to track the top card
                                     //in a Deck Card array as cards are taken
                                     //from the deck;
                  
  public static  String[] suitName = {"Spades", "Hearts", "Diamonds", 
                                      "Clubs"};//Default Deck Suits. Public
                                               //so that it can be overwritten.
  
  public static  String[] rankName = {"Ace", "Two", "Three", "Four", "Five",
                                       "Six", "Seven", "Eight", "Nine",
                                       "Ten", "Jack", "Queen", "King"};
                                      //Default Deck Ranks. Public so that it
                                      //can be overwritten.
                        
 public Deck(){
    
     for(int s = 0; s < suitName.length; s++){
      
      
      for(int r = 0; r < rankName.length; r++){
        int rVal = 0,
            sVal = 4 - s;
        
        if(r == 0){rVal = 14;}else{rVal = r + 1;}
        
      this.newDeck[((rankName.length * s) + r)] = 
           new Card(suitName[s], rankName[r], sVal , rVal);
      }
  }
    
 }//Deck class default, and only, constructor. Loops through 2 Arrays. One is 
  //an array of suit names Spades, Hearts etc. The other is an array of face
  //values, Ace, Two etc. Uses the Array indices for each array to set 
  //the suitNumber and rankNumber.
 
 public Card getCard(){
  this.topCard = this.topCard - 1;
  if(this.topCard < 0){
    System.out.println("Out of cards, shuffling the deck.");
    this.topCard = 51;
    shuffleDeck();
    return this.newDeck[this.topCard];}
  else{
    return this.newDeck[this.topCard];}
}//Pulls the top card from the deck. Uses the private int topCard to keep track
 //of which card in the array is the top card. Returns the card at the array
 //index taht matches the topCard value and decrements topCard.
 
 
 public void shuffleDeck(){
   for(int i = 0; i < this.newDeck.length; i++){
     int shuf = i + (int)(Math.random() * (DECK_SIZE - i));
     
     Card shuffleCard = this.newDeck[shuf];
     this.newDeck[shuf] = this.newDeck[i];
     this.newDeck[i] = shuffleCard;     
   }
 }//Uses the Fisher-Yates shuffle method to randomly shuffle the deck. 
  //Exact method used can be found here:
  //reference: https://www.dotnetperls.com/fisher-yates-shuffle
  //This is a somewhat straightforward and simple shuffle method so it 
  //does not stray far from the outline given by the source material.
 
  
 public int getNbrCardsInDeck(){
   return topCard + 1;
 }//Getter to return the number of cards left in the deck.
 
 public Card[] getDeck(){
   return newDeck;
 }//Getter to return the Card[] a Deck type object holds.
 

 public String toString(){
  String returnString = "";
  for(int i = 0; i < this.newDeck.length; i++){
      
    returnString += (newDeck[i].getSuit() + " " + 
                                  newDeck[i].getRank() + " " + 
                                  newDeck[i].getSuitNumber() + " " + 
                                  newDeck[i].getRankNumber() + "\n");
     }
  
  return returnString;
 }//AF implementation for the Deck Class.
 
 public boolean RepOk(Deck testDeck){
   boolean testRepOk = true;
  /* for(int i = 0; i < this.testDeck.getDeck().length; i++){
     testRepOK = (this.testDeck.getDeck()[i].RepOK && testDeck[i] != null);
       if(!testRepOk){break;}
    }*/
   return testRepOk;
 }
  
/*  
  public static void main(String args[]){
    Card testCard;
    Card myCard, myCard2;
    
    Deck pokerDeck = new Deck();
    
    pokerDeck.shuffleDeck();
    
    myCard = pokerDeck.getCard();
    myCard2 = pokerDeck.getCard();
    
    
    System.out.println(myCard.getRank() + " " + myCard.getSuit() + " " + myCard.getSuitNumber() + " " + myCard.getRankNumber());
   
    System.out.println(myCard2.getRank() + " " + myCard2.getSuit() + " " + myCard2.getSuitNumber() + " " + myCard2.getRankNumber());
    System.out.println(newDeck[51].toString());
    
    
    for(int i = 53; i > 0; i--){
      pokerDeck.getCard();
    }
        
    System.out.println(newDeck[51].RepOK(newDeck[51]));
    
    System.out.println(pokerDeck.toString());
    
    System.out.println(newDeck[51].toString());
    
  }
  */
}