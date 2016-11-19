import java.util.ArrayList;

class CommunityCard{
  private ArrayList<Card> hand = new ArrayList<>();
  
  public void setCard(Card card){
    this.hand.add(card);
  }
  
  public ArrayList<Card> getCards(){
    return hand;
  }
  
}