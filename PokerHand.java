import java.util.*;

class PokerHand implements Comparable<PokerHand>{
  private Card[] hand = new Card[5];
  private static  ArrayList<Card> temp = new ArrayList<>();
  
  public int compareTo(PokerHand hand){
    return 0;
  }
  
  public static void getBestHand(ArrayList<Card> playerCard, ArrayList<Card> communityCard){
    for(int i = 0; i < playerCard.size(); i++){
      temp.add(playerCard.get(i));
    }
    for(int i = 0; i < communityCard.size(); i++){
      temp.add(communityCard.get(i));
    }
  }
  
  //Unecessary Code
  public static ArrayList<Card> getTemp(){
    return temp;
  }

  
  public static void main(String[] args){
    Deck d = new Deck();
    d.shuffleDeck();
    PlayerHand p = new PlayerHand();
    p.getPlayerCard(d.getCard());
    p.getPlayerCard(d.getCard());
    CommunityCard c = new CommunityCard();
    c.getCommunityCards(d.getCard());
    c.getCommunityCards(d.getCard());
    c.getCommunityCards(d.getCard());
    c.getCommunityCards(d.getCard());
    c.getCommunityCards(d.getCard());
    
    PokerHand pk = new PokerHand();
        
   /* for(int i = 0; i < p.getPlayerHand().size(); i++){
      System.out.println(p.getPlayerHand().get(i).toString());
    }
    
    for(int i = 0; i < c.getCommunityHand().size(); i++){
      System.out.println(c.getCommunityHand().get(i).toString());
    }*/
    
    pk.getBestHand(p.getPlayerHand(), c.getCommunityHand());
    //pk.compareTo(pk.getTemp());

    for(int i = 0; i < pk.getTemp().size(); i++){
      System.out.println(pk.getTemp().get(i).toString());
    }
    
    
    
  }
}