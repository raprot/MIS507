import java.util.ArrayList;

class PlayerHand{
  private ArrayList<Card> hand = new ArrayList<>();
  private Player player;
  private boolean mucked;
  
  
  public void getPlayerCard(Card card){
    hand.add(card);
  }
  
  public ArrayList<Card> getPlayerHand(){
    return hand;
  }
  
  public void getPlayer(Player p){
  }
  public boolean getMucked(){
   return true;
  }
  public void setMucked(){
  }
  public void compareTo(){
  }
}
import java.util.ArrayList;

class CommunityCard{
  private ArrayList<Card> hand = new ArrayList<>();
  
  public void getCommunityCards(Card card){
    hand.add(card);
  }
  public void setCards(){
    
  }
  
  public ArrayList<Card> getCommunityHand(){
    return hand;
  }
  
}