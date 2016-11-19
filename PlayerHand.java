import java.util.ArrayList;

class PlayerHand{
  private ArrayList<Card> hand = new ArrayList<>();
  
  public void setCard(Card card){
    this.hand.add(card);
  }
  
  public ArrayList<Card> getCards(){
    return hand;
  }
  
}