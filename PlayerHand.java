import java.util.ArrayList;

class PlayerHand{
  private ArrayList<Card> hand = new ArrayList<>();
  
  public void setPlayerHand(Card card){
    this.hand.add(card);
  }
  
  public ArrayList<Card> getPlayerHand(){
    return hand;
  }
  
}
