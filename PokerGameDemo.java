public class PokerGameDemo{

	public static void main(String [ ] args){

	// ====================================== Initailize the Game ======================================
	// =================================================================================================

	// 	=================================== Create the all objects ===================================

		// Parameters for Texas Holdem, cash Game(no ante), No Limit 
		String pokerType = "Holdem";
		String gameType = "Cash";
		String structure = "NoLimit";
		double ante = 0; // cash game has no ante.
		double smallBlind = 1; 
		double bigBlind = 2; 
		double chip = 200;

		// Parameters for table
		int tableNum = 1;
		int maxNumPlayer = 9;
		
		// Parameters for dealer
		String dealerName = "Daniel";

		// Parameters for players
		String playerType = "Human";
		String playerName1 = "Johnny";
		String playerName2 = "Josh";
		String playerName3 = "Justin";
		String playerName4 = "Michelle";


		// Create a Texas Hold'em for poker game
		GameType cashGame = GameTypeFactory.createGameType(gameType, ante);
		BettingStructure noLimit = BettingStructureFactory.createBettingStructure(structure, smallBlind, bigBlind);
		PokerGame texasHoldem = PokerGameFactory.createPokerGame(pokerType, noLimit, cashGame);

		// Create a dealer for poker game	
		Dealer dealer= DealerFactory.createDealer(pokerType, dealerName); 
		Table table = TableFactory.createTable(tableNum, maxNumPlayer);

		// System.out.println("TEST" + table);




		// Tell dealer the what poker game is and the table is 
		dealer.setPokerGame(texasHoldem);
		dealer.setTable(table);
		dealer.setDeck();

		// Create a table for poker game 
		table.setDealer(dealer);
		

		
		// Create 4 players for poker game		
		Player humanPlayer1 = PlayerFactory.createPlayer(playerType, playerName1, chip);
		Player humanPlayer2 = PlayerFactory.createPlayer(playerType, playerName2, chip);
		Player humanPlayer3 = PlayerFactory.createPlayer(playerType, playerName3, chip);
		Player humanPlayer4 = PlayerFactory.createPlayer(playerType, playerName4, chip);
		
		// Set Player at Table
		// table.setPlayer(humanPlayer1);
		// table.setPlayer(humanPlayer2);
		// table.setPlayer(humanPlayer3);
		// table.setPlayer(humanPlayer4);

		humanPlayer1.joinTable(table);
		humanPlayer2.joinTable(table);
		humanPlayer3.joinTable(table);
		humanPlayer4.joinTable(table);

		
		dealer.setActivePlayers();

		
		// table.joinTable(humanPlayer2);
		// table.joinTable(humanPlayer3);
		// table.joinTable(humanPlayer4);



		// table.setCurrentPlayers();
		// System.out.println(table);
		


	// =================================== Print out all information =================================== 

		// Print the Game Type Info
		System.out.println(texasHoldem);
		
		// Print the Table Info:
		System.out.println(table);

		// Print Dealer Info:
		System.out.println(dealer);


		


	// ======================================== Start this Round ======================================
	// ================================================================================================
	
	//  =================================== Dealer starts the hand =================================
		System.out.println("Start this round.");
		
		dealer.startHands();

		// Print each player's hand

		// Print Player Info and each player's position: button, small blind, big blind 
		// int currentNumPlayer = table.getCurrentNumPlayer();
		// int buttonPosition = table.getButtonPosition();
		// int smallBlindPostion = (buttonPosition + 1) % currentNumPlayer;
		// int bigBlindPostion = (buttonPostion + 2) % currentNumPlayer;

		System.out.println( humanPlayer1 + " at botton positon of this table.");
		System.out.println( humanPlayer2 + " at small blind position of this table.");
		System.out.println( humanPlayer3 + " at big blind position of this table.");
		System.out.println( humanPlayer4);


		// System.out.println(humanPlayer1);
		// System.out.println(humanPlayer2);
		// System.out.println(humanPlayer3);
		// System.out.println(humanPlayer4);


	// 	=================================== At Pre-Flop Stage ===================================
		
		System.out.println("\n============= At Pre-Flop Stage =============");
		double totalBettingAmount = 0.0;

		// Player 1 and player 2 bet small blind and big blind.
		System.out.println("Player 1 bets small blind.");
		humanPlayer1.bet(smallBlind);
		System.out.println("Player 2 bets big blind.");
		humanPlayer2.bet(bigBlind);

		// Dealer puts small blind and big blind into pot.
		dealer.getBlindsFromPlayer();

		// Each player's action
		System.out.println("Player 3's action: call");

		totalBettingAmount += humanPlayer3.call();
		
		System.out.println("Player 4's action: call");
		totalBettingAmount += humanPlayer4.call();
		
		System.out.println("Player 1's action: call");
		double amount = bigBlind - smallBlind;
		totalBettingAmount += humanPlayer1.bet(amount);
		
		System.out.println("Player 2's action: check");
		totalBettingAmount += humanPlayer2.check();
		
		// dealder collects all betting amount into pot
		System.out.println("Dealer collects all moneys to the pot.");
		dealer.getAmountFromPlayer(totalBettingAmount);

		// Show the pot size
		System.out.println("The pot size is:" + table.getPot());


	// 	=================================== At Flop Stage ===================================
		System.out.println("\n============= At Flop Stage =============");
		totalBettingAmount = 0.0;

		// dealer burn card
		dealer.burnCard();

		// dealer deal community cards (3 cards)
		dealer.dealCommunityCard();
		dealer.dealCommunityCard();
		dealer.dealCommunityCard();
		
		// Print out the community cards on the table
		System.out.println("The first 3 cards on table are:");
		System.out.println(table.getCommunityCards());

		// Each player's action
		System.out.println("player 2's action: bet");
		amount = 10;
		totalBettingAmount += humanPlayer2.bet(amount);
		
		System.out.println("player 3's action: call");
		totalBettingAmount += humanPlayer3.call();
		
		System.out.println("player 4's action: call");
		totalBettingAmount += humanPlayer4.call();
		
		System.out.println("player 1's action: fold");
		totalBettingAmount += humanPlayer1.fold();

		System.out.println("Dealer collects all moneys to the pot.");
		dealer.getAmountFromPlayer(totalBettingAmount);	

		// Show the pot size
		System.out.println("The pot size is:" + table.getPot());




	// 	=================================== At Turn Stage ===================================
		System.out.println("\n============= At Turn Stage =============");
		totalBettingAmount = 0.0;

		// dealer burn card
		dealer.burnCard();

		// dealer deal community cards (1 cards)
		dealer.dealCommunityCard();
		// Print out the community cards on the table
		System.out.println("The first 4 cards on table are:");
		System.out.println(table.getCommunityCards());
		
		// Each player's action
		System.out.println("player 2's action: check");
		
		totalBettingAmount += humanPlayer2.check();
		
		System.out.println("player 3's action: bet");
		amount = 30;
		totalBettingAmount += humanPlayer3.bet(amount);
		
		System.out.println("player 4's action: call");
		totalBettingAmount += humanPlayer4.call();
		
		System.out.println("player 2's action: fold");
		totalBettingAmount += humanPlayer2.fold();

		System.out.println("Dealer collects all moneys to the pot.");
		dealer.getAmountFromPlayer(totalBettingAmount);	

		// Show the pot size
		System.out.println("The pot size is:" + table.getPot());



	//	=================================== At River Stage ===================================
		System.out.println("\n============= At River Stage =============");
		totalBettingAmount = 0.0;

		// dealer burn card
		dealer.burnCard();

		// dealer deal community cards (1 cards)
		dealer.dealCommunityCard();
		// Print out the community cards on the table
		System.out.println("The total 5 cards on table are:");
		System.out.println(table.getCommunityCards());
		
		// Each player's action
	
		System.out.println("player 3's action: bet");
		amount = 60;
		totalBettingAmount += humanPlayer3.bet(amount);
		
		System.out.println("player 4's action: call");
		totalBettingAmount += humanPlayer4.call();
		
		
		System.out.println("Dealer collects all moneys to the pot.");
		dealer.getAmountFromPlayer(totalBettingAmount);	

		// Show the pot size
		System.out.println("The pot size is:" + table.getPot());

	// ======================================== End this Round ======================================
	// ===============================================================================================
		
		// Show current player's best hand 
		// System.out.println("player 3's best hand is: ");
		// bestHand = humanPlayer3.getBestHand();
		// for (int i = 0; bestHand.size(); i++){
		// 	System.out.println(bestHand.get(i));
		// }

		// System.out.println("player 4's best hand is: ");
		// bestHand = humanPlayer4.getBestHand();
		// for (int i = 0; bestHand.size(); i++){
		// 	System.out.println(bestHand.get(i));
		// }
		
		// Decide the winner

		

	}
	
}