public class PokerGameFactory extends PokerFactory{
	public static PokerGame createPokerGame(String pokerType){

		if (pokerType.equalsIgnoreCase("Draw")){
			return new 5CardDraw();
		}
		else if (pokerType.equalsIgnoreCase("Holdem")){
			return new TexasHoldem();
		}
		else if (pokerType.equalsIgnoreCase("Stud")){

			return new 7CardStud();
		}
		else if (pokerType.equalsIgnoreCase("Omaha")){
			return new Omaha();
		}
		else{
			return null;
		}

		public static PokerGame createPokerGame(String pokerType, BettingStructure bettingStructure, GameType gameType){

		if (pokerType.equalsIgnoreCase("Draw")){
			return new 5CardDraw(bettingStructure,gameType);
		}
		else if (pokerType.equalsIgnoreCase("Holdem")){
			return new TexasHoldem(bettingStructure,gameType);
		}
		else if (pokerType.equalsIgnoreCase("Stud")){

			return new 7CardStud(bettingStructure,gameType);
		}
		else if (pokerType.equalsIgnoreCase("Omaha")){
			return new Omaha(bettingStructure,gameType);
		}
		else{
			return null;
		}


}
