public class BlackJackDealer extends Player 
{
	public BlackJackDealer() {
		winMoney(10000);
	}
	
	public Card getFaceDownCard()
	{
		return hand.get(0);
	}
	
	@Override
	public int getScore() 
	{
		int score = 0;
		if (hand == null)
		{
			throw new RuntimeException("Empty hand!");
		}
		for (Card card : hand)
		{
			if (card.getValue() == 1)
			{
				if (score <= 6)
				{
					score += 11;
				}
				else 
				{
					score += 1;
				}
			}
			else 
			{
				score += card.getPoints();
			}
		}
		return score;
	}
}
