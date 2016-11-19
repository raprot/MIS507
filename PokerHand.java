
import java.util.*;

class PokerHand implements Comparable<PokerHand>{
  private HandStrengthAnalyzer hsa = new HandStrengthAnalyzer();
  private Card[] hand = new Card[5];
  private static  ArrayList<Card> temp = new ArrayList<>();
  private int handStrength;
  
  @Override public int compareTo(PokerHand pokerHand){
    return 0;
  }
  
  private int getHandStrength(){
    handStrength = this.hsa.getHandStrengthVal();
    return handStrength;
  }
  
  private Card[] getHand(){
    return hand;
  }
    
  public Card[] getBestHand(ArrayList<Card> playerCard, ArrayList<Card> communityCard){
    for(int i = 0; i < playerCard.size(); i++){
      temp.add(playerCard.get(i));
    }
    for(int i = 0; i < communityCard.size(); i++){
      temp.add(communityCard.get(i));
    }
    
    hand =  hsa.getBestHand(temp);
    return hand;
  }
  
  //Unecessary Code
  public static ArrayList<Card> getTemp(){
    return temp;
  }

  
  public static void main(String[] args){
    Card [] catcher;
    Deck d = new Deck();
    d.shuffleDeck();
    PlayerHand p = new PlayerHand();
    p.setPlayerHand(d.getCard());
    p.setPlayerHand(d.getCard());
    CommunityCard c = new CommunityCard();
    c.setCommunityCard(d.getCard());
    c.setCommunityCard(d.getCard());
    c.setCommunityCard(d.getCard());
    c.setCommunityCard(d.getCard());
    c.setCommunityCard(d.getCard());
    
    PokerHand pk = new PokerHand();
        
   /* for(int i = 0; i < p.getPlayerHand().size(); i++){
      System.out.println(p.getPlayerHand().get(i).toString());
    }
    
    for(int i = 0; i < c.getCommunityHand().size(); i++){
      System.out.println(c.getCommunityHand().get(i).toString());
    }*/
    
    catcher = pk.getBestHand(p.getPlayerHand(), c.getCommunityCards());
    
    
     for(int i = 0; i < pk.getTemp().size(); i++){
      System.out.println(pk.getTemp().get(i).toString());
    }
     
    
    
    System.out.println("\n\n\n\n\n");
    for(int i = 0; i < catcher.length; i++){
      System.out.println(catcher[i]);
    }
    
    //pk.compareTo(pk.getTemp());
 
    
    
  }
}
