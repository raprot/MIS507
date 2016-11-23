public class PlayerFactory extends PokerFactory{
	public static Player createPlayer(String playerType){

		if (gameType.equalsIgnoreCase("Human")){
			return new HumanPlayer();
		}
		else if (gameType.equalsIgnoreCase("AI")){
			return new AIPlayer();
		}
		else{
			return null;
		}

	}

	public static Player createPlayer(String playerType, String name, double chip){

		if (gameType.equalsIgnoreCase("human")){
			return new HumanPlayer(name, chip);
		}
		else if (gameType.equalsIgnoreCase("AI")){
			return new AIPlayer(name, chip);
		}
		else{
			return null;
		}
	}
}