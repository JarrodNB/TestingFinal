public class DealerTurn {
	
	private BlackJackDealer dealer;
	private Deck deck;
	
	public void start(BlackJackDealer dealer, BlackJackPlayer player, Deck deck) throws TwentyOne, Bust
	{
		this.dealer = dealer;
		this.deck = deck;
		GameSession.println("It is now the dealers turn" + "\n");
		drawCards();
	}
	
	private void drawCards() throws TwentyOne, Bust
	{
		boolean trigger = true;
		while (trigger)
		{
			if (dealer.getScore() < 17)
			{
				Card card = deck.dealCard();
				GameSession.println("The dealer drew a " + card + "\n");
				dealer.cardDrawn(card);
				if (dealer.getScore() == 21)
				{
					throw new TwentyOne();
				}
				else if (dealer.getScore() > 21)
				{
					throw new Bust();
				}
			}
			else 
			{
				GameSession.println("The dealer has decided not to draw." + "\n");
				GameSession.println("The dealer has ended their turn." + "\n");
				trigger = false;
			}
		}
	}
	
}
