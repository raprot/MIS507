public class BettingStructureFactory extends PokerGameFactory{
	// public BettingStructure createBettingStructure(){
	// 	return new BettingStructure();
	// }
	public BettingStructure createBettingStructure(String structure){
		if (gameType.equalsIgnoreCase("limit")){
			return Limit();
		}
		else {
			return Noliimt();
		}
	}
}