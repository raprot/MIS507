import java.util.ArrayList;

class PlayerHand{
	private ArrayList<Card> hand ;
	// Revised by Johnny, 
	// correct way to declare ArrayList:  ArrayList<Type> variable = new ArrayList<Type>()

	// Add contructor by Johnny
	public PlayerHand(){
		this.hand =  new ArrayList<Card>();
	}

	public void setCard(Card card){
		this.hand.add(card);
	}

	public ArrayList<Card> getCards(){
		return this.hand;
	}

	// Add by Johnny
	public String toString(){
        String result = ""; 
        for(int i=0; i < hand.size(); i++){
            result += hand.get(i) + "\t";
        }
        return result;
    }
  
}