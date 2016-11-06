public class PlayerFactory extends PokerGameFactory{
	public Player createPlayer(){
		return new Player();
	}
	public Player createPlayer(String name, double chip){
		return new Player(name, chip);
	}
}