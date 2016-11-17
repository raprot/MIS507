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