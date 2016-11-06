public class GameTypeFactory extends PokerGameFactory{
	// public GameTypeFactory createGameType(){
	// 	return new GameType();
	// }
	public GameTypeFactory createGameType(String gameType){
		if (gameType.equalsIgnoreCase("cash")){
			return CashGame();
		}
		else {
			return TournamentGame();
		}
	}
}