public class BlackJackPlayer extends Player 
{
	
	public BlackJackPlayer() {
		winMoney(1000);
	}
	
	@Override // handle aces in controller
	public int getScore() 
	{
		if (hand == null)
		{
			throw new RuntimeException("Empty hand!");
		}
		return hand.stream().mapToInt(i -> i.getPoints()).sum();
	}
}
