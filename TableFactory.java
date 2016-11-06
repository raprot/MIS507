public class TableFactory extends PokerGameFactory{
	public Table createTable(){
		return new Table();
	}
	public Table createTable(int tableNum, int maxNumPlayer, Dealer dealer){
		return new Table(tableNum, maxNumPlayer, dealer);
	}
}