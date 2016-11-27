public class NoLimit extends BettingStructure{ 
  
    public NoLimit(){
        //Default constructor for "NoLimit" type objects.
    }

    public NoLimit(double smallBlind, double bigBlind){
        //Constructor for "Limit" type objects that sets the big and small blinds.
        this.smallBlind = smallBlind;
        this.bigBlind = bigBlind;
    }


    public String toString(){
        //AF implementation for the "Limit" class.
        return ("this is a \"No-Limit\" table the Big Blind is: " + bigBlind + ", the Small Blind is " + smallBlind + ".");
    }
    

    public boolean repOK(){
        //RI implementation for the "Limit" class.
        return bigBlind >=0 && smallBlind >= 0;
    }
    
}