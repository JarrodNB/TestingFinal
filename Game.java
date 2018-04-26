

public class Game {

	private Deck deck;
	private Player player = new Player();
	private Dealer dealer = new Dealer();
	
	public void gameStart()
	{
		System.out.println("Welcome to a game of black jack");
		deck = new Deck();
		player = new Player();
		dealer = new Dealer();
		dealGameHands();	
	}
	
	public void playerRound()
	{
		System.out.println("");
	}
	
	public void dealerRound()
	{
		
	}
	
	private void dealGameHands()
	{
		Hand playerHand = new Hand();
		playerHand.setCurrentHand(deck.dealHand());
		Hand dealerHand = new Hand();
		dealerHand.setCurrentHand(deck.dealHand());
		player.setPlayerHand(playerHand);
		dealer.setDealerHand(dealerHand);
	}
	
}
