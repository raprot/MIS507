public class Deck{
   private static Card[] newDeck = new Card[52];
   private final int DECK_SIZE = 52;
   
   private static int c = 0,
                  topCard = 52;
   
   
   //Card[] newDeck = new Card[DECK_SIZE];
    
 // private static int[] suitInt = {1,2,3,4};
  
 // private static int[] cardInt = {1,2,3,4,5,6,7,8,9,10,11,12,13};
  
  public static  String[] suitName = {"Spades", "Hearts", "Diamonds", 
                                      "Clubs"};
  
  public static  String[] rankName = 
                                       {"Ace", "Two", "Three", "Four", "Five",
                                       "Six", "Seven", "Eight", "Nine",
                                       "Ten", "Jack", "Queen", "King"};
                        
 public Deck(){
    
     for(int s = 0; s < suitName.length; s++){
      
      
      for(int r = 0; r < rankName.length; r++){
        
        
      this.newDeck[c] = new Card(rankName[r], suitName[s], (s + 1) , (r + 1));
      
      //
       
       this.c++;
      }
  }
    
 }
 
 public Card getCard(){
  this.topCard = this.topCard - 1;
  return this.newDeck[this.topCard];
}
 
 public void shuffleDeck(){
   //reference: https://www.dotnetperls.com/fisher-yates-shuffle
   for(int i = 0; i < this.newDeck.length; i++){
     int shuf = i + (int)(Math.random() * (DECK_SIZE - i));
     
     Card shuffleCard = this.newDeck[shuf];
     this.newDeck[shuf] = this.newDeck[i];
     this.newDeck[i] = shuffleCard;     
   }
   
   for(int i = 0; i < this.newDeck.length; i++){
       System.out.println(newDeck[i].getSuit() + " " + newDeck[i].getRank() + " " + newDeck[i].getSuitNumber()  + " " + newDeck[i].getRankNumber());
     }
 }
   
  
  public static void main(String args[]){
    Card myCard, myCard2;
    
    Deck pokerDeck = new Deck();
    
    pokerDeck.shuffleDeck();
    
    myCard = pokerDeck.getCard();
    myCard2 = pokerDeck.getCard();
    
    System.out.println(myCard.getRank() + " " + myCard.getSuit() + " " + myCard.getSuitNumber() + " " + myCard.getRankNumber());
   
    System.out.println(myCard2.getRank() + " " + myCard2.getSuit() + " " + myCard2.getSuitNumber() + " " + myCard2.getRankNumber());
   
  }
  
}