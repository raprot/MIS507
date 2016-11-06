public class DealerFactory extends PokerGameFactory{
	public Dealer createDealer(){
		return new Dealer();
	}
	public Dealer createDealer(String name, int tableNum, Deck deck){
		return Dealer(name, tableNum, deck);
	}
}