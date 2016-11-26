public abstract class PokerGame{
 public String gameType;
 
 public double bigBlind,
                      smallBlind,
                      ante;
 
 public String getGameType(){
   return this.gameType;
 }
 
 public void setGameType(String gameType){
   this.gameType = gameType;}
 
 public double getAnte(){
   return this.ante;
 }
 
 public void setAnte(double ante){
   this.ante = ante;
 }
 
}