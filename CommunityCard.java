import java.util.ArrayList;

class CommunityCard{
  private ArrayList<Card> hand = new ArrayList<>();
  
  public void setCommunityCard(Card card){
    this.hand.add(card);
  }
  
  public ArrayList<Card> getCommunityCards(){
    return hand;
  }
  
}