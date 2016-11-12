public class DealerFactory extends PokerGameFactory{
	public Dealer createDealer(){
		return new Dealer();
	}
	public Dealer createDealer(String name){
		return Dealer(name);
	}
}