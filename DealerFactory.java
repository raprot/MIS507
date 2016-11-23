public class DealerFactory extends PokerFactory{
	public static Dealer createDealer(String dealType){
		if (dealType.equalsIgnoreCase("Draw")){
			return new DrawDealer();
		}
		else if (dealType.equalsIgnoreCase("Stud")){
			return new StudDealer();
		}
		else if (dealType.equalsIgnoreCase("Holdem")){
			return new HoldemDealer();
		}
		else if (dealType.equalsIgnoreCase("Omaha")){
			return new OmahaDealer();
		}
		else{
			return null;
		}
		
	}
	public static Dealer createDealer(String dealType, String name){
		if (dealType.equalsIgnoreCase("Draw")){
			return new DrawDealer(name);
		}
		else if (dealType.equalsIgnoreCase("Stud")){
			return new StudDealer(name);
		}
		else if (dealType.equalsIgnoreCase("Holdem")){
			return new HoldemDealer(name);
		}
		else if (dealType.equalsIgnoreCase("Omaha")){
			return new OmahaDealer(name);
		}
		else{
			return null;
		}
		
	}
}