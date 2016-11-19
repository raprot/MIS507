import java.util.*;

class PokerHand implements Comparable<PokerHand>{
  private HandStrengthAnalyzer hsa = new HandStrengthAnalyzer();
  private Card[] hand = new Card[5];
  private static  ArrayList<Card> temp = new ArrayList<>();
  private int handStrength;
  
  @Override public int compareTo(PokerHand pokerHand){
    int equalStrength = 0;
    
    final int LESS_THAN = -1;
    final int EQUAL =0;
    final int GREATER_THAN = 1;
    
    if(this.handStrength < pokerHand.getHandStrength()){      
      return LESS_THAN;}
    else if(this.handStrength > pokerHand.getHandStrength()){
      return GREATER_THAN;}
    else if(this.handStrength == pokerHand.getHandStrength()){
      for(int i = 0; i < this.hand.length; i++){
        if(equalStrength == 0){
          equalStrength = this.hand[i].getRankNumber() - pokerHand.getHand()[i].getRankNumber();
        }
      }
    }
            
    if(equalStrength < 0){
      return LESS_THAN;}
    else if(equalStrength > 1){
      return GREATER_THAN;}
    else return EQUAL;      
  }
  
  private int getHandStrength(){
    return handStrength;
  }
  
  private Card[] getHand(){
    return hand;
  }
    
  public Card[] getBestHand(ArrayList<Card> playerCard, ArrayList<Card> communityCard){
    for(int i = 0; i < playerCard.size(); i++){
      this.temp.add(playerCard.get(i));
    }
    for(int i = 0; i < communityCard.size(); i++){
      this.temp.add(communityCard.get(i));
    }
    
    hand =  hsa.getBestHand(temp);
    handStrength = this.hsa.getHandStrengthVal();;
    temp.clear();
    return hand;
    
  }
  
  //Unecessary Code
  private static ArrayList<Card> getTemp(){
    return temp;
  }
}