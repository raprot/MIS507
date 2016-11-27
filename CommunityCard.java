import java.util.ArrayList;

class CommunityCard{
    //rewrite: add constructor by Johnny
    private ArrayList<Card> hand;

    CommunityCard(){
        this.hand = new ArrayList<Card>();
    }
    
    public void setCard(Card card){
        this.hand.add(card);
    }

    public ArrayList<Card> getCards(){
        return hand;
    }

    // Add By Johnny
    public String toString(){
        String result = ""; 
        for(int i=0; i < hand.size(); i++){
            result += hand.get(i) + "\t";
        }
        return result;
    }

}